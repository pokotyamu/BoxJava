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
            boolean flg = true;
            Pair tempPair = null;
            for(UserData ud : ds.getUserDatas())
            {
                if(flg)
                {
                    tempPair = ud.getPair(index);
                    flg = false;
                }else if((double)tempPair.getY() < (double)ud.getPair(index).getY())
                {
                    tempPair = ud.getPair(index);
                }
            }
            addedUserData.addData(tempPair);
        }
        dataset.addUserData(addedUserData);
        return dataset;
    }
    
    @Override
    protected Pair function(Pair p1,Pair p2){
        if (Double.valueOf((String) p1.getY()) > Double.valueOf((String) p2.getY())){
            return p1;
        }else{
            return p2;
        }
    }
}
