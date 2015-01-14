
import PSPData.DataSet;
import java.util.ArrayList;

public class testACTLOC
{

    public static void main (String xname, String yname, String sql, String charttype)
    {
        DataSet loc = DBBox.acion(xname, yname, sql);
        //ChartBlock.chart(loc,"LINE");
    }
}