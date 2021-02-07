package br.com.fiap.daoexample.dao;


import javax.persistence.EntityManager;

import br.com.fiap.daoexample.domain.TipoEstabelecimento;

public class TipoEstabelecimentoDAO extends GenericDAO<TipoEstabelecimento, Integer> {

    public TipoEstabelecimentoDAO(EntityManager em) {
        super(em);
    }
}
