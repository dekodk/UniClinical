package view;

import javax.swing.*;
import java.awt.*;

public class CadDespesas2 extends JFrame {

    private Color amarelo = new Color(255, 255, 153);

    public CadDespesas2() {
        setTitle("Cadastro de Entrada de Despesa");
        setSize(900, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int y = 0;

        // ===== Linha 1 =====
        addCampo(painel, gbc, 0, y, "Código:", campoTexto(8));
        addCampo(painel, gbc, 2, y, "Nº NF:", campoTexto(8));
        addCampo(painel, gbc, 4, y, "Série:", campoTexto(6));
        y++;

        // ===== Linha 2 =====
        addCampo(painel, gbc, 0, y, "Filial:", campoTexto(10));
        addCampo(painel, gbc, 2, y, "Tipo Ordem:", combo());
        addCampo(painel, gbc, 4, y, "Situação:", combo());
        y++;

        // ===== Linha 3 =====
        addCampo(painel, gbc, 0, y, "Chave NFE:", campoTexto(40), 6);
        y++;

        // ===== Linha 4 =====
        addCampo(painel, gbc, 0, y, "Data Emissão:", campoTexto(10));
        addCampo(painel, gbc, 2, y, "Data Lançamento:", campoTexto(10));
        addCampo(painel, gbc, 4, y, "Data Vencimento:", campoTexto(10));
        y++;

        // ===== Linha 5 =====
        addCampo(painel, gbc, 0, y, "Valor Despesa:", campoTexto(10));
        addCampo(painel, gbc, 2, y, "Fornecedor:", campoTexto(30), 4);
        y++;

        // ===== Linha 6 =====
        addCampo(painel, gbc, 0, y, "Aplicação:", campoTexto(40), 6);
        y++;

        // ===== Linha 7 =====
        addArea(painel, gbc, 0, y, "Observação:");
        y++;

        add(painel);
    }

    // ================= MÉTODOS AUXILIARES =================

    private JTextField campoTexto(int colunas) {
        JTextField txt = new JTextField(colunas);
        txt.setBackground(amarelo);
        return txt;
    }

    private JComboBox<String> combo() {
        JComboBox<String> cb = new JComboBox<>();
        cb.setBackground(amarelo);
        return cb;
    }

    private void addCampo(JPanel p, GridBagConstraints gbc, int x, int y,
                          String label, JComponent campo) {
        gbc.gridx = x;
        gbc.gridy = y;
        p.add(new JLabel(label), gbc);

        gbc.gridx = x + 1;
        p.add(campo, gbc);
    }

    private void addCampo(JPanel p, GridBagConstraints gbc, int x, int y,
                          String label, JComponent campo, int largura) {
        gbc.gridx = x;
        gbc.gridy = y;
        p.add(new JLabel(label), gbc);

        gbc.gridx = x + 1;
        gbc.gridwidth = largura;
        p.add(campo, gbc);
        gbc.gridwidth = 1;
    }

    private void addArea(JPanel p, GridBagConstraints gbc, int x, int y, String label) {
        gbc.gridx = x;
        gbc.gridy = y;
        p.add(new JLabel(label), gbc);

        JTextArea area = new JTextArea(3, 50);
        area.setBackground(amarelo);
        JScrollPane scroll = new JScrollPane(area);

        gbc.gridx = x + 1;
        gbc.gridwidth = 6;
        p.add(scroll, gbc);
        gbc.gridwidth = 1;
    }

    // ================= MAIN =================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CadDespesas2().setVisible(true));
    }
}
