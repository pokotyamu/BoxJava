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
        
        // DataSet 内の UserData から最大演習課題番号を求める
        int max_size = ds.getUserData(0).getSize();
        int max_pro_num = Integer.parseInt(ds.getUserData(0).getPair(max_size - 1).getX().toString());
        System.out.println("UserData(0) Max Pro Num = " + max_pro_num);
        for(int i = 1; i < ds.getUserDataSize(); i++)
        {
            // 各 UserData の最後の演習課題の番号を取得
            max_size = ds.getUserData(i).getSize();
            int temp = Integer.parseInt(ds.getUserData(i).getPair(max_size - 1).getX().toString());
            if(max_pro_num < temp)
            {
                max_pro_num = temp;
            }
        }
        System.out.println("Max Pro Num = " + max_pro_num);
                
        
        for(int index = 0; index < max_pro_num-400+1; index++)
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
