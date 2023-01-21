package com.afoninav.repository;

import java.util.List;

interface GenericRepository<T,ID> {
    T create(T t);
    T readById(ID id);
    T update(T t);
    boolean deleteById(ID id);
    List<T> readAll();
}
