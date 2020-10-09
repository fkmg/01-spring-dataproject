package com.sxt.test;

import com.sxt.divide.DivideAndConquer;
import org.junit.Test;

import java.util.Comparator;

public class TestDivideAndConquer {

    @Test
    public void testBasicDataType(){
        String [] letter = {"a","b","c","d","e","f","g","h","i","j","k","l","m",
        "n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String search = "z";
        DivideAndConquer<String> divideAndConquer = new DivideAndConquer<String>();
        int g = divideAndConquer.binarySearch(letter, search, letter.length);
        System.out.println(search+"在数组中的位置为:"+g);
    }

    @Test
    public void testClass(){
        DivideAndConquer<Persion> divideAndConquer = new DivideAndConquer<Persion>(new Comparator<Persion>() {
            //对象比较器(按照年龄排序)
            public int compare(Persion o1, Persion o2) {
                return o1.getAge()-o2.getAge();
            }
        });

        DivideAndConquer<Persion> conquer = new DivideAndConquer<Persion>();

        //创建对象数组
        Persion[] persions = new Persion[5];
        for(int i = 0; i< persions.length;i++){
            persions[i] = new Persion(2*i+10,"小".concat(String.valueOf(i)));
        }

        Persion search = new Persion(14, "小2");
        int i = divideAndConquer.binarySearch(persions, search, persions.length);
        System.out.println("查询结果:"+i);
        //验证:
        conquer.binarySearch(persions,search,persions.length);
        System.out.println("game over!");
    }

}

class Persion {

    public Persion() {
    }

    public Persion(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    //年龄
    private Integer age;
    
    //姓名
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

