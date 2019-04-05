/*
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2019
 */
package com.xinniu.java8.stream;

import com.xinniu.java8.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream 的常用操作
 *
 * @author <a href="mailto:chenlushun@51nbapi.com">陈录顺</a>
 */
public class StreamCollectTest {

    @Test
    public void testCollect() {

        List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());


        List<User> users = new ArrayList<>();
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
        // 分组
        // 可以根据 User 对象中的任意一个属性进行分组
        {
            // 根据名称分组
            Map<String, List<User>> obtain = users.stream().collect(Collectors.groupingBy(User::getName));
            System.out.println(obtain);
        }
        {
            // 根据地址分组
            Map<String, List<User>> obtain = users.stream().collect(Collectors.groupingBy(User::getFrom));
            System.out.println(obtain);
        }
    }
}
