package entidade;

public class Colaborador {
    private int idUser;
    private String idLogin;
    private String idSenha;
    private String nomeUser;
    private String nivel;
    
    //no banco de dados todo user está como o campo "ativo" marcado como 1 por default (adicionado automaticamente).
    //Por isso nao consta no sistema como campo para ser cadastrado, apenas atualizado quando for fazer inativação.
    //1 = ativo
    //0 = inativo
    //nivel = 1 administrador cadastra tudo (clientes, agendamentos, usuarios, insumos e procedimentos).
    //nivel = 2 usuario comum, cadastra apenas clientes e agendamentos.

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(String idLogin) {
        this.idLogin = idLogin;
    }

    public String getIdSenha() {
        return idSenha;
    }

    public void setIdSenha(String idSenha) {
        this.idSenha = idSenha;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
        
        
}

   