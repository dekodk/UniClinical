package entidade;

public class Telefone {
    
    private String tipo;
    private String numero;
    

    public Telefone(String tipo, String numero) {
        this.tipo = tipo;
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNumero() {
        return numero;
    }
}
