package com.sxt.node;

public class SqStack implements IStack {

    //对象数组
    private Object [] stackElem;

    //栈顶
    private int top;

    public SqStack(int maxSize) {

        stackElem = new Object[maxSize];

        this.top = 0;
    }

    public void clear() {
        this.top = 0;
    }

    public boolean isEmpty() {
        return this.top == 0;
    }

    public int length() {
        return top;
    }

    public Object peek() {
        Object result = null;

        if(this.stackElem != null){
            result = this.stackElem[top];
        }
        return result;
    }

    public void push(Object x) throws Exception {
        //1、判断栈是否满
        if(top == stackElem.length){
            throw new Exception("栈已满");
        }

        //2、栈不满时栈顶先增再进栈
        stackElem[top++] = x;
    }

    public Object pop() {
        Object result = null;
        //1、判断栈是否为空
        if(!isEmpty()){
            result = this.stackElem[--top];
        }
        return result;
    }
}
