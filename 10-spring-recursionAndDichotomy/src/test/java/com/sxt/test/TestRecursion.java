package com.sxt.test;

import com.sxt.recursion.Recursion;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestRecursion {

    @Test
    public void testPerm(){
        Recursion<String> recursion = new Recursion<String>();
        String[] array = {"a","b","c"};
        List<String> result = new ArrayList<String>();
        recursion.Perm(array,0,array.length-1,result);
        
        //判断result数量
        System.out.println("排序数量为:"+result.size());
        
        System.out.println("排列为:");
        System.out.println(StringUtils.join(result,"\n"));
    }
}
