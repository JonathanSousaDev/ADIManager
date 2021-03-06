package com.adisolucoes.adimanager.util.crud;

import com.adisolucoes.adimanager.dao.EmpresaDAO;
import com.adisolucoes.adimanager.dao.PessoaDAO;
import com.adisolucoes.adimanager.enumerations.UF;
import com.adisolucoes.adimanager.exceptions.ErroBancoDadosException;
import com.adisolucoes.adimanager.exceptions.ErroPessoaDuplicadoException;
import com.adisolucoes.adimanager.model.Endereco;
import com.adisolucoes.adimanager.model.Pessoa;
import com.adisolucoes.adimanager.util.jsf.ConnectionUtils;
import com.adisolucoes.adimanager.util.jsf.FacesUtils;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;

/**
 *
 * @author ADI Soluções
 */
public class CrudUtils implements Serializable {

    private PessoaDAO pessoaDAO;

    private static final Logger LOG = Logger.getLogger(CrudUtils.class.getName());

    public Endereco preencherDadosPorCep(Endereco endereco) {
        try {
            String cep = endereco.getCep();
            if (cep != null || !cep.equals("")) {
                ConnectionUtils connectionUtils = new ConnectionUtils();
                Connection con = connectionUtils.getConnection("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml", null, null);
                Document doc = con.get();
                if (doc.getElementsByTag("resultado_txt").text().contains("cep não encontrado")) {
                    FacesUtils.showFacesMessage("CEP não encontrado, informe um CEP válido!", 1);
                } else {
                    UF uf = UF.fromDescricao(doc.getElementsByTag("uf").text());
                    endereco.setUf(uf);
                    endereco.setCidade(doc.getElementsByTag("cidade").text());
                    endereco.setBairro(doc.getElementsByTag("bairro").text());
                    endereco.setLogradouro(doc.getElementsByTag("logradouro").text());
                    endereco.setComplemento(doc.getElementsByTag("tipo_logradouro").text() + ": ");
                }
            }
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
            FacesUtils.showFacesMessage("Ouve um erro na conexão com o WebService, informe os dados de endereço forma manual!", 1);
        }
        return endereco;
    }
}
