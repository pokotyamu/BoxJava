/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package box;

import sqlbox.AbstractSQLBox;
import PSPData.UserData;

/**
 *
 * @author pokotyamu
 */
public abstract class AbstractBox {
    
    public UserData actionBox(String whereString){
        if(this instanceof AbstractSQLBox){
            return getProcessData(whereString);
        }else{
            return function(whereString);
        }
    }
    
    public UserData actionBox(UserData... pds){
        return function(pds);
    }

    public UserData function(UserData... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public UserData getProcessData(String whereString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public UserData function(String whereString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
