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
    
}
