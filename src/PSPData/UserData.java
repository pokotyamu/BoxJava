
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PSPData;

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
public class UserData {
    
    List<Pair> pairs;

    private String keyString;
    private String valueString;

    //複数人のデータを対象にすることはまだ実装できていない
    //さらに上のくくりでまとめる必要がある
    public UserData(String keyString, String valueString, ResultSet result) {
        this.keyString = keyString;
        this.valueString = valueString;
        this.pairs = new ArrayList();
        try {
            while (result.next()) {
                pairs.add(new Pair(result.getObject(keyString),result.getObject(valueString)));
            }       
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public UserData(String keyString,String valueString){
        this.keyString = keyString;
        this.valueString = valueString;
        this.pairs = new ArrayList();
    }
    
    public List<Pair> getPairs(){
        return this.pairs;
    }
    
    public Pair getPair(int index){
        return this.pairs.get(index);
    }

    public int getSize(){
        return this.pairs.size();
    }
    
    public String dataLabel(){
        return "["+this.keyString+","+this.valueString+"]";
    }
    
    public String getKeyString(){
        return this.keyString;
    }
    
    public String getValueString(){
        return this.valueString;
    }

    public void addData(Pair addedPair) {
        this.pairs.add(addedPair);
    }
    
    public void debugPrint(){
        System.out.println(dataLabel());
        System.out.println(getPairs());
    }
    
    @Override
    public UserData clone(){
        UserData userdata = new UserData(keyString, valueString);
        for(Pair p : this.pairs){
            userdata.addData(p);
        }
        return userdata;
    }
}
