package org.example.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.Random;

public class RandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        Class<?> clazz = o.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            RandomInt randomIntAnnotation = declaredField.getAnnotation(RandomInt.class);
            if(randomIntAnnotation != null) {
                int min = randomIntAnnotation.min();
                int max = randomIntAnnotation.max();
                Random rnd = new Random();
                int randomNum = min + rnd.nextInt(max - min);
                declaredField.setAccessible(true);
                try {
                    declaredField.set(o, randomNum);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }
}
