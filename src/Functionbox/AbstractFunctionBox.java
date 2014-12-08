/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionbox;

import box.AbstractBox;
import sqlbox.Pair;
import sqlbox.ProcessData;

/**
 *
 * @author pokotyamu
 */
public abstract class AbstractFunctionBox extends AbstractBox{

    @Override
    public ProcessData function(ProcessData... args) {
        if(args.length > 1)            
            return function(args[0],args[1]);
        else
            return function(args[0]);
    }
    
    protected ProcessData function(ProcessData ps){
        ProcessData pd = initProcessData(ps);
        Pair temppPair;
        for(int index=0;index < ps.getSize();index++){
            temppPair = ps.getPair(index);
            pd.addData(function(temppPair));
        }
        return pd;
    }

    protected ProcessData function(ProcessData ps1,ProcessData ps2){
        ProcessData pd = initProcessData(ps1,ps2);
        Pair tempps1p;
        Pair tempps2p;
        for(int index=0;index < ps1.getSize();index++){
            tempps1p = ps1.getPair(index);
            tempps2p = ps2.getPair(index);
            //マッチングｙ同士のものについては要検討
            if(tempps1p.matchX(tempps2p)){                
                pd.addData(function(tempps1p,tempps2p));
            }
        }
        return pd;
    }
    
    @Override
    public ProcessData function(String whereString){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected Pair function(Pair p1,Pair p2){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected Pair function(Pair p){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    protected ProcessData initProcessData(ProcessData ps1, ProcessData ps2){
        return new ProcessData("", "");
    }

    protected ProcessData initProcessData(ProcessData ps) {
        return new ProcessData("", "");
    }

}
