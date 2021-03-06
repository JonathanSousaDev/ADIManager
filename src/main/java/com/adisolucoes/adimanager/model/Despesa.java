package com.adisolucoes.adimanager.model;

import com.adisolucoes.adimanager.enumerations.StatusDespesa;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jonathan Sousa
 */
@Entity
@Table(name = "tab_despesas")
public class Despesa implements Serializable {

    private Long id;
    private String descricao;
    private Date dataInicio;
    private Date dataVencimento;
    private CategoriaLancamento categoriaLancamento;
    private BigDecimal valor;
    private String formaPagamento;
    private boolean pago;
    private Date dataPagamento;
    private Cliente cliente;
    private StatusDespesa statusDespesa;

    public Despesa() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_inicio", nullable = false)
    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_vencimento", nullable = false)
    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    @ManyToOne
    @JoinColumn(name = "tab_categorias_lancamentos_id", nullable = false)
    public CategoriaLancamento getCategoriaLancamento() {
        return categoriaLancamento;
    }

    public void setCategoriaLancamento(CategoriaLancamento categoriaLancamento) {
        this.categoriaLancamento = categoriaLancamento;
    }

    @Column(nullable = false, precision = 20, scale = 2)
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Column(name = "forma_pagamento", nullable = false, length = 25)
    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Column(name = "pago")
    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_pagamento", nullable = false)
    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    @ManyToOne
    @JoinColumn(name = "tab_clientes_id")
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "status_empresa")
    public StatusDespesa getStatusDespesa() {
        return statusDespesa;
    }

    public void setStatusDespesa(StatusDespesa statusDespesa) {
        this.statusDespesa = statusDespesa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Despesa other = (Despesa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
