package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import controller.ContasReceberDao;
import entidade.ContasReceber;
import java.awt.Dimension;

public class ContaReceberBuscaDialog extends JDialog {

    private JTextField txtCodigo;
    private JTextField txtCliente;
    private com.toedter.calendar.JDateChooser dcInicio;
    private com.toedter.calendar.JDateChooser dcFim;
    private JTable tabela;

    private ContasReceber selecionado;

    public ContaReceberBuscaDialog(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("BUSCAR CONTA A RECEBER");
        setSize(850, 600);
        setLocationRelativeTo(parent);
    }

    public ContasReceber getSelecionado() {
        return selecionado;
    }

    private void initComponents() {

        Font fontePadrao = new Font("Segoe UI", Font.PLAIN, 16);

        setLayout(new BorderLayout());

        JPanel painelFiltro = new JPanel();
        painelFiltro.setLayout(new GridBagLayout());
        painelFiltro.setBorder(BorderFactory.createTitledBorder("FILTROS"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Código
        gbc.gridx = 0;
        gbc.gridy = 0;
        painelFiltro.add(new JLabel("CÓDIGO:"), gbc);

        gbc.gridx = 1;
        txtCodigo = new JTextField();
        txtCodigo.setPreferredSize(new Dimension(70, 30));
        txtCodigo.setFont(fontePadrao);
        painelFiltro.add(txtCodigo, gbc);

        /*// Data início
        gbc.gridx = 0; gbc.gridy = 1;
        painelFiltro.add(new JLabel("Data de:"), gbc);

        gbc.gridx = 1;
        dcInicio = new com.toedter.calendar.JDateChooser();
        dcInicio.setDateFormatString("dd/MM/yyyy");
        painelFiltro.add(dcInicio, gbc);

        gbc.gridx = 2;
        painelFiltro.add(new JLabel("até:"), gbc);

        gbc.gridx = 3;
        dcFim = new com.toedter.calendar.JDateChooser();
        dcFim.setDateFormatString("dd/MM/yyyy");
        painelFiltro.add(dcFim, gbc);*/
        // Data início
        gbc.gridx = 0;
        gbc.gridy = 1;
        painelFiltro.add(new JLabel("DATA DE:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.NONE;   // importante
        dcInicio = new com.toedter.calendar.JDateChooser();
        dcInicio.setDateFormatString("dd/MM/yyyy");
        dcInicio.setPreferredSize(new Dimension(140, 30));
        painelFiltro.add(dcInicio, gbc);

        gbc.gridx = 2;
        painelFiltro.add(new JLabel("ATÉ:"), gbc);

        gbc.gridx = 3;
        dcFim = new com.toedter.calendar.JDateChooser();
        dcFim.setDateFormatString("dd/MM/yyyy");
        dcFim.setPreferredSize(new Dimension(140, 30));
        painelFiltro.add(dcFim, gbc);

        dcInicio.setFont(fontePadrao);
        dcInicio.getDateEditor().getUiComponent().setFont(fontePadrao);

        dcFim.setFont(fontePadrao);
        dcFim.getDateEditor().getUiComponent().setFont(fontePadrao);

        // Cliente
        gbc.gridx = 0;
        gbc.gridy = 2;
        painelFiltro.add(new JLabel("CLIENTE:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 3;
        txtCliente = new JTextField(30);
        txtCliente.setFont(fontePadrao);
        painelFiltro.add(txtCliente, gbc);

        // Aplicar fonte nas labels do painelFiltro
        for (Component c : painelFiltro.getComponents()) {
            if (c instanceof JLabel) {
                c.setFont(fontePadrao);
            }
        }

        add(painelFiltro, BorderLayout.NORTH);

        // TABELA
        tabela = new JTable();
        tabela.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "CLIENTE", "DATA PAGAMENTO", "VALOR", "SITUAÇÃO"}
        ));

        tabela.setFont(fontePadrao);
        tabela.setRowHeight(30);
        tabela.getTableHeader().setFont(fontePadrao);

        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll, BorderLayout.CENTER);

        // Painel botões
        JPanel painelBotoes = new JPanel();

        JButton btnBuscar = new JButton("BUSCAR");
        JButton btnSelecionar = new JButton("SELECIONAR");
        JButton btnCancelar = new JButton("CANCELAR");

        Dimension tamanhoPadrao = new Dimension(130, 40);

        btnBuscar.setPreferredSize(tamanhoPadrao);
        btnSelecionar.setPreferredSize(tamanhoPadrao);
        btnCancelar.setPreferredSize(tamanhoPadrao);

        btnBuscar.setFont(fontePadrao);
        btnSelecionar.setFont(fontePadrao);
        btnCancelar.setFont(fontePadrao);

        painelBotoes.add(btnBuscar);
        painelBotoes.add(btnSelecionar);
        painelBotoes.add(btnCancelar);

        add(painelBotoes, BorderLayout.SOUTH);

        // AÇÕES
        btnBuscar.addActionListener(e -> buscar());
        btnSelecionar.addActionListener(e -> selecionar());
        btnCancelar.addActionListener(e -> dispose());

        // Duplo clique seleciona
        tabela.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    selecionar();
                }
            }
        });
    }

    private void buscar() {

        try {

            Integer id = txtCodigo.getText().trim().isEmpty()
                    ? null
                    : Integer.parseInt(txtCodigo.getText().trim());

            Date dataInicio = dcInicio.getDate();
            Date dataFim = dcFim.getDate();

            String cliente = txtCliente.getText().trim();

            ContasReceberDao dao = new ContasReceberDao();
            List<ContasReceber> lista = dao.buscar(id, dataInicio, dataFim, cliente);

            preencherTabela(lista);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao buscar: " + e.getMessage());
        }
    }

    private void preencherTabela(List<ContasReceber> lista) {

        DefaultTableModel model
                = (DefaultTableModel) tabela.getModel();

        model.setRowCount(0);

        SimpleDateFormat sdf
                = new SimpleDateFormat("dd/MM/yyyy");

        for (ContasReceber cr : lista) {

            model.addRow(new Object[]{
                cr.getCar_id(),
                cr.getNomeCliente(),
                cr.getData_pagamento() != null
                ? sdf.format(cr.getData_pagamento()) : "",
                cr.getValor_final(),
                cr.getStatus()
            });
        }
    }

    private void selecionar() {

        int linha = tabela.getSelectedRow();

        if (linha >= 0) {

            Integer id
                    = (Integer) tabela.getValueAt(linha, 0);

            try {
                ContasReceberDao dao = new ContasReceberDao();

                selecionado = dao.buscarPorId(id);

                dispose();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                        "Erro ao selecionar: " + e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(this,
                    "Selecione um registro.");
        }
    }

}
