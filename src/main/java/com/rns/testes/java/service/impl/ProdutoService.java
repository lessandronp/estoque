package com.rns.testes.java.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rns.testes.java.dao.IProdutoDao;
import com.rns.testes.java.exception.ParameterNotFoundException;
import com.rns.testes.java.model.Produto;
import com.rns.testes.java.service.AbstractGenericServicePersistence;
import com.rns.testes.java.service.IProdutoService;

@Service
public class ProdutoService extends AbstractGenericServicePersistence<IProdutoDao, Produto, String>
	implements IProdutoService {

    @Autowired
    IProdutoDao produtoDao;

    @Override
    public Produto buscaPorNome(String nomeProduto) {
	if (StringUtils.isNotEmpty(nomeProduto)) {
	    return produtoDao.buscaPorNome(nomeProduto.toLowerCase());
	}
	throw new ParameterNotFoundException("O parâmetro nome do produto não foi informado.");
    }

    @Override
    public Produto buscaPorCodigo(String codigoProduto) {
	if (StringUtils.isNotEmpty(codigoProduto)) {
	    return produtoDao.buscaPorCodigo(codigoProduto);
	}
	throw new ParameterNotFoundException("O parâmetro código do produto não foi informado.");
    }

}
