package entidade;

import java.util.Date;

public class ContasReceber {
    
    private int car_id;
    private int idAgendamento;
    private int idCliente;
    private float valor_base;
    private float desconto_acrescimo;
    private float acrescimo;
    private float valor_final;
    private java.util.Date data_prevista;
    private java.util.Date data_pagamento;
    private String forma_pagamento;
    private String observacao_pag;
    private String status;
    private String origem;

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }
    
    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public float getValor_base() {
        return valor_base;
    }

    public void setValor_base(float valor_base) {
        this.valor_base = valor_base;
    }

    public float getDesconto_acrescimo() {
        return desconto_acrescimo;
    }

    public void setDesconto_acrescimo(float desconto_acrescimo) {
        this.desconto_acrescimo = desconto_acrescimo;
    }

    public float getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(float acrescimo) {
        this.acrescimo = acrescimo;
    }

    public float getValor_final() {
        return valor_final;
    }

    public void setValor_final(float valor_final) {
        this.valor_final = valor_final;
    }

    

    public Date getData_prevista() {
        return data_prevista;
    }

    public void setData_prevista(Date data_prevista) {
        this.data_prevista = data_prevista;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public String getObservacao_pag() {
        return observacao_pag;
    }

    public void setObservacao_pag(String observacao_pag) {
        this.observacao_pag = observacao_pag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
    
    
    
}
