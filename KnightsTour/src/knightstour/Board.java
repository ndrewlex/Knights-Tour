/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knightstour;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author User
 */
public class Board {
    public char [][] board = new char[8][8];
    public boolean[][] boardStatus = new boolean[8][8];
    public static final char EMPTY_BOARD = 'o';
    public  int totalFitness = 0;
    //public static int totalKnight = 0;
    public Board()
    {
        for (char[] board1 : board) {
            for (int j = 0; j<board[0].length; j++) {
                board1[j] = EMPTY_BOARD;
            }
        }
        
        for (boolean[] boardStatu : boardStatus) {
            for (int j = 0; j<boardStatus[0].length; j++) {
                boardStatu[j] = false;
            }
        }
    }
    
    public void displayBoard(Knight k)
    {
        //knightToBoard(k);
        for (char[] board1 : board) {
            for (int j = 0; j<board[0].length; j++) {
                System.out.print(board1[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void knightToBoard(Knight k)
    {
        board[k.getX()][k.getY()] = k.getChar();
        boardStatus[k.getX()][k.getY()] = true;
    }
    
    public boolean isKnightHasDouble(Knight k)
    {
        if(boardStatus[k.getX()][k.getY()]==false)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public void printKnightStatus()
    {
        System.out.println("Table board status : ");
        for(int i=0;i<boardStatus.length;i++)
        {
            for(int j=0;j<boardStatus[0].length;j++)
            {
                System.out.print(boardStatus[i][j]+ "   ");
            }
            System.out.println();
        }
    }
    
    public boolean isKnightPosCorrect(Knight k)
    {
        //k.move();
        return !(k.getX()<0 || k.getX()>(board.length-1) || k.getY()<0 || k.getY()>(board.length-1));
    }
    
    public int countFitness()
    {
        for (boolean[] boardStatu : boardStatus) {
            for (int j = 0; j<boardStatus[0].length; j++) {
                if (boardStatu[j] == true) {
                    totalFitness+=1;
                }
            }
        }
        return totalFitness;
    }
    
    public void refresh()
    {
        Arrays.fill(boardStatus, null);
    }
    
}
