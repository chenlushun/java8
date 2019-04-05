/*
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2019
 */
package com.xinniu.java8.lambda;

/**
 * 事件监听
 *
 * @author <a href="mailto:chenlushun@51nbapi.com">陈录顺</a>
 */
@FunctionalInterface
public interface EventListener {

    void addListener(Object event);

}
