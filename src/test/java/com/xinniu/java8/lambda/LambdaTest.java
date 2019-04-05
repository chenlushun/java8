/*
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2019
 */
package com.xinniu.java8.lambda;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

/**
 * Lambda 写法展示
 *
 * @author <a href="mailto:chenlushun@51nbapi.com">陈录顺</a>
 * @since 4.5.8
 */
@Slf4j
public class LambdaTest {

    @Test
    public void testThread() {

        // 创建一个线程并启动，对比2中不同的写法

        // 一般写法
        new Thread(new Runnable() {
            @Override
            public void run() {
                // do task
            }
        }).start();

        // Lambda 写法
        new Thread(() -> {
            // do task
        }).start();
    }

    @Test
    public void testMap() {
        Map<Integer, String> map = new HashMap<>();
        // 一般写法
        for (Integer integer : map.keySet()) {
            Integer key = integer;
            String value = map.get(key);

            // do task
        }

        // Lambda 写法
        map.forEach((key, value) -> {
            // do task
        });
    }

    @Test
    public void testBinaryOperator() {
        BinaryOperator<Long> binaryOperator = (x, y) -> x + y;
    }

    @Test
    public void testValue() {
        Map<Integer, String> map = new HashMap<>();

        final int value1 = 1;
        int value2 = 2;

        map.forEach((key, value) -> {

            //value2 = 2; // 编译报错

            int value3 = value1;

            int value4 = value2;
        });
    }
}
