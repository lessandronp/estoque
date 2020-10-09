package com.rns.testes.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rns.testes.java.model.Produto;

/**
 * Interface representa a camada de persistência da entidade Produto. Deve ser injetada <b>exclusivamente</b> em uma
 * camada service.
 */
public interface IProdutoDao extends JpaRepository<Produto, String> {
	
	 @Query("SELECT p FROM Produto p WHERE lower(p.nome) = :nomeProduto")
	 Produto buscaPorNome(@Param("nomeProduto") String nomeProduto);
	 
	 @Query("SELECT p FROM Produto p WHERE lower(p.codigo) = :codigoProduto")
	 Produto buscaPorCodigo(@Param("codigoProduto") String codigoProduto);
}
