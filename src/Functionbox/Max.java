/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionbox;

import PSPData.DataSet;
import PSPData.Pair;
import PSPData.UserData;
import java.io.IOException;

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
        
        // DataSet 内の UserData から最大演習課題番号を求める
        int max_pro_id = getMaxProjectID(ds);
               
        Pair maxPair = new Pair(400,0);
        Pair tempPair = new Pair(400,0);
        for(int index = 0; index < max_pro_id-400+1; index++)
        {
            for(int i = 0; i < ds.getUserDataSize(); i++)
            {
                try{
                    tempPair = ds.getUserData(i).getPair(index);
                }catch(ArithmeticException e){
                    System.out.println("ST_ID = " + (i+1) + " don't have " + (index+400) + " data");
                }
                
                if(maxPair.matchX(tempPair) 
                        && Double.parseDouble(maxPair.getY().toString()) < Double.parseDouble(tempPair.getY().toString()))
                {
                    tempPair = ds.getUserData(i).getPair(index);
                }
                
            }
            addedUserData.addData(tempPair);
        }
        dataset.addUserData(addedUserData);
        return dataset;
    }
    
    // DataSet 内の UserData から最大演習課題番号を求める
    int getMaxProjectID(DataSet ds)
    {
        int max_size = ds.getUserData(0).getSize();
        int max_pro_id = Integer.parseInt(ds.getUserData(0).getPair(max_size - 1).getX().toString());
        System.out.println("UserData(0) Max Pro Num = " + max_pro_id);
        for(int i = 1; i < ds.getUserDataSize(); i++)
        {
            // 各 UserData の最後の演習課題の番号を取得
            max_size = ds.getUserData(i).getSize();
            int temp = Integer.parseInt(ds.getUserData(i).getPair(max_size - 1).getX().toString());
            if(max_pro_id < temp)
            {
                max_pro_id = temp;
            }
        }
        System.out.println("Max Pro Num = " + max_pro_id);
        return max_pro_id;
    }
}
