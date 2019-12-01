package com.remote.united_shop.Core.Converters.AbstractConverters;

import java.util.List;

/***
 *
 * @param <U>
 * @param <V>
 */
public interface AbstractConverter<U,V> {
    public V convertToDto(U u);
    public List<V> convertListToListDto(List<U> us);
    public U convertToEntity(V v);
    public List<U> convertListDtoToListEntity(List<V> vs);
}
