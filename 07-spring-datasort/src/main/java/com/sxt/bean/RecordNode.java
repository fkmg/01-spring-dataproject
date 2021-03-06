package com.sxt.bean;

public class RecordNode {
    private Comparable key; //关键字

    private Object element; //数据元素

    public Comparable getKey() {
        return key;
    }

    public void setKey(Comparable key) {
        this.key = key;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public RecordNode(Comparable key, Object element) {
        this.key = key;
        this.element = element;
    }

    public RecordNode() {
    }

    @Override
    public String toString() {
        return "RecordNode{" +
                "key=" + key +
                ", element=" + element +
                '}';
    }
}
