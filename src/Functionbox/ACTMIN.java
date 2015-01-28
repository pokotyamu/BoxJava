
/*
* Example ACTMIN
*/
package Functionbox;

import PSPData.UserData;
import sqlbox.DBBox;

/**
 *
 * @author kaori
 */
public class ACTMIN extends AbstractFunctionBox{
    @Override
    public UserData function(String whereString){
        DBBox dbbox = new DBBox("PROJECTID", "ACTMIN");
        return dbbox.actionBox(whereString);
    }
}