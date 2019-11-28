package com.remote.united_shop.Core.Converters.AbstractConverters;

import java.text.ParseException;

public interface AbstractConverter<U,V> {
    public V convertToDto(U u);
    U convertToEntity(V v) throws ParseException;
}
