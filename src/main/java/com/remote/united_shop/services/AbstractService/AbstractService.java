package com.remote.united_shop.services.AbstractService;

import com.remote.united_shop.Core.Exceptions.NoDataFoundException;

import java.util.List;

public interface AbstractService<T,ID,V> {
    public List<V> getAll() throws NoDataFoundException;
    public V getByIdEntity(ID idEntity) throws NoDataFoundException;
    public V createNewEntity(V v) throws Exception;
    public void updateEntity(ID idEntity,V v) throws NoDataFoundException;
    public void deleteEntity(ID idEntity);
}
