/*
* Example ACTLOC
*/
package Functionbox;

import box.AbstractBox;
import PSPData.UserData;
import sqlbox.DBBox;

/**
 *
 * @author kaori
 */
public class ACTLOC extends AbstractFunctionBox{
    @Override
    public UserData function(String whereString){
        DBBox dbbox = new DBBox("PROJECTID", "ACTLOC");
        return dbbox.actionBox(whereString);
    }
}