
### lambda 的几种写法

1、无入参，无返回值

```java

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

```

2、有入参，无返回值

```java
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
```

3、有入参数，有返回值

```java

BinaryOperator<Long> binaryOperator = (x, y) -> x + y;

```
### 几个需要注意的点

1、引用值，而不是变量


```java
Map<Integer, String> map = new HashMap<>();
final int value1 = 1;
int value2 = 2;
map.forEach((key, value) -> {
    value2 = 2; // 编译报错
    int value3 = value1;
    int value4 = value2;
});
```
提示：lambda表达式中，无法使用非终态变量，这里value2虽然没有用final修饰，但是默认时不可变的，如果对value2进行重新赋值就会报错

2、@FunctionalInterface

```java
@FunctionalInterface
public interface Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see     java.lang.Thread#run()
     */
    public abstract void run();
```

提示：@FunctionalInterface的作用是告诉java编译器接口采用函数接口编译，符合函数接口规范，如果不符合函数接口规范，则在编译期报错

