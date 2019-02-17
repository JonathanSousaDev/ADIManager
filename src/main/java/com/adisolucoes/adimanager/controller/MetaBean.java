package com.adisolucoes.adimanager.controller;

import com.adisolucoes.adimanager.dao.MetaDAO;
import com.adisolucoes.adimanager.enumerations.TipoPrioridadeMeta;
import com.adisolucoes.adimanager.filtros.MetaFiltro;
import com.adisolucoes.adimanager.model.LazyBean;
import com.adisolucoes.adimanager.model.Meta;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ADI Soluções
 */
@Named
@ViewScoped
public class MetaBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(Meta.class.getName());

    @Inject
    private MetaDAO metaDAO;

    private Meta meta;
    private MetaFiltro metaFiltro;
    private boolean buscaAvancada;
    private List<Meta> metas;
    private LazyBean<Meta> modelo;

    public MetaBean() {
        meta = new Meta();
        metaFiltro = new MetaFiltro();
    }

    public void pesquisarLazy() {
        modelo = new LazyBean<Meta>(metaDAO, metaFiltro);
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public MetaFiltro getMetaFiltro() {
        return metaFiltro;
    }

    public void setMetaFiltro(MetaFiltro metaFiltro) {
        this.metaFiltro = metaFiltro;
    }

    public List<Meta> getMetas() {
        return metas;
    }

    public void setMetas(List<Meta> metas) {
        this.metas = metas;
    }

    public TipoPrioridadeMeta[] getPrioridadeMetas() {
        return TipoPrioridadeMeta.values();
    }

    public boolean isBuscaAvancada() {
        return buscaAvancada;
    }

    public void setBuscaAvancada(boolean buscaAvancada) {
        this.buscaAvancada = buscaAvancada;
    }

    public LazyBean<Meta> getModelo() {
        if (modelo == null) {
            pesquisarLazy();
        }
        return modelo;
    }

    public void setModelo(LazyBean<Meta> modelo) {
        this.modelo = modelo;
    }

}
