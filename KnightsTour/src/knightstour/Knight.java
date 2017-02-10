/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knightstour;

/**
 *
 * @author User
 */
public class Knight {
    private boolean [] moveStatus = new boolean [8];
    private int x,y;
    private final char k;
    public Knight(int x, int y)
    {
        this.k = 'K';
        this.x = x;
        this.y = y;
        setUpMoveStatus();
    }
    
    public void setUpMoveStatus()
    {
        for(int i=0;i<moveStatus.length;i++)
        {
            moveStatus[i] = false;
        }
    }
    
    
    public char getChar()
    {
        return k;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    
    public void setY(int y)
    {
        this.y = y;
    }
    public void setPos(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public void move()
    {
        int rand = ((int) (Math.random()*8+1))-1;
        switch (rand)
        {
            case 0:
                this.y += 1;
                this.x += 2;
                moveStatus[rand] = true;
                break;
            case 1:
                this.y += 2;
                this.x += 1;
                moveStatus[rand] = true;
                break;
            case 2:
                this.y += 2;
                this.x -= 1;
                moveStatus[rand] = true;
                break;
            case 3:
                this.y += 1;
                this.x -= 2;
                moveStatus[rand] = true;
                break;
            case 4:
                this.y -= 1;
                this.x -= 2;
                moveStatus[rand] = true;
                break;
            case 5:
                this.y -= 2;
                this.x -= 1;
                moveStatus[rand] = true;
                break;
            case 6:
                this.y -= 2;
                this.x += 1;
                moveStatus[rand] = true;
                break;
            case 7:
                this.y -= 1;
                this.x += 2;
                moveStatus[rand] = true;
                break;
        }
    }
    
    public boolean isGameOver()
    {
        for(int i=0;i<moveStatus.length;i++)
        {
            if(moveStatus[i]==false)
            {
                return false;
            }
        }
        return true;
    }
    
    public void printMoveStatus()
    {
            System.out.println("MoveStatus: ");
        for(int i=0;i<moveStatus.length;i++)
        {
            System.out.print(moveStatus[i]+ " ");
        }
    }
    
    public boolean isKnightPosCorrect(Knight k)
    {
        //k.move();
        return !(k.getX()<0 || k.getX()>7 || k.getY()<0 || k.getY()>7);
    }
    
    
}
