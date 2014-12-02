/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package box;

import sql.ProcessData;

/**
 *
 * @author pokotyamu
 */
public abstract class AbstractBox {
    
    public ProcessData actionBox(Object arg){
        switch(arg.getClass().getName()){
            case "java.lang.String":
                return getProcessData((String) arg);
        }
        return null;
    }
    public abstract ProcessData getProcessData(String whereString);
}
