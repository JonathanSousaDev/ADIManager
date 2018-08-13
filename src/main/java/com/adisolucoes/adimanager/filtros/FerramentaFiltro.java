package com.adisolucoes.adimanager.filtros;

import com.adisolucoes.adimanager.model.Projeto;

/**
 *
 * @author ADI Soluções
 */
public class FerramentaFiltro implements LazyFiltro {

    private Integer primeiro;
    private Integer quantidade;
    private boolean count;
    private boolean paga;
    private boolean todas;
    private String nome;
    private String desenvolvedora;
    private Projeto projeto;

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isCount() {
        return count;
    }

    public void setCount(boolean count) {
        this.count = count;
    }

    public Integer getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Integer primeiro) {
        this.primeiro = primeiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public boolean isPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    public boolean isTodas() {
        return todas;
    }

    public void setTodas(boolean todas) {
        this.todas = todas;
    }

}
