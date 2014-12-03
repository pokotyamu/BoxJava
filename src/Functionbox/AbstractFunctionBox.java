/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionbox;

import box.AbstractBox;
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
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    protected ProcessData function(ProcessData ps1,ProcessData ps2){
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
