package com.remote.united_shop.services.AbstractService;

import java.util.List;

public interface AbstractService<T> {
    public List<T> getAll();
    public T getByIdEntity(String idEntity);
    public T createNewEntity(T t);
    public void updateEntity(String idEntity,T t);
    public String deleteEntity(String idEntity);
}
