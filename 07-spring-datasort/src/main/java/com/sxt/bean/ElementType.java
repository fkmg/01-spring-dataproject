package com.sxt.bean;

public class ElementType {

    private Object data;

    public ElementType(Object data) {
        this.data = data;
    }

    public ElementType() {
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ElementType{" +
                "data=" + data +
                '}';
    }
}
