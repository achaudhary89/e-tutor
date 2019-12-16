package com.alok.mytutorwebapp.service;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface BaseService<T, ID> {

    public Set<T> findAll();

    public T findByID(ID id);

    public void delete(T object);

    public void deleteByID(ID id);

    public void save(T object);

}
