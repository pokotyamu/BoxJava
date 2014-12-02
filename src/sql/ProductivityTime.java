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
public class ProductivityTime extends AbstractSQL{
    
    public ProductivityTime(String keyString, String valueString) {
        super(keyString, valueString);
    }

    @Override
    public String createSQL(String whereString) {
        System.out.println("select * from ROOT.PROJECTS" + whereString);
        return "select * from ROOT.PROJECTS" + whereString;
    }
    
}
