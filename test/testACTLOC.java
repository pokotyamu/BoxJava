
import PSPData.DataSet;
import java.util.ArrayList;
import sqlbox.DBBox;

public class testACTLOC
{

    public static DataSet testACTLOC ()//(String xname, String yname, String sql, String charttype)
    {
        // 入力例
        String xname = "PROJECTID";
        String yname = "ACTLOC";
        String sql = "WHERE CLASS_ID=201301 AND ST_ID=1";
        
        DataSet ACTLOC = DBBox.action(xname, yname, sql);
        return ACTLOC;
        //ChartBlock.chart(loc,"LINE");
    }
}
/*

package sqlbox;
import PSPData.DataSet;
import PSPData.UserData;
import java.sql.ResultSet;

public class DBBox extends AbstractSQLBox{
    
    // 指定されたxyデータをとってくる
    public static DataSet action(String xname, String yname, String sql)
    {
        DataSet outputds = new DataSet(xname, yname);
        DBBox dbbox = new DBBox(xname, yname);
        outputds.addUserData(dbbox.getUserData(sql));
        return outputds;
    }
    
    
    public DBBox(String keyString, String valueString)
    {
        super(keyString, valueString);
    }
    
    @Override
    public String createSQL (String whereString)
    {
        return "select * from ROOT.PROJECTS " + whereString + "AND PROJECTID>=401" + "ORDER BY PROJECTID";
       
    }
}

*/