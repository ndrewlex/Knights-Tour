/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knightstour;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Tour {
    public ArrayList<Population> listOfPopulation = new ArrayList<>();
    public Tour()
    {
        for(int i=0;i<5;i++)
        {
            listOfPopulation.add(new Population());
            System.out.println();
        }
    }
}
