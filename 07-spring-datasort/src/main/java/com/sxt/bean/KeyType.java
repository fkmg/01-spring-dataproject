package com.sxt.bean;

public class KeyType implements Comparable<KeyType> {

    //key 可以是 String,Integer,Float,Double等类型
    private Object key;

    public KeyType(Object key) {
        this.key = key;
    }

    public KeyType() {
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    @Override
    public int compareTo(KeyType another) {
        Integer result = 0;

        //判断类型
        if(key instanceof Integer){
           result = compareIntegerKey(another);
        }else if(key instanceof Double){
            result = compareDoubleKey(another);
        }
        return result;
    }

    private int compareIntegerKey(KeyType another){
        return (Integer)key - (Integer)another.getKey();
    }

    private int compareDoubleKey(KeyType another){
        int result = 0;

        Double thisVal = (Double)this.key;

        Double anotherVal = (Double)another.getKey();

        double v = thisVal - anotherVal;

        if(v>0.0){
            result = 1;
        }else if(v < 0.0){
            result = -1;
        }

        return result;
    }

    @Override
    public String toString() {
        return "KeyType{" +
                "key=" + key +
                '}';
    }
}
