
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