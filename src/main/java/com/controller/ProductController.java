package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.commons.Constant;
import com.dao.BookMapper;
import com.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping()
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    BookMapper bookMapper;

    @GetMapping(value = "/productInit")
    @ResponseBody
    public Map<String, Object> productInit(){
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("productIdOne", Constant.BOOK_ID_1);
        map.put("productIdTwo", Constant.BOOK_ID_2);
        map.put("productIdThree", Constant.BOOK_ID_3);
        map.put("productIdFour", Constant.BOOK_ID_4);
        map.put("productIdFive", Constant.BOOK_ID_5);
        map.put("productIdSix", Constant.BOOK_ID_6);
        map.put("productIdSeven", Constant.BOOK_ID_7);
        map.put("productIdEight", Constant.BOOK_ID_8);
        map.put("productIdNight", Constant.BOOK_ID_9);
        map.put("productIdTen", Constant.BOOK_ID_10);

        map.put("productInitStock1", bookMapper.selectAmountById(Integer.parseInt(Constant.BOOK_ID_1)));
        map.put("productInitStock2", bookMapper.selectAmountById(Integer.parseInt(Constant.BOOK_ID_2)));
        map.put("productInitStock3", bookMapper.selectAmountById(Integer.parseInt(Constant.BOOK_ID_3)));
        map.put("productInitStock4", bookMapper.selectAmountById(Integer.parseInt(Constant.BOOK_ID_4)));
        map.put("productInitStock5", bookMapper.selectAmountById(Integer.parseInt(Constant.BOOK_ID_5)));
        map.put("productInitStock6", bookMapper.selectAmountById(Integer.parseInt(Constant.BOOK_ID_6)));
        map.put("productInitStock7", bookMapper.selectAmountById(Integer.parseInt(Constant.BOOK_ID_7)));
        map.put("productInitStock8", bookMapper.selectAmountById(Integer.parseInt(Constant.BOOK_ID_8)));
        map.put("productInitStock9", bookMapper.selectAmountById(Integer.parseInt(Constant.BOOK_ID_9)));
        map.put("productInitStock10", bookMapper.selectAmountById(Integer.parseInt(Constant.BOOK_ID_10)));

        return map;
    }

//    @GetMapping(value = "/productInit")
//    @ResponseBody
//    public JSON productInit(){
//        Map<String, Object> map = new HashMap<>();
//        map.put("success", true);
//        map.put("productIdOne", Constant.BOOK_ID_1);
//        map.put("productIdTwo", Constant.BOOK_ID_2);
//        map.put("productIdThree", Constant.BOOK_ID_3);
//        map.put("productIdFour", Constant.BOOK_ID_4);
//        map.put("productIdFive", Constant.BOOK_ID_5);
//        map.put("productIdSix", Constant.BOOK_ID_6);
//        map.put("productIdSeven", Constant.BOOK_ID_7);
//        map.put("productIdEight", Constant.BOOK_ID_8);
//        map.put("productIdNight", Constant.BOOK_ID_9);
//        map.put("productIdTen", Constant.BOOK_ID_10);
//
//        map.put("productInitStock", Constant.BOOK_STOCK_INIT);
//
//        JSON json = (JSON)JSONObject.toJSON(map);
//        return json;
//    }

    @GetMapping(value = "buyProduct")
    @ResponseBody
    public Map<String, Object> buyProduct(@RequestParam("goodsId") String id){
        System.out.println(id);

        boolean isSucces = productService.buyProduct(id);
        Map<String, Object> map = new HashMap<>();
        if(isSucces){
            map.put("success", true);
            map.put("msg", "bought successful");
        }else {
            map.put("success", false);
            map.put("msg", "bought unsuccessful");
        }

        return map;
    }
}
