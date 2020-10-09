package com.rns.testes.java.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.rns.testes.java.model.Estoque;

/**
 * Interface representa a camada de persistência da entidade Estoque. Deve ser
 * injetada <b>exclusivamente</b> em uma camada service.
 */
public interface IEstoqueDao extends JpaRepository<Estoque, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Estoque e set e.filial.id = (select f.id from Filial f where f.cnpj = :cnpjFilialDest) "
	    + " where e.filial.id = (select f.id from Filial f where f.cnpj = :cnpjFilialOrig) "
	    + " and e.produto.id = (select p.id from Produto p where p.codigo = :codProd)")
    void updateProdutoFilial(@Param("codProd") String codProd, @Param("cnpjFilialOrig") String cnpjFilialOrig,
	    @Param("cnpjFilialDest") String cnpjFilialDest);

    @Query("SELECT e FROM Estoque e WHERE e.filial.cnpj = :cnpjFilial and e.produto.codigo = :codProd ")
    Estoque buscaEstoque(@Param("codProd") String codProd, @Param("cnpjFilial") String cnpjFilial);

    @Query("SELECT e FROM Estoque e WHERE e.filial.cnpj = :cnpjFilial ")
    List<Estoque> buscaEstoques(@Param("cnpjFilial") String cnpjFilial);
}
