package com.sxt.list;

/**
 * 链表接口
 */
public interface IList {

    /**
     * 清空线性表
     */
    void clear();

    /**
     * 判断线性表是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 得到线性表的长度
     * @return
     */
    int length();

    /**
     * 查找线性表中第i个元素的值
     * (i>=0&&i<length-1)
     * @param i
     * @return
     * @throws Exception
     */

    Object get(int i) throws Exception;
    /**
     * 向线性表中插入一个元素
     * i>=0&&i<=length
     * @param i
     * @param x
     */
    void insert(int i,Object x) throws Exception;

    /**
     * 从线性表中移除第i个元素
     * (i>=0&&i<length-1)
     * @param i
     */
    void remove(int i) throws Exception;

    /**
     * 返回x在线性表中首次出现的索引
     * @param x
     * @return
     * @throws Exception
     */
    int indexOf(Object x);

    /**
     * 输出各个元素的值
     */
    void display();
}
