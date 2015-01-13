/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionbox;

import sqlbox.Pair;
import sqlbox.UserData;

/**
 *
 * @author pokotyamu
 */
public class Division extends AbstractFunctionBox{

    @Override
    protected UserData initProcessData(UserData pd1, UserData pd2){
        return new UserData(pd1.getKeyString(), pd1.getValueString()+"/"+pd2.getValueString());
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
