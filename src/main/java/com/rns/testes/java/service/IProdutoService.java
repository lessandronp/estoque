package com.rns.testes.java.service;

import com.rns.testes.java.model.Produto;

public interface IProdutoService extends IGenericService<Produto, String> {

    Produto buscaPorNome(String nomeProduto);

    Produto buscaPorCodigo(String codigoProduto);
}
