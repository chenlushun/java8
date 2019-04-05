/*
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2019
 */
package com.xinniu.java8.stream;

import com.xinniu.java8.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 将一种类型的值转换为另外一种类型
 *
 * @author <a href="mailto:chenlushun@51nbapi.com">陈录顺</a>
 */
public class StreamMapTest {

    List<User> users = new ArrayList<>();

    @Before
    public void before() {
        {
            User user = new User();
            user.setAge(18);
            user.setName("王拓");
            user.setFrom("地球上");
            users.add(user);
        }
        {
            User user = new User();
            user.setAge(15);
            user.setName("王拓的弟弟");
            user.setFrom("地球上");
            users.add(user);
        }
    }

    @Test
    public void testOfList() {
        List<User> collected = new ArrayList<>();
        for (User user : users) {
            collected.add(transfor(user));
        }
        System.out.println(collected);
    }

    @Test
    public void testMap() {
        List<User> collected = users.stream().map(this::transfor).collect(toList());
        System.out.println(collected);
    }


    private User transfor(User user) {
        user.setName(String.format("%s**", user.getName().substring(0, 1)));
        return user;
    }

}
