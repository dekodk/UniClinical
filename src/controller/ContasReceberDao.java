package controller;

import entidade.Cliente;
import java.util.ArrayList;
import java.sql.*;
import connection.FabricaConexao;
import entidade.ContasReceber;
import java.util.List;
import javax.swing.JOptionPane;
import util.DateUtils;

public class ContasReceberDao {

    public ArrayList<ContasReceber> contasrecebers = new ArrayList<ContasReceber>();

    public boolean inserirContasReceber(ContasReceber contasreceber) {

        Connection conexao = (Connection) FabricaConexao.getConnection();

        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("INSERT INTO contas_a_receber (car_id, idAgendamento, idCliente, valor_final, data_pagamento, data_prevista, forma_pagamento, status, origem) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            pstm.setInt(1, contasreceber.getCar_id());
            pstm.setInt(2, contasreceber.getIdAgendamento());
            pstm.setInt(3, contasreceber.getIdCliente());
            pstm.setFloat(4, contasreceber.getValor_final());

            java.sql.Date dataPag = new java.sql.Date(contasreceber.getData_pagamento().getTime());
            pstm.setDate(5, dataPag);

            java.sql.Date dataPrev = new java.sql.Date(contasreceber.getData_prevista().getTime());
            pstm.setDate(6, dataPrev);

            pstm.setString(7, contasreceber.getForma_pagamento());
            pstm.setString(8, contasreceber.getStatus());
            pstm.setString(9, contasreceber.getOrigem());

            int linhas = pstm.executeUpdate();
            conexao.close();
            return (linhas > 0) ? true : false;

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }
        return false;
    }

    public List<ContasReceber> buscar(
            Integer id,
            java.util.Date dataInicio,
            java.util.Date dataFim,
            String cliente) throws Exception {

        Connection conexao = (Connection) FabricaConexao.getConnection();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT cr.*, c.nomeCliente AS nome_cliente ");
        sql.append("FROM contas_a_receber cr ");
        sql.append("JOIN cliente c ON c.idCliente = cr.idCliente ");
        sql.append("WHERE 1=1 ");

        List<Object> params = new ArrayList<>();

        if (id != null) {
            sql.append("AND cr.car_id = ? ");
            params.add(id);
        }

        if (dataInicio != null && dataFim != null) {
            sql.append("AND cr.data_pagamento BETWEEN ? AND ? ");
            params.add(new java.sql.Date(dataInicio.getTime()));
            params.add(new java.sql.Date(dataFim.getTime()));
        }

        if (cliente != null && !cliente.trim().isEmpty()) {
            sql.append("AND UPPER(c.nome) LIKE ? ");
            params.add("%" + cliente.toUpperCase() + "%");
        }

        PreparedStatement ps = conexao.prepareStatement(sql.toString());

        for (int i = 0; i < params.size(); i++) {
            ps.setObject(i + 1, params.get(i));
        }

        ResultSet rs = ps.executeQuery();

        List<ContasReceber> lista = new ArrayList<>();

        while (rs.next()) {
            ContasReceber cr = new ContasReceber();
            cr.setCar_id(rs.getInt("car_id"));
            cr.setIdCliente(rs.getInt("idCliente"));
            cr.setIdAgendamento(rs.getInt("idAgendamento"));
            cr.setData_pagamento(rs.getDate("data_pagamento"));
            cr.setData_prevista(rs.getDate("data_prevista"));
            cr.setValor_final(rs.getFloat("valor_final"));
            cr.setStatus(rs.getString("status"));
            cr.setForma_pagamento(rs.getString("forma_pagamento"));
            cr.setOrigem(rs.getString("origem"));
            cr.setNomeCliente(rs.getString("nome_cliente"));

            lista.add(cr);
        }

        return lista;
    }

    public ContasReceber buscarPorId(Integer id) throws Exception {

        Connection conexao = (Connection) FabricaConexao.getConnection();

        String sql
                = "SELECT cr.*, c.nomeCliente AS nome_cliente "
                + "FROM contas_a_receber cr "
                + "JOIN cliente c ON c.idCliente = cr.idCliente "
                + "WHERE cr.car_id = ?";

        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            ContasReceber cr = new ContasReceber();

            cr.setCar_id(rs.getInt("car_id"));
            cr.setIdCliente(rs.getInt("idCliente"));
            cr.setIdAgendamento(rs.getInt("idAgendamento"));
            cr.setData_pagamento(rs.getDate("data_pagamento"));
            cr.setData_prevista(rs.getDate("data_prevista"));
            cr.setValor_final(rs.getFloat("valor_final"));
            cr.setStatus(rs.getString("status"));
            cr.setForma_pagamento(rs.getString("forma_pagamento"));
            cr.setOrigem(rs.getString("origem"));
            cr.setNomeCliente(rs.getString("nome_cliente"));

            return cr;
        }

        return null;
    }

}
