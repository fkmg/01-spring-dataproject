package com.sxt.queue;

import com.sxt.bean.Node;

public class LinkQueue implements IQueue {

    //队头
    private Node front;

    //队尾
    private Node rear;

    public LinkQueue() {
        front = rear = null;
    }

    @Override
    public void clear() {
        front = rear = null;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int length() {
        Node p = front;
        int length = 0;
        while (p != null){
            length ++;
            p = p.next;
        }
        return length;
    }

    @Override
    public Object peek() {
        Object obj = null;
        //1、判断队列是否为空
        if (front != null){
            obj = front.data;
        }
        return obj;
    }

    @Override
    public void push(Object x) throws Exception {
        //1、创建节点
        Node node = new Node(x);
        //2、判断队列是否为空
        if(front == null){
            front = rear = node;
        }else {
            rear.next = node;
            rear = node;
        }
    }

    @Override
    public Object pop() {
        Object obj = null;
        //1、获取队头元素
        if(front != null){
            obj = front.data;
        }
        //2、判断队列是否仅有一个元素
        if (front == rear){
            front = rear = null;
        }else {
            front = front.next;
        }
        return obj;
    }
}
