/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphbox;

import PSPData.DataSet;
import PSPData.Pair;
import PSPData.UserData;

/**
 *
 * @author pokotyamu
 */
public class SeriesParser extends AbstractDataSetParser{

    @Override
    public GraphDataSet parse(DataSet ds) {
        GraphDataSet parsedDataSet = new GraphDataSet();
        UserData u = ds.getUserData(0);
        SeriesData xasix = new SeriesData(u.getKeyString(), u.getST_ID(), u.getClass_ID());

        for (Pair p : u.getPairs()) {
            xasix.addData(p.getX());
        }
        parsedDataSet.addXasix(xasix);

        
        for (UserData ud : ds.getUserDatas()) {
            SeriesData yasix = new SeriesData(ud.getKeyString(), ud.getST_ID(),ud.getClass_ID());
            for (Pair p : ud.getPairs()) {
                yasix.addData(p.getY());
            }
            parsedDataSet.addYasix(yasix);
        }
        return parsedDataSet;
    }
    
    
}
