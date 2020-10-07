package com.sxt.test;

import com.sxt.adhibition.SignificantDigits;
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

    @Test
    public void testAdd() throws Exception{
        SignificantDigits digits = new SignificantDigits();
        String x1 = "18 452 543 389 943 209 752 345 473";
        String x4 = "18 452 543 389 943 209 752 345 473";
        String x2 = "8 123 542 678 432 986 899 334";

        String x3 = "18444419847264776765446139";
        String add = digits.add(x3, x2);
        System.out.println("两个大整数的和为: "+add);
    }

    @Test
    public void testSubstract() throws Exception{
        SignificantDigits digits = new SignificantDigits();
        String x1 = "18 452 543 389 943 209 752 345 473";
        String x3 = "18 452 543 389 943 209 752 345 471";
        String x2 = "8 123 542 678 432 986 899 334";
        //String add = digits.add(x1, x2);
        //System.out.println("x1 - x3: "+digits.minus(x1,x3));
        //System.out.println("x3 - x1: "+digits.minus(x3,x1));
        System.out.println("x1 - x2: "+digits.minus(x1,x2));
        System.out.println("x2 - x1: "+digits.minus(x2,x1));
    }
}
