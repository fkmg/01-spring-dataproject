package com.sxt.divide;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class DivideUtils {

    private Logger logger = Logger.getLogger(DivideUtils.class);

    /**
     * 反转数组 arrays 从位置l-r
     * @param arrays
     * @param l
     * @param r
     */
    public void reverse(Object [] arrays,int l,int r){
        Object temp = null;
        //1、求取中点
        int m = (r+l)/2,i=l,j=r;

        while (i<=m){
            temp = arrays[i];
            arrays[i] = arrays[j];
            arrays[j] = temp;
            i++;
            j--;
        }
    }

    /**
     * 循环将数组 begin-end循（让begin:begin+len-1 与begin+len：end 进行换位）
     * @param arrays
     * @param begin
     * @param len
     */
    public void RightRotate(Object[] arrays,int begin,int end,int len){
        //将数组begin- begin+len-1位进行逆运算
        reverse(arrays,begin,begin+len-1);
        logger.debug(StringUtils.join(ArrayUtils.subarray(arrays,begin,begin+len+1),","));
        //begin+len - end 进行逆运算
        reverse(arrays,begin+len,end);
        logger.debug(StringUtils.join(ArrayUtils.subarray(arrays,begin+len+1,end+1),","));
        //对数组begin处开始做逆运算
        reverse(arrays,begin,end);
    }
}
