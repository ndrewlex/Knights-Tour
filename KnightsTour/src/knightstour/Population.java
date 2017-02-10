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
public final class Population {
    public int randomX,randomY,tempX,tempY;
    public ArrayList<Knight> arrKnight = new ArrayList<>();
    int counter=0;
    public Board b;
    public Knight k;
    public Population()
    {
        //Initial state
        b = new Board();
        randomX = ((int) (Math.random()*8+1))-1;
        randomY = ((int) (Math.random()*8+1))-1;
        tempX = randomX; tempY = randomY;
        Knight k = new Knight(tempX,tempY);
        b.knightToBoard(k);
        arrKnight.add(new Knight(tempX,tempY));
        //System.out.println(k.getX() + " " + k.getY());
        //b.displayBoard(k);
        //b.printKnightStatus();
        
        //Knights move with 64 step based on the board
        for(int i=0;i<63;i++)
        {
            k.setUpMoveStatus();
            if(moveAndChecking(k))
            {
                b.knightToBoard(k);
            }
            else
            {
                //System.out.println("GAME OVER");
                //System.out.println(k.getX() + "," + k.getY());
                break;
            }
            //System.out.println(k.getX() + " " + k.getY());
            //b.displayBoard(k);
            // b.printKnightStatus();
            //System.out.println();
            k.setUpMoveStatus();
            arrKnight.add(new Knight(tempX,tempY));
        }
        
        
        //Display board and info
        //System.out.println("FINAL");
        //System.out.println(k.getX() + "," + k.getY());
        b.displayBoard(k);
        printList();
        //k.printMoveStatus();
        System.out.println("\nTotal Fitness: " + b.countFitness());
        b.refresh();
    }
    
    public boolean moveAndChecking(Knight k)
    {
        //Check if the knight has correct pos and not double
        while(!k.isKnightPosCorrect(k) || (k.getX() == tempX && k.getY() == tempY))
        {
            if(k.isGameOver())
            {
                return false;
            }
            k.move();
            if(!k.isKnightPosCorrect(k) || b.isKnightHasDouble(k))
            {
                //System.out.println("Pos yang gagal " + k.getX() +"," + k.getY());
                //k.printMoveStatus();
                k.setPos(tempX, tempY);
            }
            else if(k.isKnightPosCorrect(k) && !b.isKnightHasDouble(k)){
                tempX = k.getX();
                tempY = k.getY();
                break;
            } 
        }
        return true;
    }
    
    public boolean isItOver()
    {
        if(counter==8)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void printList()
    {
        //Print the knights step, from 0 to 63 based on the board
        System.out.println("Encode list:");
        for(int i=0;i<arrKnight.size();i++)
        {
            System.out.print(arrKnight.get(i).getX() +"," +arrKnight.get(i).getY() + "  ");
        }
    }
}
