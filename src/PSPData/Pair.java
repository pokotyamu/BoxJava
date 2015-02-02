/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PSPData;

/**
 *
 * @author pokotyamu
 */
public class Pair {
    private Object x;
    private Object y;
    private int submition_id;
    
    public Pair(Object x,Object y,int submition_id){
        this.x = x;
        this.y = y;
        this.submition_id = submition_id;
    }
    
    public Pair(Object x,Object y){
        this.x = x;
        this.y = y;
    }
    
    public Object getX(){
        return x;
    }
    
    public Object getY(){
        return y;
    }
    
    public int getSubmition_id(){
        return submition_id;
    }
    
    @Override
    public String toString(){
        return "["+x+","+y+"]";
    }

    public boolean matchX(Pair p) {
        if(x.equals(p.getX()))
            return true;
        else
            return false;
    }
    
}
