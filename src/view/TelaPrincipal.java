import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TelaPrincipal extends JFrame {

    private JPanel painelAniversarios;

    public TelaPrincipal() {
        setTitle("Sistema - Aniversariantes");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criando a barra de menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem sair = new JMenuItem("Sair");
        sair.addActionListener(e -> System.exit(0));
        menuArquivo.add(sair);
        menuBar.add(menuArquivo);
        setJMenuBar(menuBar);

        // Painel central
        painelAniversarios = new JPanel();
        painelAniversarios.setLayout(new BoxLayout(painelAniversarios, BoxLayout.Y_AXIS));
        painelAniversarios.setBorder(BorderFactory.createTitledBorder("Aniversariantes"));

        // Preenche aniversariantes
        mostrarAniversariantes();

        add(new JScrollPane(painelAniversarios), BorderLayout.CENTER);
    }

    private void mostrarAniversariantes() {
        painelAniversarios.removeAll();

        List<String> hoje = buscarAniversariantes(true);
        List<String> amanha = buscarAniversariantes(false);

        painelAniversarios.add(new JLabel("Aniversariantes de HOJE:"));
        if (hoje.isEmpty()) {
            painelAniversarios.add(new JLabel(" - Nenhum"));
        } else {
            for (String nome : hoje) {
                painelAniversarios.add(new JLabel(" - " + nome));
            }
        }

        painelAniversarios.add(Box.createVerticalStrut(15));

        painelAniversarios.add(new JLabel("Aniversariantes de AMANHÃ:"));
        if (amanha.isEmpty()) {
            painelAniversarios.add(new JLabel(" - Nenhum"));
        } else {
            for (String nome : amanha) {
                painelAniversarios.add(new JLabel(" - " + nome));
            }
        }

        painelAniversarios.revalidate();
        painelAniversarios.repaint();
    }

    private List<String> buscarAniversariantes(boolean hoje) {
        List<String> lista = new ArrayList<>();
        String sql =
            "SELECT c.nomeCliente, t.foneCliente1 " +
            "FROM cliente c " +
            "JOIN (SELECT idCliente, MIN(idTelefone) AS idTelefone FROM telefone GROUP BY idCliente) tt " +
            "  ON c.idCliente = tt.idCliente " +
            "JOIN telefone t ON t.idTelefone = tt.idTelefone " +
            "WHERE DATE_FORMAT(STR_TO_DATE(c.dtnCliente, '%d/%m/%Y'), '%m-%d') = " +
            (hoje ? "DATE_FORMAT(CURDATE(), '%m-%d')" : "DATE_FORMAT(CURDATE() + INTERVAL 1 DAY, '%m-%d')") +
            " ORDER BY SUBSTRING(c.dtnCliente, 1, 2) ASC";

        try (Connection conn = DriverManager.getConnection(
                 "jdbc:mysql://localhost:3306/crud?characterEncoding=utf-8", "dba", "angerus@025507");
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                String nome = rs.getString("nomeCliente");
                String telefone = rs.getString("foneCliente1");
                lista.add(nome + " (" + telefone + ")");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao buscar aniversariantes:\n" + e.getMessage());
        }

        return lista;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }
}
