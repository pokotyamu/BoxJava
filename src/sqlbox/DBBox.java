/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlbox;
import PSPData.DataSet;
import PSPData.UserData;
import java.sql.ResultSet;

/**
 *
 * @author kaori
 */
public class DBBox extends AbstractSQLBox{
    public DBBox(String keyString, String valueString)
    {
        super(keyString, valueString);
    }
    
    @Override
    public String createSQL (String whereString)
    {
        return "select * from ROOT.PSPASSGTDATA " + whereString;
       
    }
}
