/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionbox;

import PSPData.DataSet;
import box.AbstractBox;
import PSPData.Pair;
import PSPData.UserData;

/**
 *
 * @author pokotyamu
 */
public abstract class AbstractFunctionBox extends AbstractBox{

    @Override
    public DataSet function(DataSet... args) {
        if(args.length > 1)
            return function(args[0],args[1]);
        else
            return function(args[0]);
    }
    
    protected DataSet function(DataSet ds){
        DataSet dataset = initDataSet(ds);
        for(UserData ud : ds.getUserDatas()){
            UserData addedUserData = new UserData(dataset.getKeyString(), dataset.getValueString());
            Pair temppPair;
            for(int index=0;index < ud.getSize();index++){
                temppPair = ud.getPair(index);
                addedUserData.addData(function(temppPair));
            }
            dataset.addUserData(addedUserData);
        }
        return dataset;
    }

    protected DataSet function(DataSet ds1,DataSet ds2){
        DataSet dataset = initDataSet(ds1, ds2);
        for(int i = 0; i < ds1.getUserDataSize(); i++){
            UserData addedUserData = new UserData(dataset.getKeyString(), dataset.getValueString());
            UserData ud1 = ds1.getUserData(i);
            UserData ud2 = ds2.getUserData(i);
            Pair tempud1p;
            Pair tempud2p;
            for(int index=0;index < ud1.getSize();index++){
                tempud1p = ud1.getPair(index);
                tempud2p = ud2.getPair(index);
                //マッチングｙ同士のものについては要検討
                if(tempud1p.matchX(tempud2p)){
                    addedUserData.addData(function(tempud1p,tempud2p));
                }
            }
            dataset.addUserData(addedUserData);
        }
        return dataset;
    }        
    
    @Override
    public DataSet function(String whereString){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected Pair function(Pair p1,Pair p2){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected Pair function(Pair p){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected DataSet initDataSet(DataSet ds1, DataSet ds2){
        return new DataSet("", "");
    }

    protected DataSet initDataSet(DataSet ds) {
        return new DataSet("", "");
    }

}
