package com.sxt.test;

import com.sxt.divide.ClosestApproach;
import com.sxt.divide.PointX;
import com.sxt.divide.PointY;
import org.junit.Test;

import java.util.Random;

public class TestClosestApproach {

   private ClosestApproach approach = new ClosestApproach();

    @Test
    public void testClosestApproach() throws Exception {

        //1、创建坐标
        PointX [] X = new PointX[4];
        Random random = new Random();
        PointY a=new PointY(),b=new PointY();
        for(int i = 0; i< X.length;i++){
            X[i] = new PointX();
            X[i].setID(i);
            X[i].setX(random.nextDouble()*100);
            X[i].setY(random.nextDouble()*100);
        }

        //解出最短距离
        double distance = approach.capir2(X,a,b, X.length);

        System.out.println("最短距离为:"+distance);

        System.out.println("点A:"+a);
        System.out.println("点B:"+b);
    }
}
