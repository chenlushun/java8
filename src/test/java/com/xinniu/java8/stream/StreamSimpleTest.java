/*
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2019
 */
package com.xinniu.java8.stream;

import com.xinniu.java8.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * stream 的简单入门
 *
 * @author <a href="mailto:chenlushun@51nbapi.com">陈录顺</a>
 */
public class StreamSimpleTest {


    private List<User> users = new ArrayList<>();

    @Before
    public void before() {
        {
            User user = new User();
            user.setAge(18);
            user.setName("王拓");
            user.setFrom("杭州");
            users.add(user);
        }
        {
            User user = new User();
            user.setAge(15);
            user.setName("王拓的弟弟");
            user.setFrom("长沙");
            users.add(user);
        }
    }

    /**
     * 计算出来自杭州的用户--使用for循环
     * <p>
     * 弊端：
     */
    @Test
    public void testOfLoop() {
        int count = 0;

        for (User user : users) {
            if (user.isFrom("杭州")) {
                count++;
            }
        }
        System.out.println(String.format("来自杭州的艺术家%s\n", count));
    }

    /**
     * 计算出来自杭州的用户--使用迭代器
     * 弊端：
     */
    @Test
    public void testOfIterator() {
        int count = 0;

        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.isFrom("杭州")) {
                count++;
            }
        }
        System.out.println(String.format("来自杭州的艺术家%s\n", count));
    }

    /**
     * 计算出来自杭州的用户--使用Stream
     */
    @Test
    public void testOfStream() {
        long count = users.stream().filter(user -> user.isFrom("杭州")).count();
        System.out.println(String.format("来自杭州的艺术家%s\n", count));
    }
}
