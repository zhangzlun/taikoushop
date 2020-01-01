package com.example.service;

import com.example.exception.DataErrorException;
import com.example.model.Commodity;

import java.lang.reflect.InvocationTargetException;

public interface IStoreManagementService {
    void test();
    boolean createCommodity(Commodity commodity) throws InvocationTargetException, NoSuchMethodException, NoSuchFieldException, InstantiationException, IllegalAccessException, DataErrorException;
}
