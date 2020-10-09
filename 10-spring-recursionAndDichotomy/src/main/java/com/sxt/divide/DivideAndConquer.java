package com.sxt.divide;

import java.util.Comparator;

/**
 * 分治
 */
public class DivideAndConquer<T>{

    /**
     * The comparator used to maintain order in this tree map, or
     * null if it uses the natural ordering of its keys.
     *
     * @serial
     */
    private final Comparator<? super T> comparator;

    public DivideAndConquer() {
        this.comparator = null;
    }

    public DivideAndConquer(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    /**
     * 判断泛型类是否实现了compareable接口
     */
    @SuppressWarnings("unchecked")
    final int compare(Object k1, Object k2) {
        return comparator==null ? ((Comparable<? super T>)k1).compareTo((T)k2)
                : comparator.compare((T)k1, (T)k2);
    }

    /**
     * 比较两个泛型类的大小
     * @param a
     * @param b
     * @return
     */
    public int comapareVaLues(T a,T b){
        int result = 0;
        //优先使用外部类
        Comparator<? super T> cpr = comparator;
        //使用外部类比较
        if (cpr != null) {
            result = cpr.compare(a,b);
        }else {
            Comparable<? super T> t = (Comparable<? super T>) a;
            result = t.compareTo(b);
        }
        return result;
    }

    /**
     * 二分搜索法,T必须重写equals方法
     * @param a(从数组 a 0-n位置查询元素x)
     * @param x
     * @return
     */
    public int binarySearch(T[] a,T x,int n){
        //0、首先验证是否实现了comapareable接口
        compare(x,x);
        //1、获取数组中点
        int left = 0,right = n-1 ,middle = 0, compare = 0;
        while (left <= right){
            middle = (left+right)/2;
            compare = comapareVaLues(a[middle],x);
            if(compare == 0){
                return middle;
            }else if(compare > 0){
                right = middle-1;
            }else {
                left = middle+1;
            }
        }
        //未查询到
        return -1;
    }
}
