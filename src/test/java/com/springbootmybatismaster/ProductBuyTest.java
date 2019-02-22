package com.springbootmybatismaster;

import com.service.impl.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductBuyTest {
    @Autowired
    private ProductService productService;

    @Test
    public void test(){
//        productService.initStock();
//        productService.buyProduct();
    }
}
