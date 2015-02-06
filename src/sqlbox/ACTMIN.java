/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlbox;

import PSPData.DataSet;
import PSPData.Pair;
import PSPData.UserData;
import java.util.Random;


/**
 *
 * @author kaori
 */
public class ACTMIN extends AbstractSQLBox{
    
    public ACTMIN (String keyString, String valueString) {
        super(keyString, valueString);
    }

    @Override
    public String createSQL(String whereString) {        
        return "select * from ROOT.PSPASSGTDATA" + whereString;
    }
    
    
    @Override
    public DataSet getDataSet(String wheresString){
        DataSet dataset = new DataSet("PROJECTID", "ACTMIN");
        // 決め打ち DataSet
        DataSet ds = new DataSet("PROJECTID", "ACTMIN");
        int SUBMITION_ID = 1;
        Random r = new Random();
        for (int st_id = 1; st_id < 4; st_id++) {
            UserData ud = new UserData("PROJECTID", "ACTMIN", st_id, 201301);
            for(int pro_id = 400; pro_id < 408; pro_id++){
                ud.addData(new Pair(pro_id,100+r.nextInt(100),SUBMITION_ID));
            }
            ds.addUserData(ud);
        }
        ds.debugPrint();
        return ds;
    }
}