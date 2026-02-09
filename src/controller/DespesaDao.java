package controller;

import connection.FabricaConexao;
import entidade.Despesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;



public class DespesaDao {
    
    public ArrayList<Despesa> depesas = new ArrayList<Despesa>();
    
    public boolean inserirDespesa(Despesa despesa){
        
    Connection conexao = (Connection) FabricaConexao.getConnection();

    try{
        PreparedStatement pstmdespesa = (PreparedStatement) conexao.prepareStatement("INSERT INTO despesa (codDesp, NFeDesp, SituacaoDesp,nrSerieDesp, chaveNFeDesp, dataEmisDesp, dataVencDesp, valorDesp, nomeFornecedor, observDesp)values (?,?,?,?,?,?,?,?,?,?)");
        pstmdespesa.setInt(1, despesa.getCodDesp());
        pstmdespesa.setString(2, despesa.getNFeDesp());
        pstmdespesa.setString(3, despesa.getSituacaoDesp());
        pstmdespesa.setString(4, despesa.getNrSerieDesp());
        pstmdespesa.setString(5, despesa.getChaveNFeDesp());
        java.sql.Date dataEmis = new java.sql.Date(despesa.getDataEmisDesp().getTime());
        pstmdespesa.setDate(6, dataEmis);
        java.sql.Date dataVenc = new java.sql.Date(despesa.getDateVencDesp().getTime());
        pstmdespesa.setDate(7, dataVenc);
        pstmdespesa.setFloat(8, despesa.getValorDesp());
        pstmdespesa.setString(9, despesa.getNomeFornecedor());
        pstmdespesa.setString(10, despesa.getObservDesp());
        
        int linhas = pstmdespesa.executeUpdate();
            conexao.close();
            return (linhas > 0) ? true : false;
        
    }catch (Exception e){
        System.err.println(e);
    } finally {
        if (conexao != null) {
                try {
                    conexao.close();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
    }return false;
    }
    
    public boolean inativarDesp(int codDesp){
        
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try{
            PreparedStatement pstmInatDesp = (PreparedStatement) conexao.prepareStatement("UPDATE set despesa ativo = 0 where codDesp = ? ativo = 1");
            pstmInatDesp.setInt(1, codDesp);
            
            int linhas = pstmInatDesp.executeUpdate();
            conexao.close();
            return (linhas > 0) ? true : false;
            
        }catch (Exception e) {
            System.err.println(e);
        }finally {
            if (conexao != null){
                try {
                    conexao.close();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }return false;
    }
    
    
    
}
