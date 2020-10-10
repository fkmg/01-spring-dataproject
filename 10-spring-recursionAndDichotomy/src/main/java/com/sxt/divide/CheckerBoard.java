package com.sxt.divide;

/**
 * 棋盘覆盖
 */
public class CheckerBoard {
    //第tile个骨牌
    private Integer tile = 0;

    //棋牌
    private Integer[][] Board;

    private Integer size;

    public CheckerBoard(Integer size) {
        this.tile = 0;
        Board = new Integer[size][size];
        this.size = size;
    }

    public Integer getTile() {
        return tile;
    }

    public void setTile(Integer tile) {
        this.tile = tile;
    }

    public Integer[][] getBoard() {
        return Board;
    }

    public void setBoard(Integer[][] board) {
        Board = board;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * 覆盖棋盘问题
     * @param tr 棋盘左上角行号
     * @param tc 棋盘左上角列号
     * @param dr 特殊单元格行号
     * @param dc 特殊单元格列号
     * @param size 尺寸 2^k
     */
    public void ChessBoard(int tr,int tc,int dr,int dc,int size){
        //一、判断尺寸是否等于1
        if(size == 1){
            return;
        }
        //二、当尺寸不为1时放置第tile个骨牌
        int t = tile++;
        //1、求出尺寸的一半
        int s = size/2;
        //三、判断特殊单元格位置

        //左上角
        //特殊单元格在左上角
        if(tr+s>dr && tc+s> dc){
            //放置其它的骨牌
            ChessBoard(tr,tc,dr,dc,s);
        }else {
            //将t号骨牌放置右下角
            Board[tr+s-1][tc+s-1] = t;
            //放置其它单元格
            ChessBoard(tr,tc,tr+s-1,tc+s-1,s);
        }

        //右上角
        //特殊单元格在左上角
        if(tr+s>dr && tc+s<= dc){
            //放置其它的骨牌
            ChessBoard(tr,tc+s,dr,dc,s);
        }else {
            //将t号骨牌放置左下角
            Board[tr+s-1][tc+s] = t;
            //放置其它单元格
            ChessBoard(tr,tc+s,tr+s-1,tc+s,s);
        }

        //左下角
        //特殊单元格在左下角
        if(tr+s<=dr && tc+s> dc){
            //放置其它的骨牌
            ChessBoard(tr+s,tc,dr,dc,s);
        }else {
            //将t号骨牌放置右上角
            Board[tr+s][tc+s-1] = t;
            //放置其它单元格
            ChessBoard(tr+s,tc,tr+s,tc+s-1,s);
        }

        //右下角
        //特殊单元格在右下角
        if(tr+s<=dr && tc+s<= dc){
            //放置其它的骨牌
            ChessBoard(tr+s,tc+s,dr,dc,s);
        }else {
            //将t号骨牌放置左上角
            Board[tr+s][tc+s] = t;
            //放置其它单元格
            ChessBoard(tr+s,tc+s,tr+s,tc+s,s);
        }

    }

    /**
     * 展示棋盘
     */
    public void displayBoard(){
        for(int i = 0; i< Board.length;i++){
            for (int j = 0;j<Board[i].length;j++){
                System.out.print(Board[i][j]+"\t");
            }
            //换行
            System.out.println();
        }
    }
}
