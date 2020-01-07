//package com.example.web;
//
//import com.example.exception.DataErrorException;
//import com.example.model.common.ResultEnum;
//import com.example.service.IStoreManagementService;
//import com.example.utils.CheckDataUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//import java.lang.reflect.InvocationTargetException;
//import java.math.BigDecimal;
//import java.util.List;
//
//@RestController
//public class CommodityController {
//
//    @Autowired
//    CommodityRepository commodityRepository;
//
//    @Autowired
//    private IStoreManagementService storeManagementService;
//
//    @RequestMapping(value = "/commodity/test")
//    public List<Commodity> test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
//
//        Commodity commodity = new Commodity();
//        BigDecimal price = new BigDecimal("42900");
//        commodity.setItemName("mac");
//        commodity.setItemId("b4fd1e96-419b-4cd6-a620-d240b845723f");
//        commodity.setOffFlag("1");
//        commodity.setPhotoName("");
//        commodity.setPhotoPath("");
//        commodity.setPrice(price);
//        System.out.println("before");
//        System.out.println("finish");
//
////        Class c = commodity.getClass();
////        Object o = c.newInstance();
////        Field[] fields = commodity.getClass().getDeclaredFields();
////        System.out.println("   field   ");
////        System.out.println(fields[0].getName());
////        String methodName = "get"+fields[0].getName().substring(0, 1).toUpperCase()+fields[0].getName().substring(1);
////        System.out.println("methodName    "+methodName);
////        Method method = commodity.getClass().getDeclaredMethod(methodName);
////        System.out.println("  get     "+method.invoke( o ));
//
//        CheckDataUtil.checkDataCorrect(commodity);
//        return commodityRepository.findCommodityByItemId("b4fd1e96-419b-4cd6-a620-d240b845723c");
//    }
//
//    @RequestMapping(value = "/commodity/create")
//    public List<Commodity> insert(@Valid @RequestBody Commodity commodity){
//
////        Commodity commodity = new Commodity();
////        BigInteger itemNo = new BigInteger("20191218001");
////        BigDecimal price = new BigDecimal("42900");
////        commodity.setItemName("mac");
////        commodity.setItemNo(itemNo);
////        commodity.setOffFlag("1");
////        commodity.setPhotoName("");
////        commodity.setPhotoPath("");
////        commodity.setPrice(price);
//        commodityRepository.save(commodity);
//        return null;
//    }
//
//    @RequestMapping(value = "/commodity/sell/create")
//    public List<Commodity> commodityCreate(@Valid @RequestBody Commodity commodity) throws NoSuchMethodException, NoSuchFieldException, InstantiationException, IllegalAccessException, InvocationTargetException, DataErrorException {
//        storeManagementService.createCommodity(commodity);
//        System.out.println(ResultEnum.SUCCESS);
//        return null;
//    }
//
//    @RequestMapping("/commodity/search")
//    public List<Commodity> searchCommodity(@RequestParam("word") String word){
//
//        return null;
//    }
//
//
//
//
//}
