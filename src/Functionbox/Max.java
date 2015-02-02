/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionbox;

import PSPData.DataSet;
import PSPData.Pair;
import PSPData.UserData;

/**
 *
 * @author pokotyamu
 */
public class Max extends AbstractFunctionBox{
    
    @Override
    protected DataSet initDataSet(DataSet ds){
        return new DataSet(ds.getKeyString(), ds.getValueString()+"_max");
    }
    
    
    @Override
    protected DataSet function(DataSet ds){
        DataSet dataset = initDataSet(ds);
        UserData addedUserData = new UserData(dataset.getKeyString(), dataset.getValueString());
        System.out.println("UserData Size = " + ds.getUserData(0).getSize());
        for(int index = 0; index < 8; index++)//ds.getUserData(0).getSize(); index++ )
        {          
            //System.out.println("index = " + index);
            Pair tempPair = ds.getUserData(0).getPair(index);
            for(int i = 1; i < ds.getUserDataSize(); i++)
            {
                if(tempPair.matchX(ds.getUserData(i).getPair(index)) 
                        && Double.parseDouble(tempPair.getY().toString()) < Double.parseDouble(ds.getUserData(i).getPair(index).getY().toString()))
                {
                    tempPair = ds.getUserData(i).getPair(index);
                }
            }
            addedUserData.addData(tempPair);
        }
        dataset.addUserData(addedUserData);
        return dataset;
    }
    
}
