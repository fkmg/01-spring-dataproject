package com.sxt.test;

import com.sxt.divide.DivideAndConquer;
import com.sxt.divide.Hamilton;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

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

    @Test
    public void testMergeSort() throws Exception{
        DivideAndConquer<Persion> divideAndConquer = new DivideAndConquer<Persion>(new Comparator<Persion>() {
            public int compare(Persion o1, Persion o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        Random random = new Random();
        Persion[] persions = new Persion[10];
        for(int i = 0; i< persions.length;i++){
            persions[i] = new Persion(random.nextInt(10)*10+1,"小".concat(String.valueOf(i)));
        }
        divideAndConquer.MergeSort(persions);
        for(int i = 0; i< persions.length;i++){
            System.out.println(persions[i]);
        }
    }

    @Test
    public void testQuickSort(){
        DivideAndConquer<Persion> divideAndConquer = new DivideAndConquer<Persion>(new Comparator<Persion>() {
            public int compare(Persion o1, Persion o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        Random random = new Random();
        Persion[] persions = new Persion[10];
        for(int i = 0; i< persions.length;i++){
            persions[i] = new Persion(random.nextInt(100)*10+1,"小".concat(String.valueOf(i)));
        }
        divideAndConquer.quickSort(persions,0,persions.length-1);
        for(int i = 0; i< persions.length;i++){
            System.out.println(persions[i]);
        }
    }

    @Test
    public void testRandomizedQuickSort(){
        DivideAndConquer<Persion> divideAndConquer = new DivideAndConquer<Persion>(new Comparator<Persion>() {
            public int compare(Persion o1, Persion o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        Random random = new Random();
        Persion[] persions = new Persion[10];
        for(int i = 0; i< persions.length;i++){
            persions[i] = new Persion(random.nextInt(100)*10+1,"小".concat(String.valueOf(i)));
        }
        divideAndConquer.radomizedQuickSort(persions,0,persions.length-1);
        for(int i = 0; i< persions.length;i++){
            System.out.println(persions[i]);
        }
    }

    @Test
    public void testIsertSort(){
        DivideAndConquer<Persion> divideAndConquer = new DivideAndConquer<Persion>(new Comparator<Persion>() {
            public int compare(Persion o1, Persion o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        Random random = new Random();
        Persion[] persions = new Persion[100];
        for(int i = 0; i< persions.length;i++){
            persions[i] = new Persion(random.nextInt(100)*10+1,"小".concat(String.valueOf(i)));
        }
        divideAndConquer.insertSort(persions);
        for(int i = 0; i< persions.length;i++){
            System.out.println(persions[i]);
        }
    }

    @Test
    public void testRandomizedSelected(){
        DivideAndConquer<Persion> divideAndConquer = new DivideAndConquer<Persion>(new Comparator<Persion>() {
            public int compare(Persion o1, Persion o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        Random random = new Random();
        Persion[] persions = new Persion[10];
        for(int i = 0; i< persions.length;i++){
            persions[i] = new Persion(random.nextInt(100)*10+1,"小".concat(String.valueOf(i)));
            System.out.println(persions[i]);
        }
        Persion persion = divideAndConquer.randomizedSelect(persions, 0, persions.length - 1, 6);
        divideAndConquer.radomizedQuickSort(persions,0,persions.length-1);
        for(int i = 0; i< persions.length;i++){
            System.out.println(persions[i]);
        }
        
        System.out.println("最终结果为:"+persion);
    }

    @Test
    public void testRandomizedSelecteds(){
        DivideAndConquer<Persion> divideAndConquer = new DivideAndConquer<Persion>(new Comparator<Persion>() {
            public int compare(Persion o1, Persion o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        Random random = new Random();
        Persion[] persions = new Persion[10];
        for(int i = 0; i< persions.length;i++){
            persions[i] = new Persion(random.nextInt(100)*10+1,"小".concat(String.valueOf(i)));
            System.out.println(persions[i]);
        }
        Persion persion = divideAndConquer.randomizedSelects(persions, 0, persions.length - 1, 6);
        divideAndConquer.radomizedQuickSort(persions,0,persions.length-1);
        for(int i = 0; i< persions.length;i++){
            System.out.println(persions[i]);
        }

        System.out.println("最终结果为:"+persion);
    }

    @Test
    public void testSelect(){
        int x = 61;
        //数组a存了0-79
        Integer[] a={3,1,7,6,5,9,8,2,0,4,13,11,17,16,15,19,18,12,10,14,23,21,27,26,25,29,28,22,20,24,33,31,37,36,35,39,38,32,30,34,43,41,47,46,45,49,48,42,40,44,53,51,57,56,55,59,58,52,50,54,63,61,67,66,65,69,68,62,60,64,73,71,77,76,75,79,78,72,70,74,
        };
        DivideAndConquer<Integer> divideAndConquer = new DivideAndConquer<Integer>();
        Integer select = divideAndConquer.Select(a, 0, a.length - 1, x);
        System.out.println("第"+(x)+"大元素为:"+select);
    }

    @Test
    public void testRandom(){
        List<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        for(int i = 0; i< 10000;i++){
            int x = random.nextInt(16)+10;
            System.out.print(x+"\t");
            if((i+1)%15 == 0){
                System.out.println();
            }
            if(x>25){
                list.add(x);
            }

        }

        System.out.println(StringUtils.join(list));
    }
    
    @Test
    public void testCombineArray(){
        Integer [] a ={1,4,5,7,9,2,3,6,8,10};
        DivideAndConquer<Integer> divideAndConquer = new DivideAndConquer<>();
        divideAndConquer.combineArray(a,0,5,a.length-1);
        System.out.println(StringUtils.join(a,","));
    }

    @Test
    public void testCalculateMode(){
        Integer [] a =new Integer[100];
        Random random = new Random();
        for(int i = 0; i< a.length;i++){
            a[i] = random.nextInt(100)*2+10;
        }
        System.out.println(StringUtils.join(a,","));
        DivideAndConquer<Integer> divideAndConquer = new DivideAndConquer<>();
        Map<String, Object> map = divideAndConquer.calculateMode(a, 0, a.length - 1);
        Object mode = map.get("mode");
        Object num = map.get("num");
        System.out.println("众数为:"+mode+",重数为:"+num);
    }

    @Test
    public void testHamiltion() throws IOException {
        Hamilton hamilton = new Hamilton();
        Integer [][] board = new Integer[6][6];
        for(int i = 0; i< board.length;i++){
            for (int j = 0;j<board[i].length;j++){
                board[i][j] = 0;
            }
        }
        //设置起始位置
        board[0][0] = 1;
        hamilton.setBoard(board);
        hamilton.move(0,0,2);
        board = hamilton.getBoard();
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

