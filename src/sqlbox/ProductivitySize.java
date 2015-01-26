/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlbox;


/**
 *
 * @author pokotyamu
 */
public class ProductivitySize extends AbstractSQLBox{

    public ProductivitySize(String keyString, String valueString) {
        super(keyString, valueString);
    }
    
    @Override
    public String createSQL(String whereString) {
        return "select * from ROOT.PROGRAMSIZE" + whereString;    
    }
    
    
}
