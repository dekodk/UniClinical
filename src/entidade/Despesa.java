package entidade;

import java.util.Date;


public class Despesa {
    
    private int codDesp;
    private String NFeDesp;
    private String situacaoDesp;
    private String nrSerieDesp;
    private String chaveNFeDesp;
    private java.util.Date dataEmisDesp;
    private java.util.Date dateVencDesp;
    private float valorDesp;
    private String nomeFornecedor;
    private String observDesp;

    public int getCodDesp() {
        return codDesp;
    }

    public void setCodDesp(int codDesp) {
        this.codDesp = codDesp;
    }

    public String getNFeDesp() {
        return NFeDesp;
    }

    public void setNFeDesp(String NFeDesp) {
        this.NFeDesp = NFeDesp;
    }  

    public String getSituacaoDesp() {
        return situacaoDesp;
    }

    public void setSituacaoDesp(String situacaoDesp) {
        this.situacaoDesp = situacaoDesp;
    }

    public String getNrSerieDesp() {
        return nrSerieDesp;
    }

    public void setNrSerieDesp(String nrSerieDesp) {
        this.nrSerieDesp = nrSerieDesp;
    }

    public String getChaveNFeDesp() {
        return chaveNFeDesp;
    }

    public void setChaveNFeDesp(String chaveNFeDesp) {
        this.chaveNFeDesp = chaveNFeDesp;
    }

    public Date getDataEmisDesp() {
        return dataEmisDesp;
    }

    public void setDataEmisDesp(Date dataEmisDesp) {
        this.dataEmisDesp = dataEmisDesp;
    }

    public Date getDateVencDesp() {
        return dateVencDesp;
    }

    public void setDateVencDesp(Date dateVencDesp) {
        this.dateVencDesp = dateVencDesp;
    }

    public float getValorDesp() {
        return valorDesp;
    }

    public void setValorDesp(float valorDesp) {
        this.valorDesp = valorDesp;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getObservDesp() {
        return observDesp;
    }

    public void setObservDesp(String observDesp) {
        this.observDesp = observDesp;
    }
    
    
}
