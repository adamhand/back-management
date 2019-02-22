package com.springbootmybatismaster;

import com.service.impl.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConcurrencyBuyTest {
    @Autowired
    private ProductService productService;

    private int parallel = 10000;

    @Test
    public void test(){
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(parallel);
        ExecutorService pool = Executors.newCachedThreadPool();

        for(int i = 0; i < parallel; i++){
//            new Thread(new InitThreads(begin)).start();
            pool.execute(new InitThreads(begin, end));
        }

        begin.countDown();
        try {
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class InitThreads implements Runnable{
        private CountDownLatch begin;
        private CountDownLatch end;

        public InitThreads(CountDownLatch begin, CountDownLatch end){
            this.begin = begin;
            this.end = end;
        }

        @Override
        public void run() {
            try {
                begin.await();

                productService.buyProduct("1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
