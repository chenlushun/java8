/*
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2019
 */
package com.xinniu.java8.collect;

import com.xinniu.java8.User;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;

/**
 * 收集器的使用
 * https://github.com/chenlushun/java8/issues/1
 *
 * @author <a href="mailto:chenlushun@51nbapi.com">陈录顺</a>
 * @since 4.5.8
 */
public class CollectTest {

    ArrayList<User> users = new ArrayList<>();

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

        {
            User user = new User();
            user.setAge(15);
            user.setName("王拓的妹妹");
            user.setFrom("地球上");
            users.add(user);
        }
    }

    /**
     * <pre>
     *
     * 测试集合转换：从一种集合转换为另一种集合
     *
     * 例如
     *      ArrayList --> TreeSet
     *      ArrayList --> LinkedList
     *      ArrayList --> HashSet
     *  </pre>
     */
    @Test
    public void testOfCollectTranslate() {
        TreeSet treeSet = users.stream().collect(Collectors.toCollection(TreeSet::new));
        LinkedList linkedList = users.stream().collect(Collectors.toCollection(LinkedList::new));
        Set set = users.stream().collect(Collectors.toCollection(HashSet::new));
    }

    /**
     * <pre>
     *
     * 转换成值
     *
     * 收集器让流生成一个值,例如，求某一个对象的临界值，本例子中可以求一个用户的最大年龄和最小年龄
     *
     * @see java.util.stream.Collectors#averagingInt --> 求平均数
     * @see java.util.stream.Collectors#maxBy --> 求最大数
     * @see java.util.stream.Collectors#minBy --> 求最小数
     * @see java.util.stream.Collectors#summingInt --> 方法求和
     * </pre>
     */
    @Test
    public void testOfTranslateToValue() {

        Function<User, Integer> getAge = User::getAge;

        Optional<User> maxAge = users.stream().max(comparing(getAge));

        Optional<User> minAge = users.stream().min(comparing(getAge));

        // Optional<User> minAge = users.stream().collect(maxBy(Comparator.comparing(getAge)));

        System.out.println("最大年龄为：" + maxAge.get().getAge() + "，最小年龄为：" + minAge.get().getAge());
    }

    /**
     * <pre>
     *     数据分块
     *     @see java.util.stream.Collectors#partitioningBy --> 数据分块
     *     数据分组
     *     @see java.util.stream.Collectors#groupingBy --> 数据分块
     *
     * </pre>
     */
    @Test
    public void testOfDataSplitBlock() {

        // 演示一个数据分组的
        Map<Integer, List<User>> userMap = users.stream().collect(groupingBy(User::getAge));

        // 18 --> 王拓
        // 15 --> 王拓的妹妹、王拓的妹妹
        System.out.println(userMap);
        // {18=[User(name=王拓, nickName=null, age=18, from=地球上)], 15=[User(name=王拓的弟弟, nickName=null, age=15, from=地球上), User(name=王拓的妹妹, nickName=null, age=15, from=地球上)]}
    }

    /**
     * 字符串，按照一定的格式输出用户名称
     */
    @Test
    public void testOfString() {

        // 在Java 8还未发布前，实现该功能的代码
        StringBuilder builder = new StringBuilder("[");
        for (User user : users) {
            if (builder.length() > 1) builder.append(", ");
            String name = user.getName();
            builder.append(name);
        }
        builder.append("]");
        String result1 = builder.toString();

        System.out.println(result1);


        // Java 8 提供的流和收集器就能写出更清晰的代码
        String result2 = users.stream().map(User::getName).collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result2);

    }


    // todo 组合收集器

    // todo 重构和定制收集器


}
