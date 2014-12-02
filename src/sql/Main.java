/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

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
        
        AbstractSQL sql1 = new ProductivitySize("PROJECTID","ACTUALA");
        ProcessData ps1 = sql1.getProcessData(whereString);

        AbstractSQL sql2 = new ProductivityTime("PROJECTID", "MYAT");
        ProcessData ps2 = sql2.getProcessData(whereString);
      
        System.out.println(ps1.dataLabel());
        System.out.println(ps1.getPairs());
        System.out.println(ps2.dataLabel());
        System.out.println(ps2.getPairs());
    }
}
