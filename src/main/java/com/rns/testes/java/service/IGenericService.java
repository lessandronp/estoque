package com.rns.testes.java.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Sort;

/**
 * Interface representa os métodos mínimos que devem ser criados nas services
 * dessa API.
 *
 * @param <T> Entidade que a service será responsável.
 * @param <I> A classe do id da entidade.
 */
public interface IGenericService<T, I extends Serializable> {

    T save(T t);

    List<T> findAll();

    T findById(I i);

    T update(T t);

    void delete(T t);

    void delete(I i);

    List<T> findAll(Sort sort);

}
