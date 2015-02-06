/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphbox;

import java.util.ArrayList;

/**
 *
 * @author pokotyamu
 */
class SeriesData {
    private ArrayList<Object> data;
    private String name;
    private int st_id;
    private int class_ID;

    public SeriesData(String name, int st_id, int class_ID) {
        data = new ArrayList();
        this.name = name;
        this.st_id = st_id;
        this.class_ID = class_ID;
    }
    
    public void addData(Object o){
        data.add(o);
    }
    
    public String toData(){
        System.out.println(data);
        return "hoge";
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getSTID(){
        return this.st_id;
    }
    
    public int getClassID(){
        return this.class_ID;
    }
    
    public void debugPrint(){
        System.out.println(this.st_id+","+this.class_ID);
        System.out.println(this.data);
    }

}
