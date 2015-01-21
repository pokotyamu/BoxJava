/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionbox;

import PSPData.UserData;
import box.AbstractBox;
import sqlbox.*;

/**
 *
 * @author kaori
 */
public class Productivity_k extends AbstractFunctionBox{
    @Override
    public UserData function(String whereString)
    {
        AbstractBox actloc = new DBBox("PROJECTID", "ACTLOC");
        AbstractBox actmin = new DBBox("PROJECTID", "ACTMIN");
       
        AbstractBox mtoh = new MtoH();
        AbstractBox div = new Division();
        //return div.actionBox(actloc.actionBox(whereString), mtoh.actionBox(actmin.actionBox(whereString)));
        //return mtoh.actionBox(actmin.actionBox(whereString));
        return div.actionBox(actloc.actionBox(whereString),actmin.actionBox(whereString));
    }
}