package com.sxt.node;

public interface IStack {

    /**
     * 清空栈
     */
    void clear();

    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 获取当前元素的长度
     * @return
     */
    int length();

    /**
     * 栈顶元素
     * @return
     */
    Object peek();

    /**
     * 进栈操作
     * @param x
     * @throws Exception
     */
    void push(Object x) throws Exception;

    /**
     * 出栈操作
     * @return
     */
    Object pop();
}
