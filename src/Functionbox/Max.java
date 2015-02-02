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
public class Max extends AbstractFunctionBox{
    
    @Override
    protected DataSet initDataSet(DataSet ds){
        return new DataSet(ds.getKeyString(), ds.getValueString()+"_max");
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
