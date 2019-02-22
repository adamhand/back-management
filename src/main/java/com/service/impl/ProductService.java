package com.service.impl;

import com.RateLimiteService.RateLimiterService;
import com.alibaba.fastjson.JSONObject;
import com.commons.Constant;
import com.dao.BookMapper;
import com.pojo.Book;
import com.pojo.Record;
import com.rabbitmq.client.AMQP;
import com.redis.RedisOperation;
import com.service.RecordService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "productService")
@Resource
public class ProductService {
    @Autowired
    private RedisOperation redisOperation;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RecordService recordService;

    @Autowired
    private BookMapper bookMapper;

    /**
     * 初始化商品数量
     */
    public void initStock(){
//        redisOperation.set(Constant.GOODS_ID, Constant.GOODS_STOCK);
    }

    /**
     * 如果缓存中没有，就放入缓存；㘝缓存中有，直接返回。
     * @param id
     */
    public void getAmountById(String id){
        Long amount = redisOperation.get(id);
        if(amount != null){
            return;
        }else {
            amount = bookMapper.selectAmountById(Integer.parseInt(id));
            redisOperation.set(id, String.valueOf(amount));
        }
    }

    /**
     * 购买指令到了之后的操作
     * @return
     */
    public synchronized boolean buyProduct(String id){
        if(RateLimiterService.tryToken()){
            getAmountById(id);

            Long stock = redisOperation.decrease(id);
            if(stock < 0){
                return false;
            }

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("goodsId", id);
            jsonObject.put("goodsStock", stock);

            MessageProperties properties = new MessageProperties();
            properties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
            properties.setContentType("UTF-8");

            Message msg = new Message(jsonObject.toJSONString().getBytes(), properties);
            rabbitTemplate.send(Constant.EXCHANGE_NAMES, Constant.ROUTING_KEY, msg);

        }
        return true;
    }

    /**
     * 购买指令成功之后的操作
     */
    public void manageProduct(String goodsId, String goodsStock){
        int id = Integer.parseInt(goodsId);
        int stock = Integer.parseInt(goodsStock);
        System.out.println(id +" "+stock);

        Book book = bookMapper.selectByPrimaryKey(id);
        book.setBookAmount(stock);
        bookMapper.updateByPrimaryKey(book);

        Record record = new Record();
        record.setRecordType("buy");

        recordService.addRecord(record);
    }

    public void selectById(String id){
        Book book = bookMapper.selectByPrimaryKey(Integer.parseInt(id));
        System.out.println(book);
    }
}
