package com.sxt.queue;

public interface IQueue {

    /**
     * 清空队列
     */
    void clear();

    /**
     * 判断队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 获取当前元素的长度
     * @return
     */
    int length();

    /**
     * 队头元素
     * @return
     */
    Object peek();

    /**
     * 入队操作
     * @param x
     * @throws Exception
     */
    void push(Object x) throws Exception;

    /**
     * 出队操作
     * @return
     */
    Object pop();
}
