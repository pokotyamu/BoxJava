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
        String whereString = " WHERE ST_ID=1 AND SUBMITION_ID=1 ORDER BY PROJECTID ASC, SUBMITION_ID ASC";
        
        AbstractBox sql1 = new ProductivitySize("PROJECTID","ACTUALA");
        AbstractBox sql2 = new ProductivityTime("PROJECTID", "MYAT");
        AbstractBox mtoh = new MtoH();
        AbstractBox div = new Division();
        UserData userdata = div.actionBox(sql1.actionBox(whereString), mtoh.actionBox(sql2.actionBox(whereString)));
         
        AbstractBox productivity = new Productivity();
        UserData pro = productivity.actionBox(whereString);
        
        DBBox sql3 = new DBBox("PROJECTID","ACTMIN");
        userdata = sql3.action("PROJECTID","ACTMIN",whereString).getUserData(0);
        
        div.actionBox(productivity.actionBox(whereString),userdata);
        userdata.debugPrint();
        pro.debugPrint();
    }
}
