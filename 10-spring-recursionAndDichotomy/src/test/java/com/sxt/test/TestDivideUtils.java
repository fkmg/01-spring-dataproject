package com.sxt.test;

import com.sxt.divide.DivideUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class TestDivideUtils {
    
    private DivideUtils divideUtils = new DivideUtils();
    
    @Test
    public void testRerverse(){
        String [] arrays = {"a","b","c","d","e","f","g"};
        divideUtils.reverse(arrays,3+1,arrays.length-1);
        System.out.println(StringUtils.join(arrays,","));
        
    }

    @Test
    public void testRightRotate(){
        String [] arrays = {"a","b","c","d","e","f","g"};
        //divideUtils.reverse(arrays,1,arrays.length-2);
        divideUtils.RightRotate(arrays,0,arrays.length-1,3);
        System.out.println(StringUtils.join(arrays,","));

    }
    
    @Test
    public void testDivideUtils(){
        String [] a ={"1","4","5","7","9","2","3","6","8"};
        divideUtils.RightRotate(a,1,6,4);
        System.out.println(StringUtils.join(a,","));
    }
}
