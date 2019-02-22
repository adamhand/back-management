package com.springbootmybatismaster;

import com.dao.BookMapper;
import com.pojo.Book;
import com.pojo.Record;
import com.service.RecordService;
import com.service.impl.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MysqlTest {
    @Autowired
    private RecordService recordService;

    @Autowired
    private ProductService productService;

    @Test
    public void test(){
        Record record = new Record();
//        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//        String startTime = dateformat.format(System.currentTimeMillis());
//        record.setRecordId(UUID.randomUUID().toString().indexOf(3));
        record.setRecordType("buy");
//        String stopTime = dateformat.format(System.currentTimeMillis());
//        record.setRecordStartTime(new Date(startTime));
//        record.setRecordStartTime(new Date(stopTime));
        recordService.addRecord(record);

        productService.selectById("1");
    }
}
