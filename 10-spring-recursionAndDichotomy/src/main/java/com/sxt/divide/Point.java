package com.sxt.divide;


import java.io.Serializable;

/**
 * 平面坐标
 */
public abstract class Point implements Comparable<Point> , Serializable {

    //点坐标
    private double x,y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * 求两点距离
     * @param u
     * @param v
     * @return
     */
    public double distance(Point u,Point v){
        double dx = u.x - v.x;
        double dy = u.y - v.y;
        return Math.sqrt(dx*dx+dy*dy);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
