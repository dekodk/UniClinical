package controller;

import entidade.Cliente;
import entidade.Telefone;
import java.util.ArrayList;
import java.sql.*;
import connection.FabricaConexao;
import entidade.Email;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDao {

    public ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public boolean inserirCliente(Cliente cliente) {

        Connection conexao = (Connection) FabricaConexao.getConnection();

        try {
            PreparedStatement pstmCliente = (PreparedStatement) conexao.prepareStatement("INSERT INTO cliente(idCliente, nomeCliente, cpfCliente, rgCliente, dtnCliente) VALUES (?,?,?,?,?)");
            pstmCliente.setInt(1, cliente.getIdCliente());
            pstmCliente.setString(2, cliente.getNomeCliente());
            pstmCliente.setString(3, cliente.getCpfCliente());
            pstmCliente.setString(4, cliente.getRgCliente());
            pstmCliente.setString(5, cliente.getDtnCliente());

            int linhas = pstmCliente.executeUpdate();
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

    public boolean inserirEnd(Cliente cliente) {

        Connection conexao = (Connection) FabricaConexao.getConnection();

        try {
            PreparedStatement pstmCliente = (PreparedStatement) conexao.prepareStatement("INSERT INTO endereco(idCliente, cepEndereco, lograEndereco, compleEndereco, unidadeEndereco, bairroEndereco, cidadeEndereco, estadoEndereco) VALUES (?,?,?,?,?,?,?,?)");
            pstmCliente.setInt(1, cliente.getIdCliente());
            pstmCliente.setString(2, cliente.getCepEndereco());
            pstmCliente.setString(3, cliente.getLograEndereco());
            pstmCliente.setString(4, cliente.getCompleEndereco());
            pstmCliente.setString(5, cliente.getUnidadeEndereco());
            pstmCliente.setString(6, cliente.getBairroEndereco());
            pstmCliente.setString(7, cliente.getCidadeEndereco());
            pstmCliente.setString(8, cliente.getEstadoEndereco());

            int linhas = pstmCliente.executeUpdate();
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

    public boolean inserirHisto(Cliente cliente) {

        Connection conexao = (Connection) FabricaConexao.getConnection();

        try {
            PreparedStatement pstmCliente = (PreparedStatement) conexao.prepareStatement("INSERT INTO historico_medico(idCliente, cirurgia, remedio, anticoncepcional, alergia_medicamento, tratamento_medico, pressao_arterial, outro_problema, esta_gestante, problema_rins_figado, fumante, hepatite, diabetes, asma, problema_cardiaco, convulsao, tontura) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmCliente.setInt(1, cliente.getIdCliente());
            pstmCliente.setString(2, cliente.getCirurgia());
            pstmCliente.setString(3, cliente.getRemedio());
            pstmCliente.setString(4, cliente.getAnticoncepcional());
            pstmCliente.setString(5, cliente.getAlergia_medicamento());
            pstmCliente.setString(6, cliente.getTratamento_medico());
            pstmCliente.setString(7, cliente.getPressao_arterial());
            pstmCliente.setString(8, cliente.getOutro_problema());
            pstmCliente.setString(9, cliente.getEsta_gestante());
            pstmCliente.setString(10, cliente.getProblema_rins_figado());
            pstmCliente.setString(11, cliente.getFumante());
            pstmCliente.setString(12, cliente.getHepatite());
            pstmCliente.setString(13, cliente.getDiabetes());
            pstmCliente.setString(14, cliente.getAsma());
            pstmCliente.setString(15, cliente.getProblema_cardiaco());
            pstmCliente.setString(16, cliente.getConvulsao());
            pstmCliente.setString(17, cliente.getTontura());

            int linhas = pstmCliente.executeUpdate();
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

    public boolean inserirTel(Cliente cliente) {

        Connection conexao = (Connection) FabricaConexao.getConnection();

        try {

            PreparedStatement pstmCliente = (PreparedStatement) conexao.prepareStatement("INSERT INTO telefone(idCliente, foneCliente1, tipofoneCliente1,foneCliente2, tipofoneCliente2, foneCliente3, tipofoneCliente3) VALUES (?,?,?,?,?,?,?)");

            pstmCliente.setInt(1, cliente.getIdCliente());
            pstmCliente.setString(2, cliente.getFoneCliente1());
            pstmCliente.setString(3, cliente.getTipofoneCliente1());
            pstmCliente.setString(4, cliente.getFoneCliente2());
            pstmCliente.setString(5, cliente.getTipofoneCliente2());
            pstmCliente.setString(6, cliente.getFoneCliente3());
            pstmCliente.setString(7, cliente.getTipofoneCliente3());

            int linhas = pstmCliente.executeUpdate();
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

    public boolean inserirEmail(Cliente cliente) {

        Connection conexao = (Connection) FabricaConexao.getConnection();

        try {

            PreparedStatement pstmCliente = (PreparedStatement) conexao.prepareStatement("INSERT INTO email(idCliente, emailCliente1, emailCliente2) VALUES (?,?,?)");

            pstmCliente.setInt(1, cliente.getIdCliente());
            pstmCliente.setString(2, cliente.getEmailCliente1());
            pstmCliente.setString(3, cliente.getEmailCliente2());
            
            int linhas = pstmCliente.executeUpdate();
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

    public boolean atualizarCliente(Cliente cliente) {

        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {

            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("UPDATE cliente SET nomeCliente=?, cpfCliente=?, rgCliente=?, dtnCliente=? WHERE idCliente=? and ativo=1;");
            pstm.setString(1, cliente.getNomeCliente());
            pstm.setString(2, cliente.getCpfCliente());
            pstm.setString(3, cliente.getRgCliente());
            pstm.setString(4, cliente.getDtnCliente());
            pstm.setInt(5, cliente.getIdCliente());

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

    public boolean atualizarEnd(Cliente cliente) {

        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {

            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("UPDATE endereco SET cepEndereco=?, lograEndereco=?, compleEndereco=?, unidadeEndereco=?, bairroEndereco=?, cidadeEndereco=?, estadoEndereco=? WHERE idCliente=?;");
            pstm.setString(1, cliente.getCepEndereco());
            pstm.setString(2, cliente.getLograEndereco());
            pstm.setString(3, cliente.getCompleEndereco());
            pstm.setString(4, cliente.getUnidadeEndereco());
            pstm.setString(5, cliente.getBairroEndereco());
            pstm.setString(6, cliente.getCidadeEndereco());
            pstm.setString(7, cliente.getEstadoEndereco());
            pstm.setInt(8, cliente.getIdCliente());

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

    public boolean atualizarHisto(Cliente cliente) {

        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {

            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("UPDATE historico_medico SET cirurgia=?, remedio=?, anticoncepcional=?, alergia_medicamento=?, tratamento_medico=?, pressao_arterial=?, outro_problema=?, esta_gestante=?, problema_rins_figado=?, fumante=?, hepatite=?, diabetes=?, asma=?, problema_cardiaco=?, convulsao=?, tontura=? WHERE idCliente=?;");
            pstm.setString(1, cliente.getCirurgia());
            pstm.setString(2, cliente.getRemedio());
            pstm.setString(3, cliente.getAnticoncepcional());
            pstm.setString(4, cliente.getAlergia_medicamento());
            pstm.setString(5, cliente.getTratamento_medico());
            pstm.setString(6, cliente.getPressao_arterial());
            pstm.setString(7, cliente.getOutro_problema());
            pstm.setString(8, cliente.getEsta_gestante());
            pstm.setString(9, cliente.getProblema_rins_figado());
            pstm.setString(10, cliente.getFumante());
            pstm.setString(11, cliente.getHepatite());
            pstm.setString(12, cliente.getDiabetes());
            pstm.setString(13, cliente.getAsma());
            pstm.setString(14, cliente.getProblema_cardiaco());
            pstm.setString(15, cliente.getConvulsao());
            pstm.setString(16, cliente.getTontura());
            pstm.setInt(17, cliente.getIdCliente());

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
    
    public boolean atualizarTel(Cliente cliente) {

        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {

            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("UPDATE telefone SET foneCliente1=?, tipofoneCliente1=?,foneCliente2=?, tipofoneCliente2=?, foneCliente3=?, tipofoneCliente3=? WHERE idCliente=?;");
            pstm.setString(1, cliente.getFoneCliente1());
            pstm.setString(2, cliente.getTipofoneCliente1());
            pstm.setString(3, cliente.getFoneCliente2());
            pstm.setString(4, cliente.getTipofoneCliente2());
            pstm.setString(5, cliente.getFoneCliente3());
            pstm.setString(6, cliente.getTipofoneCliente3());
            pstm.setInt(7, cliente.getIdCliente());

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
    
    public boolean atualizarEmail(Cliente cliente) {

        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {

            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("UPDATE email SET emailCliente1=?, emailCliente2=? WHERE idCliente=?;");
            pstm.setString(1, cliente.getEmailCliente1());
            pstm.setString(2, cliente.getEmailCliente2());
            pstm.setInt(3, cliente.getIdCliente());

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

    public Cliente buscarCliente(int idCliente) {

        Cliente cliente = new Cliente();
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("SELECT * FROM cliente where idCliente=? and ativo=1;");
            pstm.setInt(1, idCliente);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNomeCliente(rs.getString("nomeCliente"));
                cliente.setCpfCliente(rs.getString("cpfCliente"));
                cliente.setRgCliente(rs.getString("rgCliente"));
                cliente.setDtnCliente(rs.getString("dtnCliente"));

            }

            conexao.close();
            return cliente;

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

    public Cliente buscarEnd(int idCliente) {

        Cliente cliente = new Cliente();
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("SELECT * FROM endereco where idCliente=?");
            pstm.setInt(1, idCliente);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setLograEndereco(rs.getString("lograEndereco"));
                cliente.setBairroEndereco(rs.getString("bairroEndereco"));
                cliente.setCidadeEndereco(rs.getString("cidadeEndereco"));
                cliente.setEstadoEndereco(rs.getString("estadoEndereco"));
                cliente.setCepEndereco(rs.getString("cepEndereco"));
                cliente.setCompleEndereco(rs.getString("compleEndereco"));
                cliente.setUnidadeEndereco(rs.getString("unidadeEndereco"));
            }

            conexao.close();
            return cliente;

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

    public Cliente buscarTelefone(int idCliente) {

        Cliente cliente = new Cliente();
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("SELECT * FROM telefone where idCliente=?");
            pstm.setInt(1, idCliente);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setFoneCliente1(rs.getString("foneCliente1"));
                cliente.setTipofoneCliente1(rs.getString("tipofoneCliente1"));
                cliente.setFoneCliente2(rs.getString("foneCliente2"));
                cliente.setTipofoneCliente2(rs.getString("tipofoneCliente2"));
                cliente.setFoneCliente3(rs.getString("foneCliente3"));
                cliente.setTipofoneCliente3(rs.getString("tipofoneCliente3"));
            }

            conexao.close();
            return cliente;

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
    
    public Cliente buscarEmail(int idCliente) {

        Cliente cliente = new Cliente();
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("SELECT * FROM email where idCliente=?");
            pstm.setInt(1, idCliente);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setEmailCliente1(rs.getString("emailCliente1"));
                cliente.setEmailCliente2(rs.getString("emailCliente2"));
            }

            conexao.close();
            return cliente;

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

    public Cliente buscarHisto(int idCliente) {

        Cliente cliente = new Cliente();
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("SELECT * FROM historico_medico where idCliente=?");
            pstm.setInt(1, idCliente);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setCirurgia(rs.getString("cirurgia"));
                cliente.setRemedio(rs.getString("remedio"));
                cliente.setAnticoncepcional(rs.getString("anticoncepcional"));
                cliente.setAlergia_medicamento(rs.getString("alergia_medicamento"));
                cliente.setTratamento_medico(rs.getString("tratamento_medico"));
                cliente.setPressao_arterial(rs.getString("pressao_arterial"));
                cliente.setOutro_problema(rs.getString("outro_problema"));
                cliente.setEsta_gestante(rs.getString("esta_gestante"));
                cliente.setProblema_rins_figado(rs.getString("problema_rins_figado"));
                cliente.setFumante(rs.getString("fumante"));
                cliente.setHepatite(rs.getString("hepatite"));
                cliente.setDiabetes(rs.getString("diabetes"));
                cliente.setAsma(rs.getString("asma"));
                cliente.setProblema_cardiaco(rs.getString("problema_cardiaco"));
                cliente.setConvulsao(rs.getString("convulsao"));
                cliente.setTontura(rs.getString("tontura"));
            }

            conexao.close();
            return cliente;

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

    public boolean inativar(int idCliente) {

        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("UPDATE cliente SET ativo = 0 WHERE idCliente = ?;");
            pstm.setInt(1, idCliente);

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

    public ArrayList<Cliente> listaClientes() {

        Cliente cliente2 = new Cliente();
        ArrayList<Cliente> clientes2 = new ArrayList<Cliente>();
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {

            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("select * from cliente where ativo=1 order by nomeCliente;");
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                cliente2 = new Cliente();
                cliente2.setIdCliente(rs.getInt("idCliente"));
                cliente2.setNomeCliente(rs.getString("nomeCliente"));
                cliente2.setCpfCliente(rs.getString("cpfCliente"));
                cliente2.setRgCliente(rs.getString("rgCliente"));
                cliente2.setDtnCliente(rs.getString("dtnCliente"));
                cliente2.setEmailCliente1(rs.getString("emailCliente1"));
                cliente2.setEmailCliente2(rs.getString("emailCliente2"));
                cliente2.setFoneCliente1(rs.getString("foneCliente1"));
                cliente2.setTipofoneCliente1(rs.getString("tipofoneCliente1"));
                cliente2.setFoneCliente2(rs.getString("foneCliente2"));
                cliente2.setTipofoneCliente2(rs.getString("tipofoneCliente2"));
                cliente2.setFoneCliente3(rs.getString("foneCliente3"));
                cliente2.setTipofoneCliente3(rs.getString("tipofoneCliente3"));
                cliente2.setLograEndereco(rs.getString("lograEndereco"));
                cliente2.setBairroEndereco(rs.getString("bairroEndereco"));
                cliente2.setCidadeEndereco(rs.getString("cidadeEndereco"));
                cliente2.setEstadoEndereco(rs.getString("estadoEndereco"));
                cliente2.setUnidadeEndereco(rs.getString("unidadeEndereco"));
                cliente2.setCepEndereco(rs.getString("cepEndereco"));
                cliente2.setCompleEndereco(rs.getString("compleEndereco"));
                clientes2.add(cliente2);
            }

            conexao.close();
            return clientes2;
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

    public ArrayList<Cliente> getListaCliente() {

        Cliente cliente = new Cliente();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {

            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("SELECT \n" +
"  c.idCliente, \n" +
"  c.nomeCliente, \n" +
"  (SELECT MIN(foneCliente1) FROM telefone t WHERE t.idCliente = c.idCliente) AS foneCliente1,\n" +
"  (SELECT MIN(emailCliente1) FROM email em WHERE em.idCliente = c.idCliente) AS emailCliente1\n" +
"FROM cliente c\n" +
"WHERE c.ativo = 1\n" +
"ORDER BY c.nomeCliente;");

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNomeCliente(rs.getString("nomeCliente"));
                cliente.setFoneCliente1(rs.getString("foneCliente1"));
                cliente.setEmailCliente1(rs.getString("emailCliente1"));
                clientes.add(cliente);
            }

            conexao.close();

            return clientes;

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
