package com.sxt.divide;

import org.apache.log4j.Logger;

import java.io.*;

/**
 * 求解最接近点问题
 */
public class ClosestApproach {

    private DivideAndConquer<Point> divideAndConquer = new DivideAndConquer<>();

    private Point point = new PointY();

    private final Logger logger = Logger.getLogger(ClosestApproach.class);

    /**
     * 求解最接近点问题
     * @param X
     * @param n
     * @return
     */
    public double capir2(PointX[] X,PointY a,PointY b,int n) throws Exception {
        if(n<2){
            throw new Exception("至少需两个点!");
        }

        //对节点按照x轴排序
        divideAndConquer.MergeSort(X);

        //创建PointY对象
        PointY[] Y = new PointY[n];
        for(int i = 0; i< n;i++){
            Y[i] = new PointY();
            Y[i].setX(X[i].getX());
            Y[i].setY(X[i].getY());
            Y[i].setP(i);
        }
        //对Y进行排序
        divideAndConquer.MergeSort(Y);

        PointY [] Z = new PointY[n];
        double closet = closet(X, Y, Z, a, b, 0, n - 1);
        return closet;
    }

    /**
     * 具体的最接近点问题
     * @param X
     * @param Y
     * @param Z
     * @param l
     * @param r
     * @return
     */
   private double closet(PointX[] X,PointY[] Y,PointY[] Z,
                         PointY a,PointY b,int l,int r) throws Exception {

        double minDistance = Double.MAX_VALUE;
        //判断节点个数
        switch ((r-l)){
            //1、两点情形
            case 1:{
                minDistance = point.distance(X[l],X[r]);
                a.setX(X[l].getX());
                a.setY(X[l].getY());
                a.setP(l);
                b.setX(X[r].getX());
                b.setY(X[r].getY());
                b.setP(r);
                logger.debug("点:"+X[l].getID()+"与点:"+X[r].getID()+"间的距离为:"+minDistance);
                break;
            }
            //2、三点情形
            case 2:{
                double d1 = point.distance(X[l],X[r]);
                logger.debug("点:"+X[l].getID()+"与点:"+X[r].getID()+"间的距离为:"+d1);
                double d2 = point.distance(X[l],X[l+1]);
                logger.debug("点:"+X[l].getID()+"与点:"+X[l+1].getID()+"间的距离为:"+d2);
                double d3 = point.distance(X[l+1],X[r]);
                logger.debug("点:"+X[l+1].getID()+"与点:"+X[r].getID()+"间的距离为:"+d3);
                minDistance = Math.min(d1,d2);
                minDistance = Math.min(minDistance,d3);
                if(minDistance == d1){
                    a.setX(X[l].getX());
                    a.setY(X[l].getY());
                    a.setP(l);
                    b.setX(X[r].getX());
                    b.setY(X[r].getY());
                    b.setP(r);
                }else if(minDistance == d2){
                    a.setX(X[l].getX());
                    a.setY(X[l].getY());
                    a.setP(l);
                    b.setX(X[l+1].getX());
                    b.setY(X[l+1].getY());
                    b.setP(l+1);
                }else {

                    a.setX(X[l+1].getX());
                    a.setY(X[l+1].getY());
                    a.setP(l+1);
                    b.setX(X[r].getX());
                    b.setY(X[r].getY());
                    b.setP(r);
                }
                break;
            }
            //3、大于等于四点情况
            default:{
                int m = (l+r)/2;
                int f = l,g = m+1;
                PointY ar= new PointY(),br=new PointY();
                double distanceX = Double.MAX_EXPONENT;
                double distanceY = Double.MAX_EXPONENT;
                //步骤一、将Y分两段
                for(int i = l; i<=r;i++){
                    if(Y[i].getP() > m){
                        Z[g++] = Y[i];
                    }else {
                        Z[f++] = Y[i];
                    }
                }
                //步骤二、递归求取两部分的最短距离
                double minDsitance1 = closet(X, Z, Y,a,b, l, m);

                double minDsitance2 = closet(X, Z, Y, ar,br,m+1, r);

                if(minDsitance1<minDsitance2){
                    minDistance = minDsitance1;
                }else {
                    minDistance = minDsitance2;
                    a.setX(ar.getX());
                    a.setY(ar.getY());
                    a.setP(ar.getP());
                    b.setX(br.getX());
                    b.setY(br.getY());
                    b.setP(br.getP());
                }

                //步骤三、重构数组Y
                divideAndConquer.Merge(Z,Y,l,m,r);

                //步骤四、求取区间S1,S2带比较候选者
                int k = l,e = r;
                for(int i = l; i<=r;i++){
                    distanceX = X[m].getX() - Y[i].getX();
                    if(0<=distanceX && distanceX < minDistance){
                        Z[k++] = Y[i];
                    }else if(distanceX < 0 && distanceX >-minDistance){
                        Z[e--] = Y[i];
                    }
                }

                //步骤五、求取两区间内的最接近点
                for(int i = l; i<k;i++){
                    for (int j = r;j>e;j--){
                        distanceY = Math.abs((Z[i].getY()-Z[j].getY()));
                        if(distanceY < minDistance){
                            distanceX = point.distance(Z[i],Z[j]);
                            if(minDistance > distanceX){
                                minDistance = distanceX;
                                a.setX(Z[i].getX());
                                a.setY(Z[i].getY());
                                a.setP(Z[i].getP());
                                b.setX(Z[j].getX());
                                b.setY(Z[j].getY());
                                b.setP(Z[j].getP());
                                logger.debug("点:"+X[Z[i].getP()].getID()+"与点:"+X[Z[j].getP()].getID()+"间的距离为:"+minDistance);
                            }

                        }
                    }
                }
            }
        }

        return minDistance;
    }


    /**
     * 克隆对象
     * @param obj
     * @return
     */
    public <T> T cloneObj(T obj){

        T object = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            object = (T) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return object;
    }
}
