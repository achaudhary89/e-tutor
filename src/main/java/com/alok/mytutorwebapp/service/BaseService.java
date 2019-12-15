package com.alok.mytutorwebapp.service;

import java.util.Set;

public interface BaseService<T, ID> {

    public Set<T> findAll();

    public T findByID(ID id);

    public void delete(T object);

    public void deleteByID(ID id);

    public void save(T object);

}
