package com.sxt.test;

import com.sxt.divide.CheckerBoard;
import org.junit.Test;

public class TestCheckerBoard {

    @Test
    public void testCheckerBoard(){
        Integer a = 4;
        //a = a<<2;
        System.out.println(a);
        CheckerBoard board = new CheckerBoard(a);
        board.getBoard()[0][1] = -1;
        board.ChessBoard(0,0,0,1,board.getSize());
        board.displayBoard();
    }
}
