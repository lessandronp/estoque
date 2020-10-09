package com.rns.testes.java.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rns.testes.java.dao.IFilialDao;
import com.rns.testes.java.exception.ParameterNotFoundException;
import com.rns.testes.java.model.Filial;
import com.rns.testes.java.service.AbstractGenericServicePersistence;
import com.rns.testes.java.service.IFilialService;

@Service
public class FilialService extends AbstractGenericServicePersistence<IFilialDao, Filial, Long>
	implements IFilialService {

    @Autowired
    IFilialDao filialDao;

    @Override
    public Filial buscaPorRazao(String razao) {
	if (StringUtils.isNotEmpty(razao)) {
	    return filialDao.buscaPorRazao(razao.toLowerCase());
	}
	throw new ParameterNotFoundException("A razão social da filial não foi informada.");
    }

    @Override
    public Filial buscaPorCNPJ(String cnpj) {
	if (StringUtils.isNotEmpty(cnpj)) {
	    return filialDao.buscaPorCnpj(cnpj);
	}
	throw new ParameterNotFoundException("O cnpj não foi informado.");
    }
}
