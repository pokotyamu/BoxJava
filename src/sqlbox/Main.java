/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlbox;

import Functionbox.Division;
import Functionbox.MtoH;
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
        String whereString = " WHERE ST_ID=1";
        AbstractBox sql1 = new ProductivitySize("PROJECTID","ACTUALA");
        ProcessData ps1 = sql1.actionBox(whereString);
        AbstractBox sql2 = new ProductivityTime("PROJECTID", "MYAT");
        ProcessData ps2 = sql2.actionBox(whereString);
        AbstractBox mtoh = new MtoH();
        AbstractBox div = new Division();
        ProcessData pdpd = div.actionBox(sql1.actionBox(whereString), mtoh.actionBox(sql2.actionBox(whereString)));
        ProcessData pda = div.actionBox(ps1,ps2);
        ps1.debugPrint();
        ps2.debugPrint();
        mtoh.actionBox(sql2.actionBox(whereString)).debugPrint();
        pda.debugPrint();
    }
}
