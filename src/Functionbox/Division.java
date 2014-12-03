/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionbox;

import sqlbox.ProcessData;

/**
 *
 * @author pokotyamu
 */
public class Division extends AbstractFunctionBox{

    @Override
    protected ProcessData function(ProcessData ps1, ProcessData ps2) {
        System.out.println("====Division=====");
        
        System.out.println(ps1.getPairs());
        System.out.println(ps2.getPairs());
        
        return null;
        
        
    }
}
