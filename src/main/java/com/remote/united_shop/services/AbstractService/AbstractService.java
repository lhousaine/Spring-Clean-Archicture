package com.remote.united_shop.services.AbstractService;

import java.util.List;

public interface AbstractService<T,ID> {
    public List<T> getAll();
    public T getByIdEntity(ID idEntity);
    public T createNewEntity(T t);
    public void updateEntity(ID idEntity,T t);
    public void deleteEntity(ID idEntity);
}
