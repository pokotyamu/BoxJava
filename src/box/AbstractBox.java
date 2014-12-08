/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package box;

import sqlbox.AbstractSQLBox;
import sqlbox.ProcessData;

/**
 *
 * @author pokotyamu
 */
public abstract class AbstractBox {
    
    public ProcessData actionBox(String whereString){
        if(this instanceof AbstractSQLBox){
            return getProcessData(whereString);
        }else{
            return function(whereString);
        }
    }
    
    public ProcessData actionBox(ProcessData... pds){
        return function(pds);
    }

    public ProcessData function(ProcessData... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ProcessData getProcessData(String whereString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ProcessData function(String whereString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
