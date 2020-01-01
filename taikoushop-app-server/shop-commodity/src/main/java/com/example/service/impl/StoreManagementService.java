package com.example.service.impl;

import com.example.exception.DataErrorException;
import com.example.model.Commodity;
import com.example.repository.CommodityRepository;
import com.example.service.IStoreManagementService;
import com.example.utils.CheckDataUtil;
import net.bytebuddy.implementation.MethodCall;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;


@Service
public class StoreManagementService implements IStoreManagementService {

    @Autowired
    CommodityRepository commodityRepository;

    public void test() {

    }

    @Override
    public boolean createCommodity(Commodity commodity) throws InvocationTargetException, NoSuchMethodException, NoSuchFieldException, InstantiationException, IllegalAccessException, DataErrorException {
        if( !CheckDataUtil.checkDataCorrect(commodity)){
            throw new DataErrorException(" data parse error ");
        }

//
//        commodityRepository.save(commodity);
        return false;
    }
}
