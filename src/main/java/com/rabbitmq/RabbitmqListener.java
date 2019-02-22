package com.rabbitmq;

import com.alibaba.fastjson.JSONObject;
import com.commons.Constant;
import com.service.impl.ProductService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class RabbitmqListener {
    @Autowired
    private ProductService productService;

//    @RabbitListener(queues = Constant.QUEUE_NAMES)
//    public void receive(byte[] message){
//        String s = null;
//        try {
//            s = new String(message, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        System.out.println(s);
//    }

    @RabbitListener(queues = Constant.QUEUE_NAMES)
    public void rabbitmqConsumer(byte[] message){
        if(message != null){
            JSONObject jsonObject = null;
            try {
                jsonObject = JSONObject.parseObject(new String(message, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            System.out.println("goodsId " + jsonObject.get("goodsId"));
            System.out.println("goodStock " + jsonObject.get("goodsStock"));

            String goodsId = jsonObject.getString("goodsId");
            String amount = jsonObject.getString("goodsStock");

            /**
             * 生成购买纪录并插入数据库
             */
            productService.manageProduct(goodsId, amount);
        }
    }
}
