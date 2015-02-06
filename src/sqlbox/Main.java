/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlbox;


import Functionbox.Max;
import PSPData.DataSet;
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
        String whereString = " WHERE CLASS_ID=201301 AND SUBMITION_ID=1 ORDER BY ST_ID ASC,PROJECTID ASC, SUBMITION_ID ASC";
        AbstractBox actmin = new ACTMIN("PROJECTID", "ACTMIN");
        AbstractBox max = new Max();
        max.actionBox(actmin.actionBox(whereString)).debugPrint();
       


    }
}
