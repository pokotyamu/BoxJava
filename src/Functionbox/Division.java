/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionbox;

import PSPData.Pair;
import PSPData.UserData;

/**
 *
 * @author pokotyamu
 */
public class Division extends AbstractFunctionBox{

    @Override
    protected UserData initUserData(UserData userdata1, UserData userdata2){
        return new UserData(userdata1.getKeyString(), userdata1.getValueString()+"/"+userdata2.getValueString());
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
