/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlbox;

import Functionbox.*;
import PSPData.UserData;
import Functionbox.Division;
import Functionbox.MtoH;
import Functionbox.Productivity;
import box.AbstractBox;

/**
 *
 * @author pokotyamu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String whereString = " WHERE ST_ID=1 ";
        
        AbstractBox sql1 = new ProductivitySize("PROJECTID","ACTUALA");
        AbstractBox sql2 = new ProductivityTime("PROJECTID", "MYAT");
        AbstractBox mtoh = new MtoH();
        AbstractBox div = new Division();
        UserData userdata = div.actionBox(sql1.actionBox(whereString), mtoh.actionBox(sql2.actionBox(whereString)));
         
        AbstractBox productivity = new Productivity();
        UserData pro = productivity.actionBox(whereString);
        
        //userdata = DBBox.action("PROJECTID", "ACTLOC", whereString).getUserData(0);
        //AbstractBox productivity_k = new Productivity_k();
        //userdata = productivity_k.actionBox(whereString);
        
        div.actionBox(productivity.actionBox(whereString),userdata);
        userdata.debugPrint();
        pro.debugPrint();
    }
}
