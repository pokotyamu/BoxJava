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
    int PROID = 399;
    
    
    @Override
    protected DataSet initDataSet(DataSet ds){
        return new DataSet(ds.getKeyString(), ds.getValueString()+"_max");
    }
    
    
    @Override
    protected DataSet function(DataSet ds){
        DataSet dataset = initDataSet(ds);
        UserData addedUserData = new UserData(dataset.getKeyString(), dataset.getValueString());
        
        // 決め打ち DataSet
        DataSet dummy_ds = new DataSet("PROJECTID", "dimmyACTMIN");
        int SUBMITION_ID = 1;
        for(int st_id = 1; st_id < 4; st_id++)
        {
            UserData dummy_ud = new UserData("PROJECTID", "dummyACTMIN", st_id, 201301);
            for(int pro_id = 400; pro_id < 403; pro_id++)
            {
                dummy_ud.addData( new Pair(pro_id, st_id, SUBMITION_ID) );
            }
            if(st_id == 3)
            {
                dummy_ud.addData(new Pair(403,st_id, SUBMITION_ID));
            }
            dummy_ds.addUserData(dummy_ud);
            dummy_ud.debugPrint();
        }
        ds = dummy_ds;
        
        
        // DataSet 内の UserData から最大演習課題番号を求める
        int max_pro_id = getMaxProjectID(ds);
               
        for(int index = 0; index < max_pro_id-PROID; index++)
        {
            Pair maxPair = new Pair("","");
            Pair tempPair = new Pair("","");
            for(int i = 0; i < ds.getUserDataSize(); i++)
            {
                // 演習課題ごとのユーザの値をみていく
                try{
                    if(maxPair.getX() == "")
                    {
                        maxPair = ds.getUserData(i).getPair(index);
                    }else if(maxPair.matchX( ds.getUserData(i).getPair(index) ))
                    {
                        tempPair = ds.getUserData(i).getPair(index);
                        if(Double.parseDouble(maxPair.getY().toString()) < Double.parseDouble(tempPair.getY().toString()))
                        {
                            maxPair = tempPair;
                        }
                    }
                }catch(java.lang.IndexOutOfBoundsException e){
                    System.out.println("ST_ID = " + (i+1) + " don't have " + (index+400) + " data");
                }                
            }
            addedUserData.addData(maxPair);
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
