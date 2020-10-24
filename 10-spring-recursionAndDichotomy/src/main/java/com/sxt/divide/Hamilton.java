package com.sxt.divide;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

/**
 * 马的Hamilton周游路线问题
 */
public class Hamilton {

    private Logger logger = Logger.getLogger(Hamilton.class);

    //棋盘大小(m行)
    private Integer m;

    //棋盘大小(n列)
    private Integer n;

    //考虑到马有8种走法
    private Integer[] dx={-2,-1,1,2,-2,-1,2,1};
    private Integer[] dy={-1,-2,-2,-1,1,2,1,2};
    //放置棋盘
    private Integer[][] board;

    public Integer[][] getBoard() {
        return board;
    }

    public void setBoard(Integer[][] board) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
    }

    //判断下一步是否是起始的位置
    public boolean  next_move(int x,int y){
        boolean flag = false;
        if (board != null){
            for(int i = 0; i< dx.length;i++){
                if(judge(x+dx[i],y+dy[i],m,n)&&board[x+dx[i]][y+dy[i]] == 1){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    //判断是否填了
    public boolean finish(int x,int y){
        boolean flag = false;
        if (board != null){
            if (board[x][y] == 0){
                flag = true;
            }
        }
        return flag;
    }

    //马的下一步走法已经超出棋盘的范围了
    public boolean judge(int x,int y,int m,int n){
        boolean flag = false;
        if ( x>=0 && x<m && y>=0 && y<n){
            flag = true;
        }
        return flag;
    }

    //马走的函数
    public void move(int x,int y,int num) throws IOException {
        //1、判断是否走完
        if(num == (m*n+1) && next_move(x,y)){
            File file = new File("G:\\html\\test\\upload\\hamilton.txt");
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i< board.length;i++){
                sb.append(StringUtils.join(board[i],"\t"));
                sb.append("\n");
            }
            FileUtils.writeStringToFile(file,sb.toString(),false);
        }else {
            //尝试走位
            for(int i = 0;i<8;i++){
                if(judge(x+dx[i],y+dy[i],m,n)&&finish(x+dx[i],y+dy[i])){//若不符合上述条件就表示马放弃之后会走这一步了
                    board[x+dx[i]][y+dy[i]]=num;//在棋盘上记录马的步数
                    logger.debug("此时num的值为:"+num);
                    if(num > 21 ){
                        System.out.println();
                    }
                    move(x+dx[i],y+dy[i],num+1);
                    //当遍历完棋盘后将棋盘重新置为0(表示马为走过)
                    board[x+dx[i]][y+dy[i]]= 0;
                }
            }

        }
    }
}
