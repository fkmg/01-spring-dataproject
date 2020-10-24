package com.sxt.divide;



public class PointX extends Point {

    //点编号
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * 比较函数
     * @param o
     * @return
     */
    @Override
    public int compareTo(Point o) {
        int result = 0;

        if(this.getX()>o.getX()){
            result = 1;
        }else if(this.getX()<o.getX()){
            result = -1;
        }

        return result;
    }

    @Override
    public String toString() {
        return "PointX{" +
                "ID=" + ID +"(X="+getX()+",Y="+getY()+")"+
                '}';
    }
}
