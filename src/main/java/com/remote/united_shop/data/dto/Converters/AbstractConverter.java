package com.remote.united_shop.data.dto.Converters;

import java.text.ParseException;

public interface AbstractConverter<U,V> {
    public V convertToDto(U u);
    U convertToEntity(V v) throws ParseException;
}
