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
    private String xname;
    private String yname;
    
    public DataSet(String xname,String yname){
        this.userdatas = new ArrayList();
        this.xname = xname;
        this.yname = yname;
    }

    public void addProcessData(UserData data){
        this.userdatas.add(data);
    }    
    
    public ArrayList<UserData> getUserDatas(){
        ArrayList<UserData> temp = new ArrayList();
        for(UserData userdata : userdatas){
            temp.add(userdata);
        }
        return temp;        
    }
    
    public UserData getProcessData(int index){
        return userdatas.get(index).clone();
    }
    public int getUserDataSize(){
        return userdatas.size();
    }

    public void setUserData(int index, UserData userdata) {
        userdatas.set(index, userdata);
    }
    
    public String getXname(){
        return xname;
    }
    
    public void setXname(String xname){
        this.xname = xname;
    }
    
    public void setYname(String yname){
        this.yname = yname;
    }
    
    public String getYname(){
        return yname;
    }
    
    
}
