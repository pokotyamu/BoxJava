/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionbox;

import PSPData.DataSet;
import PSPData.Pair;

/**
 *
 * @author pokotyamu
 */
public class Division extends AbstractFunctionBox{

    @Override
    protected DataSet initDataSet(DataSet ds1, DataSet ds2){
        return new DataSet(ds1.getKeyString(), ds1.getValueString()+"/"+ds2.getValueString());
    }
    
    @Override
    protected Pair function(Pair p1,Pair p2){
        try{
            if((int)p2.getY() == 0){
                return new Pair(p1.getX(),0.0);
            }else{
                return new Pair(p1.getX(),((double)p1.getY()/(int)p2.getY()));
            }
        }catch(ClassCastException cce){
            if((double)p2.getY() == 0.0){
                return new Pair(p1.getX(),0.0);
            }else{
                return new Pair(p1.getX(),((double)p1.getY()/(double)p2.getY()));
            }
        }
    }
}
