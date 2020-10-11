package com.sxt.divide;

import org.apache.log4j.Logger;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Random;

/**
 * 分治
 * 1、折半查找
 * 2、合并排序
 * 3、快速排序
 * 4、线性选择
 */
public class DivideAndConquer<T>{

    private Logger log = Logger.getLogger(DivideAndConquer.class);

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

    /**
     * 合并排序
     * @param a
     */
    public void MergeSort(T[] a) throws Exception{
        //一、校验对象是否实现了comapre接口
        compare(a[0],a[0]);
        log.debug("此对象已经实现了Comapre接口!");
        T[] b = (T[]) Array.newInstance(a[0].getClass(), a.length);
        //二、合并排序主算法
        //1、步长从1开始
        int s = 1;
        while (s<a.length){
            //合并到数组b
            MergePass(a,b,s);
            s+=s;
            //合并到数组a
            MergePass(b,a,s);
            s+=s;
        }
    }

    /**
     * 合并排序好的两个相邻的数组段
     * @param x
     * @param y
     * @param s
     */
    private void MergePass(T[] x, T[] y,int s) throws Exception{
        //合并相邻大小为s的两个数组段
        int i = 0;
        while (i<=x.length-2*s){
            Merge(x,y,i,i+s-1,i+2*s-1);
            i=i+2*s;
        }
        if(i+s<x.length){
            Merge(x,y,i,i+s-1,x.length-1);
        }else {
            for(int j = i; j< x.length;j++){
                y[j] = x[j];
            }
        }
    }

    /**
     * 将数组c l:m m+1:r合并到数组d中
     * @param c
     * @param d
     * @param l
     * @param m
     * @param r
     */
    private void Merge(T[] c,T[] d,int l,int m,int r) throws Exception {
        int i =l,j=m+1,k=l,compare=0,q=0,w=0;
        while (i<=m && j<=r){
            try {
                compare = comapareVaLues(c[i],c[j]);
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("此时i的值为:"+i);
                System.out.println("此时j的值为:"+j);
                throw e;
            }
            if(compare <= 0){
               d[k++] = c[i++];
           }else {
               d[k++] = c[j++];
           }
        }

        if(i>m){
            q = j;
            w = r;
        }else {
            q = i;
            w = m;
        }
        for(int x = q; x<=w;x++){
            try {
                d[k++] = c[x];
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("此时x的值为:"+x);
                System.out.println("此时k的值为:"+k);
                throw e;
            }
        }
    }

    /**
     * 快速排序
     * @param a
     * @param p
     * @param r
     */
    public void quickSort(T[] a,int p,int r){
        if(p < r){
            int q = partition(a, p, r);
            //对左半部分排序
            quickSort(a,p,q-1);
            //对右半部分进行排序
            quickSort(a,q+1,r);
        }
    }

    /**
     * 每执行一次都确定一个元素的位置
     * @param a
     * @param p
     * @param r
     * @return
     */
    private int partition(T[] a, int p,int r){
        int i = p,j = r+1;
        //1、确定基准元素
        T x = a[p];
        while (true){
            while (comapareVaLues(a[++i],x)<0 && i<r);
            while (comapareVaLues(a[--j],x)>0);
            if (i >= j) {
                break;
            }
            Swap(a,i,j);
        }
        a[p] = a[j];
        a[j] = x;

        return j;
    }

    /**
     * 随机产生基准位置
     * @param a
     * @param p
     * @param r
     * @return
     */
    private int randomizedParition(T[] a,int p,int r){
        //1、随机产生基准位置
        int i = randomXAndY(p, r);
        //log.debug("随机基准位置为:"+i);
        //2、交换位置
        Swap(a,p,i);
        return partition(a,p,r);
    }

    /**
     * 随机划分快速排序
     * @param a
     * @param p
     * @param r
     */
    public void radomizedQuickSort(T[] a, int p,int r){
        if(p<r){
            int q = randomizedParition(a, p, r);
            //对左半部分排序
            radomizedQuickSort(a,p,q-1);
            //对右半部分进行排序
            radomizedQuickSort(a,q+1,r);
        }
    }

    /**
     * 交换数组 a与b的位置
     * @param list
     * @param a
     * @param b
     */
    public void Swap(T[] list,int a,int b){
        T temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }

    /**
     * 产生【x-y】之间的随机数
     * @param x
     * @param y
     * @return
     */
    public int randomXAndY(int x,int y){
        Random random = new Random();
        return random.nextInt(y - x + 1) + x;
    }

    /**
     * 从数组a中查询出第k个大小对象
     * @param a
     * @param p
     * @param r
     * @param k
     * @return
     */
    public T randomizedSelect(T[] a,int p,int r,int k){
        log.debug("p:"+p+"\tr:"+r+"\tk:"+k);
        /*if(p == r){
            return a[p];
        }*/
        int i = randomizedParition(a,p,r);
        log.debug("确定出第"+(i+1)+"个数");
        int j = i+1;
        if(k<j){
            return randomizedSelect(a,p,i-1,k);
        }else if (k>j){
            return randomizedSelect(a,i+1,r,k);
        }else {
            return a[i];
        }
    }

    /**
     * 从数组a中查询出第k个大小对象
     * @param a
     * @param p
     * @param r
     * @param k
     * @return
     */
    public T randomizedSelects(T[] a,int p,int r,int k){
        log.debug("p:"+p+"\tr:"+r+"\tk:"+k);
        if(p == r){
            return a[p];
        }
        int i = randomizedParition(a,p,r);
        log.debug("确定出第"+(i+1)+"个数");
        int j = i-p+1;
        if(k<=j){
            return randomizedSelects(a,p,i,k);
        }else {
            return randomizedSelects(a,i+1,r,k-j);
        }
    }

}

/**
 * 得到泛型数组
 */
class GenericsArray<T> {

    //维护Object[]类型数组
    private Object[] array;

    @SuppressWarnings("unchecked")
    public GenericsArray(int size) {
        this.array = new Object[size];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    //数组对象出口强转
    public T get(int index) {
        return (T)array[index];
    }

    @SuppressWarnings({ "unchecked", "hiding" })
    public static <T>  T[] getArray(Class<T> componentType,int length) {
        return (T[]) Array.newInstance(componentType, length);
    }
}
