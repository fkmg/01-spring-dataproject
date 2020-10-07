package com.sxt.adhibition;

import com.sxt.node.LinkStack;
import org.apache.commons.lang3.StringUtils;

/**
 * 大整数相加减问题
 */
public class SignificantDigits {

    /**
     * 将大整数字符串进栈(并验证数字字符串的正确性)
     * @param str
     */
    private LinkStack numSplit(String str) throws Exception {
        LinkStack stack = new LinkStack();

        if (StringUtils.isBlank(str)){
            throw new Exception("数字字符串:"+str+"不得为空!");
        }

        StringBuffer sb = new StringBuffer(str);

        int length = sb.length();

        char c = 0;

        for (int i = 0;i < length;i++){
           c = sb.charAt(i);
           //去除空格
           if(' ' == c){
               continue;
           }
           //合法的字符
           if(Character.isDigit(c)){
               stack.push(Integer.valueOf(String.valueOf(c)));
           }else {
               throw new Exception("error:输入了非数字型字符!");
           }
        }

        return stack;
    }

    /**
     * 大整数相加
     * @param x1
     * @param x2
     * @return
     * @throws Exception
     */
    public String add(String x1,String x2) throws Exception{
        //1、声明变量
        int a = 0;
        int b = 0;
        int sum = 0;
        int partialSum = 0;
        String result = "";

        //2、将两个大整数字符串进栈
        LinkStack sA = numSplit(x1);
        LinkStack sB = numSplit(x2);
        LinkStack sumC = new LinkStack();
        LinkStack temp = null;

        //3、将两个大整数字符串进行相加

        //情况一:两个栈都不为空
        while (!sA.isEmpty() && !sB.isEmpty()){
            a = (Integer) sA.pop();
            b = (Integer) sB.pop();
            //和为a+b+进位
            sum = a+b+partialSum;
            //将和的个位数进栈十位数赋予进位变量
            sumC.push(sum%10);
            partialSum = sum/10;
        }

        //情况二:其中一个栈为空
        temp = sA.isEmpty() ? sB : sA;

        //进位标识不为零
        while (!temp.isEmpty() && partialSum != 0){
            a = (Integer) temp.pop();
            sum = a + partialSum;
            sumC.push(sum%10);
            partialSum = sum/10;
        }

        //进位标识已为零
        while (!temp.isEmpty()){
           sumC.push(temp.pop());
        }

        //判断进位标识是否不等于零
        if(partialSum != 0){
            sumC.push(partialSum);
        }

        //4、将结果出栈
        while (!sumC.isEmpty()){
            result =  result.concat(String.valueOf(sumC.pop()));
        }
        return result;
    }


    /**
     * 两个大整数的大小
     * @param sA
     * @param sB
     * @return
     */
    private int judgeStringNum(LinkStack sA,LinkStack sB) throws Exception {
        int result = -1;

        if(sA.isEmpty() || sB.isEmpty()){
            throw new Exception("错误:其中一个大整数为空!!!");
        }
        //获取两个大整数字符串
        String num1 = sA.toString();
        String num2 = sB.toString();
        int lengthSA = sA.length();
        int lengthSB = sB.length();
        result = lengthSA - lengthSB;
        if (result == 0){
            result = num1.compareTo(num2);
        }
        return result;
    }

    /**
     * 大整数相减
     * @param x1
     * @param x2
     * @return
     * @throws Exception
     */
    public String minus(String x1,String x2) throws Exception{
        //1、声明变量
        int a = 0;
        int b = 0;
        int sum = 0;
        int partialSum = 0;
        String result = "";
        String symbol = "";

        //2、将两个大整数字符串进栈
        LinkStack sA = numSplit(x1);
        LinkStack sB = numSplit(x2);
        LinkStack sumC = new LinkStack();
        LinkStack temp = null;

        //判定两个大整数字符串的大小(若x1 小于x2)
        int compare = judgeStringNum(sA, sB);
        if(compare < 0){
            //变号
            symbol = symbol.concat("-");
            //交换变量
            temp = sA;
            sA = sB;
            sB = temp;
        }
        //3、将两个大整数字符串进行相减
        if(compare != 0){
            //情况一:两个栈都不为空
            while (!sB.isEmpty()){
                a = (Integer) sA.pop();
                b = (Integer) sB.pop();
                //和为a-b+进位
                sum = a-b+partialSum;
                //判定sum是否大于等于零
                if(sum < 0){
                    //需要借位
                    sum += 10;
                    partialSum = -1;
                }else {
                    partialSum = 0;
                }
                sumC.push(sum);
            }

            //情况二:其中一个栈为空定是值较小的一个
            temp = sA;

            //进位标识不为零
            while (!temp.isEmpty() && partialSum != 0){
                a = (Integer) temp.pop();
                sum = a + partialSum;
                //判定sum大小
                if(sum < 0){
                    sum += 10;
                    partialSum = -1;
                }else {
                    partialSum = 0;
                }
                sumC.push(sum);
            }

            //进位标识已为零
            while (!temp.isEmpty()){
                sumC.push(temp.pop());
            }

            //4、将结果出栈
            while (!sumC.isEmpty()){
                result =  result.concat(String.valueOf(sumC.pop()));
            }

            //截取前几位为零的数字
            int length = result.length();
            char c = ' ';
            //查询首个不为零的字符
            int index = 0;
            for(int i = 0; i< length;i++){
                c = result.charAt(i);
                if (c == '0'){
                    index ++;
                }else {
                    break;
                }
            }

            if(index > 0){
                result = result.substring(index);
            }

            //拼接结果
            result = symbol + result;
        }else {
            result = "0";
        }


        return result;
    }
}
