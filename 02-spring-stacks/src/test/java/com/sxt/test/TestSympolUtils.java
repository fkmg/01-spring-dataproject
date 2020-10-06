package com.sxt.test;

import com.sxt.adhibition.SymbolUtils;
import org.junit.Test;

import java.util.Scanner;

public class TestSympolUtils {

    @Test
    public void scanner() throws Exception {

        Scanner sc = new Scanner(System.in);
        String str = null;
        boolean flag = true;
        boolean isLeagle = false;
        SymbolUtils symbolUtils = new SymbolUtils();
        while (true){
            //验证输入字符串的正确性
            System.out.println("请输入Java语句:");
            str = sc.nextLine();
            isLeagle = symbolUtils.isLeagal(str);
            if(isLeagle){
                System.out.println("输入语句:"+str+"合法");
            }else {
                System.out.println("输入语句:"+str+"不合法");
            }

            System.out.println("请输入是否继续测试??true or false");
            flag = sc.nextBoolean();

            if (flag){
                break;
            }
        }
    }
}
