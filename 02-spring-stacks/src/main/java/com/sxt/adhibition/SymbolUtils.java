package com.sxt.adhibition;

import com.sxt.node.SqStack;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class SymbolUtils {

    //记录分割符为左分割符
    private final int LEFT = 0;

    //记录分割符为右分割符
    private final int RIGHT = 1;

    //记录分割符为其他的分割符
    private final int OTHER = 2;

    /**
     * 判断分割符类型
     * @param str
     * @return
     */
    private int verifyFlag(String str){

        int result = OTHER;

        if("(".equals(str) || "[".equals(str) ||
        "{".equals(str) || "/*".equals(str)){
            result = LEFT;
        }else if(")".equals(str) || "]".equals(str) ||
                "}".equals(str) || "*/".equals(str)){
            result = RIGHT;
        }

        return result;
    }

    /**
     * 判断括号是否匹配
     * @param str1
     * @param str2
     * @return
     */
    private boolean matches(String str1,String str2){
        boolean flag = false;

        if("(".equals(str1) && ")".equals(str2) || "[".equals(str1) && "]".equals(str2) ||
                "{".equals(str1) && "}".equals(str2) || "/*".equals(str1) && "*/".equals(str2)){
            flag = true;
        }

        return flag;
    }

    /**
     * 判断表达式是否合法
     * @param str
     * @return
     * @throws Exception
     */
    public boolean isLeagal(String str) throws Exception {
        boolean flag = false;
        //1、判断字符串是否为空
        if (StringUtils.isNotBlank(str)){
            SqStack S = new SqStack(100);
            StringBuffer sb = new StringBuffer(str);
            int length = sb.length();
            char c = 0;
            String t = null;
            int verify = 0;
            Object obj = null;
            for(int i = 0; i< length;i++){
                c = sb.charAt(i);
                t = String.valueOf(c);
                if(i != length){
                    if('/' == c && '*' == sb.charAt(i+1) ||
                            '*' == c && '/' == sb.charAt(i+1)){
                        t = t.concat(String.valueOf(sb.charAt(i+1)));
                        ++i;
                    }
                }
                //判定符号
                verify = verifyFlag(t);
                //判断是否为左分割符
                if(LEFT == verify){
                    //进栈
                    S.push(t);
                }else if(RIGHT == verify){
                    //出栈操作
                    obj = S.pop();
                    //判断左右括号是否匹配
                    if(obj == null || !matches(obj.toString(),t)){
                        flag = true;
                        break;
                    }
                }
            }

            //判断栈是否为空
            if(!S.isEmpty()){
                flag = true;
            }
        }else {
            flag = true;
        }

        return !flag;
    }

    public static void main( String[] args ) throws Exception {

        SymbolUtils symbolUtils = new SymbolUtils();
        Scanner sc = new Scanner(System.in);
        String str = null;
        boolean flag = true;
        boolean isLeagle = false;
        while (flag){
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
        }
    }


}
