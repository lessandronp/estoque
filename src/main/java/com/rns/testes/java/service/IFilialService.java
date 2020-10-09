package com.rns.testes.java.service;

import com.rns.testes.java.model.Filial;

public interface IFilialService extends IGenericService<Filial, Long> {

    Filial buscaPorRazao(String razao);

    Filial buscaPorCNPJ(String cnpj);

}
