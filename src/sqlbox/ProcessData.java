
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlbox;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pokotyamu
 */
public class ProcessData {
    
    List<Pair> pairs;

    private String keyString;
    private String valueString;

    //複数人のデータを対象にすることはまだ実装できていない
    //さらに上のくくりでまとめる必要がある
    public ProcessData(String keyString, String valueString, ResultSet result) {
        this.keyString = keyString;
        this.valueString = valueString;
        this.pairs = new ArrayList();
        try {
            while (result.next()) {
                pairs.add(new Pair(result.getObject(keyString),result.getObject(valueString)));
            }       
        } catch (SQLException ex) {
            Logger.getLogger(ProcessData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Pair> getPairs(){
        return this.pairs;
    }

    public String dataLabel(){
        return "["+this.keyString+","+this.valueString+"]";
    }
    
    public String getKeyString(){
        return this.keyString;
    }
    
    public String getValueString(){
        return this.keyString;
    }
    
}