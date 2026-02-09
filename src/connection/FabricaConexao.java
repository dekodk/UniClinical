package connection;

import java.sql.*;
import javax.swing.*;

public class FabricaConexao {
    // url do banco: ip , porta , banco
    private static final String URL_BD = "jdbc:mysql://localhost:3306/crud?characterEncoding=utf-8";
    private static final String USER_BD = "dba";
    private static final String PWD_BD = "angerus@025507";
    
    public static Connection getConnection(){
        Connection conexao = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL_BD, USER_BD, PWD_BD);
            return conexao;
        }catch(ClassNotFoundException e){
            System.err.println(e);
        }catch(SQLException e){
            System.err.println(e);
        }
        return null;
    }
    private Connection conexao1;
    public Statement statement;
    public ResultSet resultset;

    public void conecta() {
        try {
            conexao1 = DriverManager.getConnection(URL_BD, USER_BD, PWD_BD);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o servidor MYSQL", "ATEN«AO", (2));
        }
    }

    public void desconecta() {
        try {
            conexao1.close();
        } catch (SQLException fech) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexao com o banco de dados" + fech);
        }
    }

    public void executaSQL(String sql) {
        try {
            statement = conexao1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Nao foi poss√≠vel executar o comando sql"
                    + "" + sqlex + "O comando passado foi" + sql);
        }
    }
}
