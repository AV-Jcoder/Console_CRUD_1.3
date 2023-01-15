package com.afoninav.repository;

import java.util.List;

interface GenericRepository<T,ID> {
    boolean create(T t);
    T read(ID id);
    boolean update(T t);
    boolean delete(ID id);
    List<T> readAll();
}
