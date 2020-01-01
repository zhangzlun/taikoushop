package com.example.utils;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

import javax.persistence.Table;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class CheckDataUtil {
    private static Object String;

    public static boolean checkCommodityDataCorrect(String data){
        return !("".equals(data) || data == null);
    }
    public static boolean checkCommodityDataCorrect(Integer data){
        return (data.compareTo(new Integer("0")) > 0);
    }

    public static boolean checkCommodityDataCorrect(BigDecimal data){
        return data.compareTo(BigDecimal.ZERO) > 0;
    }

    public static boolean checkDataCorrect(Object object) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
        boolean checkValue = true;
        Class c = object.getClass();
        Object o = c.newInstance();
        Field[] fields = c.getDeclaredFields();
        for( Field field : fields){
            String fieldName = field.getName();
            String methodName = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
            Method method = c.getDeclaredMethod(methodName);

            Object obj = method.invoke(object);
            if( method.invoke(object) instanceof  String){
//                System.out.println("this is string");
                if(!checkCommodityDataCorrect((String) method.invoke(object)))checkValue = false;
            }
            if( method.invoke(object) instanceof  BigDecimal){
//                System.out.println("this is BigDecimal");
                if(!checkCommodityDataCorrect((BigDecimal) method.invoke(object)))checkValue = false;
            }
            if( method.invoke(object) instanceof  Integer){
//                System.out.println("this is BigDecimal");
                if(!checkCommodityDataCorrect((Integer) method.invoke(object)))checkValue = false;
            }


        }
        return checkValue;
    }
}
