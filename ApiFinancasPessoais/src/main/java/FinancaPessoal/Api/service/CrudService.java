package FinancaPessoal.Api.service;

import java.util.List;
import java.util.Optional;

import FinancaPessoal.Api.model.Account;

public interface CrudService<ID, T> {
    List<T> findAll();
    Optional<Account> findById(ID id);
    T create(T entity);
    T update(T entity);
    void delete(ID id);
	
}