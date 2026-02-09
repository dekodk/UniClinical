package controller;

import entidade.Agendamento;
import DAO.ConexaoDao;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import connection.FabricaConexao;
import entidade.ContasReceber;
import view.RelAgenda;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import util.DateUtils;

public class AgendamentoDao {

    public int inserirAgendamento(Agendamento agendamento) {

        int idGerado = -1; // se continuar -1 significa que deu erro
        Connection conexao = null;

        try {
            conexao = FabricaConexao.getConnection();

            String sql = "INSERT INTO agendamento "
                    + "(nomeCliente, nomeProcedimento, nomeInsumo, valorProcedimento, valorAdicional, valorTotal, "
                    + "dataAgendamento, horaAgendamento, observacao, situacao, nomeUser, consultorio) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstm.setString(1, agendamento.getNomeCliente());
            pstm.setString(2, agendamento.getNomeProcedimento());
            pstm.setString(3, agendamento.getNomeInsumo());
            pstm.setFloat(4, agendamento.getValorProcedimento());
            pstm.setFloat(5, agendamento.getValorAdicional());
            pstm.setFloat(6, agendamento.getValorTotal());

            java.sql.Date dataSql = new java.sql.Date(agendamento.getDataAgendamento().getTime());
            pstm.setDate(7, dataSql);

            pstm.setString(8, agendamento.getHoraAgendamento());
            pstm.setString(9, agendamento.getObservacao());
            pstm.setInt(10, agendamento.getSituacao());
            pstm.setString(11, agendamento.getNomeUser());
            pstm.setString(12, agendamento.getConsultorio());

            int linhas = pstm.executeUpdate();

            if (linhas > 0) {
                // pegar o ID gerado
                ResultSet rs = pstm.getGeneratedKeys();
                if (rs.next()) {
                    idGerado = rs.getInt(1);
                }
            }

        } catch (Exception e) {
            System.err.println("Erro ao inserir agendamento: " + e);
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
                System.err.println("Erro ao fechar conexão: " + e);
            }
        }

        return idGerado;
    }

    public boolean criarContasReceber(ContasReceber contasreceber) {

        Connection conexao = (Connection) FabricaConexao.getConnection();

        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("INSERT INTO contas_a_receber (idAgendamento, idCliente, valor_base, desconto_acrescimo, valor_final, data_prevista, origem) VALUES (?, ?, ?, ?, ?, ?, ?)");
            pstm.setInt(1, contasreceber.getIdAgendamento());
            pstm.setInt(2, contasreceber.getIdCliente());
            pstm.setFloat(3, contasreceber.getValor_base());
            pstm.setFloat(4, contasreceber.getDesconto_acrescimo());
            pstm.setFloat(5, contasreceber.getValor_final());
            //java.util.Date dataUtil = agendamento.getDataAgendamento();
            //java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
            //pstm.setDate(7, dataSql);
            java.util.Date dataPrev = contasreceber.getData_prevista();
            java.sql.Date dataPrevFor = new java.sql.Date(dataPrev.getTime());
            pstm.setDate(6, dataPrevFor);
            pstm.setString(7, contasreceber.getOrigem());

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

    public ArrayList<Agendamento> getListaAgendamento() {

        Agendamento agendamento = new Agendamento();
        ArrayList<Agendamento> agendamentos = new ArrayList<Agendamento>();
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {

            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("SELECT * from agendamento where situacao=0 order by idAgendamento desc;");

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                agendamento = new Agendamento();
                agendamento.setIdAgendamento(rs.getInt("idAgendamento"));
                agendamento.setNomeCliente(rs.getString("nomeCliente"));
                //agendamento.setDataRel(rs.getString("dataAgendamento"));
                java.sql.Date data = rs.getDate("dataAgendamento");
                String dataFormatada = DateUtils.formatarData(data);
                agendamento.setDataRel(dataFormatada);
                agendamento.setHoraAgendamento(rs.getString("horaAgendamento"));
                agendamento.setNomeProcedimento(rs.getString("nomeProcedimento"));
                agendamento.setValorTotal(rs.getFloat("valorTotal"));
                agendamentos.add(agendamento);
            }

            conexao.close();

            return agendamentos;

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
        return null;
    }

}
