package com.sxt.divide;

public class PointY extends Point {

    //同一点在数组X中的坐标
    private int p;

    @Override
    public int compareTo(Point o) {
        int result = 0;

        if(this.getY()>o.getY()){
            result = 1;
        }else if(this.getY()<o.getY()){
            result = -1;
        }

        return result;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "PointY{" +
                "p=" + p +"(X="+getX()+",Y="+getY()+")"+
                '}';
    }
}
