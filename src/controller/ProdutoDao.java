package controller;

import entidade.Produto;
import java.util.ArrayList;
import java.sql.*;
import connection.FabricaConexao;

public class ProdutoDao {
    
    public ArrayList<Produto> produtos = new ArrayList<Produto>();
    
    public boolean inserir (Produto produto){
        
        Connection conexao = (Connection) FabricaConexao.getConnection();
        
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("INSERT INTO produto(idProduto, descProduto, valorProduto, validadeProduto, loteProduto, marcaProduto, fornecedorProduto) VALUES (?,?,?,?,?,?,?)");
            pstm.setInt(1, produto.getIdProduto());
            pstm.setString(2, produto.getDescProduto());
            pstm.setString(3, produto.getValorProduto());
            pstm.setString(4, produto.getValidadeProduto());
            pstm.setString(5, produto.getLoteProduto());
            pstm.setString(6, produto.getMarcaProduto());
            pstm.setString(7, produto.getFornecedorProduto());
            
            int linhas = pstm.executeUpdate();
            conexao.close();
            return (linhas > 0) ? true : false;
            
        } catch (Exception e) {
            System.err.println(e);
        }finally {
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
    
    public boolean atualizar (Produto produto){
        
        Connection conexao = (Connection) FabricaConexao.getConnection();
        
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("UPDATE produto SET descProduto=?, valorProduto=?, validadeProduto=?, loteProduto=?, marcaProduto=?, fornecedorProduto=? WHERE idProduto=? and ativo=1;");
            pstm.setString(1, produto.getDescProduto());
            pstm.setString(2, produto.getValorProduto());
            pstm.setString(3, produto.getValidadeProduto());
            pstm.setString(4, produto.getLoteProduto());
            pstm.setString(5, produto.getMarcaProduto());
            pstm.setString(6, produto.getFornecedorProduto());
            pstm.setInt(7, produto.getIdProduto());
            
            int linhas = pstm.executeUpdate();
            conexao.close();
            return (linhas > 0) ? true : false;
            
        } catch (Exception e) {
            System.err.println(e);
        }finally {
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
    
    public Produto buscar (int idProduto){
        
        Produto produto = new Produto();
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("SELECT * FROM produto WHERE idProduto=? and ativo=1;");
            pstm.setInt(1, idProduto);
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()){
                produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setDescProduto(rs.getString("descProduto"));
                produto.setValorProduto(rs.getString("valorProduto"));
                produto.setValidadeProduto(rs.getString("validadeProduto"));
                produto.setLoteProduto(rs.getString("loteProduto"));
                produto.setMarcaProduto(rs.getString("marcaProduto"));
                produto.setFornecedorProduto(rs.getString("fornecedorProduto"));
            }
            
            conexao.close();
            return produto;
            
        } catch (Exception e) {
            System.err.println(e);
        }finally {
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
    
    public boolean inativar (int idProduto){
        
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("UPDATE procedimento SET ativo = 0 WHERE IdProcedimento = ? and ativo=1;");
            pstm.setInt(1, idProduto);
            
            int linhas = pstm.executeUpdate();
            conexao.close();
            return (linhas > 0) ? true : false;
            
        } catch (Exception e) {
            System.err.println(e);
        }finally {
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
    
    public ArrayList<Produto> getListaProduto(){
        
        Produto produto = new Produto();
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("SELECT * from produto where ativo=1 order by descProduto;");
            
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setDescProduto(rs.getString("descProduto"));
                produto.setValorProduto(rs.getString("valorProduto"));
                produto.setValidadeProduto(rs.getString("validadeProduto"));
                produto.setLoteProduto(rs.getString("loteProduto"));
                produtos.add(produto);
            }
            
            conexao.close();
            return produtos;
            
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
