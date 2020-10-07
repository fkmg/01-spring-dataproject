package com.sxt.node;

import com.sxt.bean.Node;

public class LinkStack implements IStack {

    //栈顶元素
    private Node top;

    public void clear() {
        this.top = null;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public int length() {
        int length = 0;
        Node p = this.top;
        while (p != null){
            length++;
            p = p.next;
        }
        return length;
    }

    public Object peek() {
        Object result = null;
        if(!isEmpty()){
            result = top.data;
        }
        return result;
    }

    public void push(Object x) throws Exception {
        //1、进栈操作
        Node node = new Node(x);
        node.next = top;
        top = node;
    }

    public Object pop() {
        Object result = null;
        //1、判断栈是否为空
        if(!isEmpty()){
            result = top.data;
            top = top.next;
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        Node p = this.top;
        while (p != null){
            result = String.valueOf(p.data).concat(result);
            p = p.next;
        }
        return result;
    }
}
