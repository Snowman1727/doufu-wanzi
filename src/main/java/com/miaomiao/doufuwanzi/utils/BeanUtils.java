package com.miaomiao.doufuwanzi.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

public class BeanUtils {

    /**
     * 复制源对象的属性值到目标对象
     *
     * @param source 源对象
     * @param target 目标对象
     */
    public static void copyProperties(Object source, Object target) {
        BeanWrapper sourceWrapper = new BeanWrapperImpl(source);
        BeanWrapper targetWrapper = new BeanWrapperImpl(target);

        for (PropertyDescriptor property : sourceWrapper.getPropertyDescriptors()) {
            if (targetWrapper.isWritableProperty(property.getName())) {
                targetWrapper.setPropertyValue(property.getName(), sourceWrapper.getPropertyValue(property.getName()));
            }
        }
    }

    /**
     * 获取可读属性列表
     *
     * @param bean 对象
     * @return 可读属性列表
     */
    public static List<String> getReadableProperties(Object bean) {
        List<String> readableProperties = new ArrayList<>();
        BeanWrapper beanWrapper = new BeanWrapperImpl(bean);

        for (PropertyDescriptor property : beanWrapper.getPropertyDescriptors()) {
            if (beanWrapper.isReadableProperty(property.getName())) {
                readableProperties.add(property.getName());
            }
        }

        return readableProperties;
    }

    /**
     * 获取可写属性列表
     *
     * @param bean 对象
     * @return 可写属性列表
     */
    public static List<String> getWritableProperties(Object bean) {
        List<String> writableProperties = new ArrayList<>();
        BeanWrapper beanWrapper = new BeanWrapperImpl(bean);

        for (PropertyDescriptor property : beanWrapper.getPropertyDescriptors()) {
            if (beanWrapper.isWritableProperty(property.getName())) {
                writableProperties.add(property.getName());
            }
        }

        return writableProperties;
    }
}
