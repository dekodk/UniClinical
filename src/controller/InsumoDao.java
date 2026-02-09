package controller;

import entidade.Insumo;
import java.util.ArrayList;
import java.sql.*;
import connection.FabricaConexao;

public class InsumoDao {
    
    public ArrayList<Insumo> insumos = new ArrayList<Insumo>();
    
    public boolean inserir(Insumo insumos){
        
        Connection conexao = (Connection) FabricaConexao.getConnection();
        
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("INSERT INTO insumo(idInsumo, nomeInsumo) VALUES(?,?)");
            pstm.setInt(1, insumos.getIdInsumo());
            pstm.setString(2, insumos.getNomeInsumo());
            
            int linhas = pstm.executeUpdate();
            conexao.close();
            return (linhas > 0) ? true : false;
            
        } catch (Exception e) {
            System.err.println(e);
        } finally{
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

    public boolean atualizar(Insumo insumo) {

        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("UPDATE insumo SET nomeInsumo=? WHERE idInsumo=? and ativo=1;");
            pstm.setString(1, insumo.getNomeInsumo());
            pstm.setInt(2, insumo.getIdInsumo());
            
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
    
    public Insumo buscar (int idInsumo){
        
        Insumo insumo = new Insumo();
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("SELECT * FROM insumo WHERE idInsumo=? and ativo=1;");
            pstm.setInt(1, idInsumo);
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()){
                insumo = new Insumo();
                insumo.setIdInsumo(rs.getInt("idInsumo"));
                insumo.setNomeInsumo(rs.getString("nomeInsumo"));
            }
            
            conexao.close();
            return insumo;
            
        } catch (Exception e) {
            System.err.println(e);
        } finally{
            if (conexao != null){
                try {
                    conexao.close();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }
        return null;
    }
    
    public boolean inativar(int idInsumo){
        
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("UPDATE insumo SET ativo = 0 WHERE idInsumo = ? and ativo=1;");
            pstm.setInt(1, idInsumo);
            
            int linhas = pstm.executeUpdate();
            conexao.close();
            return (linhas > 0) ? true : false;
                        
        } catch (Exception e) {
            System.err.println(e);
        }finally{
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
    
    public ArrayList<Insumo> getListaInsumo(){
        
        Insumo insumo = new Insumo();
        ArrayList<Insumo> insumos = new ArrayList<Insumo>();
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("SELECT * from insumo where ativo=1 order by nomeInsumo;");
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()){
                insumo = new Insumo();
                insumo.setIdInsumo(rs.getInt("idInsumo"));
                insumo.setNomeInsumo(rs.getString("nomeInsumo"));
                insumos.add(insumo);
            }
            
            conexao.close();
            
            return insumos;
            
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