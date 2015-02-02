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
        for(int index = 0; index < dataset.getUserData(0).getSize(); index++ )
        {            
            Pair tempPair = dataset.getUserData(0).getPair(0);
            for(int i = 1; i < dataset.getUserDataSize(); i++)
            {
                if(tempPair.matchX(dataset.getUserData(i).getPair(index)) && (double)tempPair.getY() < (double)dataset.getUserData(i).getPair(index).getY())
                {
                    tempPair = dataset.getUserData(i).getPair(index);
                }
            }
            addedUserData.addData(tempPair);
        }
        dataset.addUserData(addedUserData);
        return dataset;
    }
    
}
