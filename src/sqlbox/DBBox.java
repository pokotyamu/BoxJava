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
    
    // 指定されたxyデータをとってくる
    public static DataSet action(String xname, String yname, String sql)
    {
        DataSet Output = new DataSet(xname, yname);
        Output.addUserData(getUserData(sql));
        return Output;
    }
    
    
    public DBBox(String keyString, String valueString)
    {
        super(keyString, valueString);
    }
    
    @Override
    public String createSQL (String whereString)
    {
        return "select * from ROOT.PSPASSGTDATA" + whereString;
       
    }
 
    @Override
    public UserData getUserData(String whereString)
    {
        connection();
        ResultSet result = getResultSet(createSQL,(whereStriing));
        UserData ps = new UserData(this.keyString, this.valueString, result);
        close();
        return ps;
    }
}
