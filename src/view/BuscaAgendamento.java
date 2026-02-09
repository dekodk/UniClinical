package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.table.DefaultTableCellRenderer;

public class BuscaAgendamento extends JFrame {

    private JTable tabela;
    private JLabel lblTotal;
    private JFormattedTextField txtDataInicio;
    private JFormattedTextField txtDataFim;
    private JComboBox<String> cbTipo; // ComboBox para o filtro
    private Connection conexao;

    public BuscaAgendamento(Connection conexao) {
        this.conexao = conexao;

        setTitle("Busca Agendamento");
        setSize(1100, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel superior para filtros
        JPanel painelFiltros = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        painelFiltros.setBackground(new Color(245, 245, 245));
        painelFiltros.setBorder(BorderFactory.createTitledBorder("Filtro de Período"));

        try {
            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');

            painelFiltros.add(new JLabel("Data Início: "));
            txtDataInicio = new JFormattedTextField(mascara);
            txtDataInicio.setColumns(8);
            painelFiltros.add(txtDataInicio);

            painelFiltros.add(new JLabel("Data Fim: "));
            txtDataFim = new JFormattedTextField(mascara);
            txtDataFim.setColumns(8);
            painelFiltros.add(txtDataFim);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro na máscara de data: " + e.getMessage());
        }

        // ComboBox para filtro de tipo
        cbTipo = new JComboBox<>(new String[]{"Todos", "Abertos", "Fechados"});
        painelFiltros.add(new JLabel("Tipo: "));
        painelFiltros.add(cbTipo);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(60, 179, 113));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFocusPainted(false);
        btnBuscar.setFont(new Font("Arial", Font.BOLD, 12));
        painelFiltros.add(btnBuscar);

        JButton btnImprimir = new JButton("Imprimir");
        btnImprimir.setBackground(new Color(70, 130, 180));
        btnImprimir.setForeground(Color.WHITE);
        btnImprimir.setFocusPainted(false);
        btnImprimir.setFont(new Font("Arial", Font.BOLD, 12));
        painelFiltros.add(btnImprimir);

        // Tabela
        tabela = new JTable(new DefaultTableModel(
                new Object[]{"Número", "Cliente", "Data Atendimento", "Valor", "Situação"}, 0
        ));
        tabela.setFont(new Font("Arial", Font.PLAIN, 13));
        tabela.setRowHeight(22);

        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBorder(BorderFactory.createTitledBorder("Lista"));
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);

        tabela.getColumnModel().getColumn(0).setCellRenderer(center); // Número
        tabela.getColumnModel().getColumn(2).setCellRenderer(center); // Data
        tabela.getColumnModel().getColumn(3).setCellRenderer(center); // Valor
        tabela.getColumnModel().getColumn(4).setCellRenderer(center); // Situação

        // Label total
        JPanel painelRodape = new JPanel(new BorderLayout());
        painelRodape.setBackground(new Color(240, 240, 240));
        lblTotal = new JLabel("Total: R$ 0,00");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 16));
        lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTotal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
        painelRodape.add(lblTotal, BorderLayout.EAST);

        // Layout principal
        setLayout(new BorderLayout(10, 10));
        add(painelFiltros, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(painelRodape, BorderLayout.SOUTH);

        // Eventos
        btnBuscar.addActionListener((ActionEvent e) -> carregarAgendamentos());
        //btnImprimir.addActionListener((ActionEvent e) -> imprimirRelatorio());

    }

    private void carregarAgendamentos() {
        try {
            String dataInicio = txtDataInicio.getText().trim();
            String dataFim = txtDataFim.getText().trim();

            // Converte dd/MM/yyyy -> yyyy-MM-dd (formato do MySQL)
            SimpleDateFormat sdfEntrada = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdfMySQL = new SimpleDateFormat("yyyy-MM-dd");

            String dataIniSQL = sdfMySQL.format(sdfEntrada.parse(dataInicio));
            String dataFimSQL = sdfMySQL.format(sdfEntrada.parse(dataFim));

            String tipoSelecionado = cbTipo.getSelectedItem().toString();
            String sql = "";

            switch (tipoSelecionado) {
                case "Todos":
                    sql = "SELECT idAgendamento, nomeCliente, dataAgendamento, valorTotal, situacao FROM agendamento "
                            + "WHERE DATE(dataAgendamento) BETWEEN ? AND ? "
                            + "ORDER BY dataAgendamento ASC";
                    break;
                case "Abertos":
                    sql = "SELECT idAgendamento, nomeCliente, dataAgendamento, valorTotal, situacao FROM agendamento "
                            + "WHERE DATE(dataAgendamento) BETWEEN ? AND ? AND situacao != 1 "
                            + "ORDER BY dataAgendamento ASC";
                    break;
                case "Fechados":
                    sql = "SELECT idAgendamento, nomeCliente, dataAgendamento, valorTotal, situacao FROM agendamento "
                            + "WHERE DATE(dataAgendamento) BETWEEN ? AND ? AND situacao != 0 "
                            + "ORDER BY dataAgendamento ASC";
                    break;
            }

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, dataIniSQL);
            stmt.setString(2, dataFimSQL);
            
            ResultSet rs = stmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            model.setRowCount(0); // limpar tabela

            double total = 0;

            // Formato dia/mês/ano horas:minutos:segundos
            SimpleDateFormat sdfSaida = new SimpleDateFormat("dd/MM/yyyy");

            while (rs.next()) {
                int id = rs.getInt("idAgendamento");
                String cliente = rs.getString("nomeCliente");
                Timestamp data = rs.getTimestamp("dataAgendamento"); // pega timestamp completo
                double valor = rs.getDouble("valorTotal");
                int status = rs.getInt("situacao");

                total += valor;

                // Formata a data completa
                String dataFormatada = (data != null) ? sdfSaida.format(data) : "";

                model.addRow(new Object[]{id, cliente, dataFormatada, String.format("R$ %.2f", valor), status});
            }

            //lblTotal.setText("Total do período: R$ " + String.format("%.2f", total));
            NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
            nf.setMinimumFractionDigits(2);
            nf.setMaximumFractionDigits(2);

            lblTotal.setText("Total do período: R$ " + nf.format(total));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Connection conexao = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/crud?characterEncoding=utf-8", "dba", "angerus@025507");
        new BuscaAgendamento(conexao).setVisible(true);
    }

}
