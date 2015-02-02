/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PSPData;

import java.util.ArrayList;

/**
 *
 * @author pokotyamu
 */
public class DataSet {
    
    private ArrayList<UserData> userdatas;
    private String keyString;
    private String valueString;
    
    public DataSet(String keyString,String valueString){
        this.userdatas = new ArrayList();
        this.keyString = keyString;
        this.valueString = valueString;
    }

    public void addUserData(UserData data){
        this.userdatas.add(data);
    }    
    
    public ArrayList<UserData> getUserDatas(){
        ArrayList<UserData> temp = new ArrayList();
        for(UserData userdata : userdatas){
            temp.add(userdata.clone());
        }
        return temp;        
    }
    
    public UserData getUserData(int index){
        return userdatas.get(index).clone();
    }
    public int getUserDataSize(){
        return userdatas.size();
    }

    public void setUserData(int index, UserData userdata) {
        userdatas.set(index, userdata);
    }
    
    public String getKeyString(){
        return keyString;
    }
    
    public void setKeyString(String keyString){
        this.keyString = keyString;
    }
    
    public void setValueString(String valueString){
        this.valueString = valueString;
    }
    
    public String getValueString(){
        return valueString;
    }

    public void debugPrint() {
        for(UserData ud : userdatas){
            System.out.println("ST_ID = " + ud.getST_ID());
            ud.debugPrint();
        }
    }
}
