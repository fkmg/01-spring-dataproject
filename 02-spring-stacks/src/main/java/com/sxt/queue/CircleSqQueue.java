package com.sxt.queue;

public class CircleSqQueue implements IQueue {

    //队列存储空间
    private Object [] queueElem;

    //队头
    private int front;

    //队尾
    private int rear;

    public CircleSqQueue(int maxSize) {

        //为队列分配存储单元
        this.queueElem = new Object[maxSize];
        //队头队尾初始化为零
        front = rear = 0;
    }

    @Override
    public void clear() {
        front = rear = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public int length() {
        return (front - rear +queueElem.length)%queueElem.length;
    }

    @Override
    public Object peek() {
        Object obj = null;
        if(!isEmpty()){
            obj = queueElem[front];
        }
        return obj;
    }

    @Override
    public void push(Object x) throws Exception {
        //1、判断队列是否已满
        int temp = (this.rear + 1)%queueElem.length;
        if(temp == front){
            throw new Exception("队列已满!!");
        }
        //进队
        queueElem[rear] = x;
        //改变队尾指针
        rear = temp;
    }

    @Override
    public Object pop() {
        Object obj = null;
        //1、判断队列是否为空
        if(!isEmpty()){
            obj = queueElem[front];
            //修改队头指针
            front = (front+1)%queueElem.length;
        }
        return obj;
    }
}
