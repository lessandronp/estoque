package com.rns.testes.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rns.testes.java.model.Filial;

/**
 * Interface representa a camada de persistência da entidade Filial. Deve ser
 * injetada <b>exclusivamente</b> em uma camada service.
 */
public interface IFilialDao extends JpaRepository<Filial, Long> {

    @Query("SELECT f FROM Filial f WHERE lower(f.razaoSocial) = :razao")
    Filial buscaPorRazao(@Param("razao") String razao);

    @Query("SELECT f FROM Filial f left join fetch f.estoques WHERE f.cnpj = :cnpj")
    Filial buscaPorCnpj(@Param("cnpj") String cnpj);
}
