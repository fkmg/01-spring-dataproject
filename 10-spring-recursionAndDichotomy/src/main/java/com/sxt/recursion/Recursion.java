package com.sxt.recursion;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 递归问题
 */
public class Recursion<T> {

    /**
     * 排列问题(注:此方法产生的是 集合list（K:M）的全排列)
     * @param list
     * @param k
     * @param m
     */
    public void Perm(T [] list, int k, int m, List<String>result){
        //1、判断k是否等于m
        if(k == m){
            result.add(StringUtils.join(list,","));
        }else{
            //2、若k <> m,分别将集合中(K:M)位置的元素放到k处
            for(int i = k; i<=m;i++){
                Swap(list,k,i);
                Perm(list,k+1,m,result);
                Swap(list,k,i);
            }

        }
    }

    /**
     * 交换数组 a与b的位置
     * @param list
     * @param a
     * @param b
     */
    public void Swap(T [] list,int a,int b){
        T temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
}
