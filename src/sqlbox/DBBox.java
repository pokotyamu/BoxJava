/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlbox;
import PSPData.DataSet;

/**
 *
 * @author kaori
 */
public class DBBox extends AbstractSQLBox{
    
    public static DataSet action(String xname, String yname, String sql)
    {
        DataSet Output = new DataSet();
        return Output;
    }
    
    
    public DBBox(String keyString, String valueString)
    {
        super(keyString, valueString);
    }
    
    @Override
    public String createSQL (String whereString)

    {
        return whereString;
       
    }
}
