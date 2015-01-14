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
public class MtoH extends AbstractFunctionBox{
    
    @Override
    protected UserData initUserData(UserData userdata){
        return new UserData(userdata.getKeyString(), userdata.getValueString()+"(h)");
    }
    
    @Override
    public Pair function(Pair p){
        double parseDouble = Double.parseDouble(p.getY().toString());
        return new Pair(p.getX(), parseDouble / 60.0);
    }
    
}
