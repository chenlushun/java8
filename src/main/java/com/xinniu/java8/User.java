/*
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2019
 */
package com.xinniu.java8;

import lombok.Data;

/**
 * 艺术家
 *
 * @author <a href="mailto:chenlushun@51nbapi.com">陈录顺</a>
 */
@Data
public class User {

    /**
     * 名字
     */
    private String name;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 年龄
     */
    private int age;

    /**
     * 来自哪里？
     */
    private String from;

    public boolean isFrom(String from) {

        if (this.from == null) {
            return false;
        }

        if (this.from.equals(from)) {
            return true;
        }
        return false;
    }
}
