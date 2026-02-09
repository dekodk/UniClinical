package controller;

import entidade.Procedimento;
import java.util.ArrayList;
import java.sql.*;
import connection.FabricaConexao;

public class ProcedimentoDao {
    
    public ArrayList<Procedimento> procedimentos = new ArrayList<Procedimento>();

    public boolean inserir(Procedimento procedimento) {
    
        Connection conexao = (Connection) FabricaConexao.getConnection();

        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("INSERT INTO procedimento(idProcedimento, NomeProcedimento, ValorProcedimento) VALUES (?,?,?)");
            pstm.setInt(1, procedimento.getIdProcedimento());
            pstm.setString(2, procedimento.getNomeProcedimento());
            pstm.setString(3, procedimento.getValorProcedimento());
            

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
    
    public boolean atualizar(Procedimento procedimento) {

        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {

            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("UPDATE procedimento SET NomeProcedimento=?, ValorProcedimento=? WHERE IdProcedimento=? and ativo=1;");
            pstm.setString(1, procedimento.getNomeProcedimento());
            pstm.setString(2, procedimento.getValorProcedimento());
            pstm.setInt(3, procedimento.getIdProcedimento());

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
    
    public Procedimento buscar(int IdProcedimento) {

        Procedimento procedimento = new Procedimento();
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("SELECT * FROM procedimento WHERE IdProcedimento=? and ativo=1;");
            pstm.setInt(1, IdProcedimento);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                procedimento = new Procedimento();
                procedimento.setIdProcedimento(rs.getInt("IdProcedimento"));
                procedimento.setNomeProcedimento(rs.getString("NomeProcedimento"));
                procedimento.setValorProcedimento(rs.getString("ValorProcedimento"));
                
            }

            conexao.close();
            return procedimento;

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
    
    public boolean inativar(int IdProcedimento) {

        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("UPDATE procedimento SET ativo = 0 WHERE IdProcedimento = ? and ativo=1;");
            pstm.setInt(1, IdProcedimento);
            
            int linhas = pstm.executeUpdate();
            conexao.close();
            return (linhas > 0) ? true : false;
            
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (conexao != null){
                try {
                    conexao.close();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }
        return false;
    }
    
    public ArrayList<Procedimento> getListaProcedimento(){
        
        Procedimento procedimento = new Procedimento();
        ArrayList<Procedimento> procedimentos = new ArrayList<Procedimento>();
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("SELECT * from procedimento where ativo=1 order by nomeProcedimento;");
            
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                procedimento = new Procedimento();
                procedimento.setIdProcedimento(rs.getInt("idProcedimento"));
                procedimento.setNomeProcedimento(rs.getString("nomeProcedimento"));
                procedimento.setValorProcedimento(rs.getString("valorProcedimento"));
                procedimentos.add(procedimento);
            }
            
            conexao.close();
            
            return procedimentos;
            
        } catch (Exception e) {
            System.err.println(e);
        }finally{
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
