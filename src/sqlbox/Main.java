/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlbox;

import Functionbox.Division;
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

        System.out.println(ps1.dataLabel());
        System.out.println(ps1.getPairs());
        System.out.println(ps2.dataLabel());
        System.out.println(ps2.getPairs());
        AbstractBox div = new Division();
        div.actionBox(ps1,ps2);
    }
}
