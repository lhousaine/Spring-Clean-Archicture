package com.remote.united_shop.Core.Converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.util.Arrays;

public class GlobalConverter {

    public GlobalConverter() {
        throw new IllegalArgumentException("Don't create instance Utility class!");
    }

    /***
     *
     * @param s
     * @param t
     */
     public static void copyProperties(Object s, Object t) {

         BeanUtils.copyProperties(s, t);
     }

    /***
     *
     * @param s
     * @param t
     */
    public static void copyNonNullProperties(Object s, Object t) {
        BeanUtils.copyProperties(s, t, getNullPropertyNames(s));
    }

    /***
     *
     * @param source
     * @return
     */
    private static String[] getNullPropertyNames(Object source) {
            final BeanWrapper src = new BeanWrapperImpl(source);
            return Arrays.stream(src.getPropertyDescriptors())
                    .map(FeatureDescriptor::getName)
                    .filter(name -> src.getPropertyValue(name) == null)
                    .toArray(String[]::new);
        }
}
