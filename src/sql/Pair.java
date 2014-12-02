/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

/**
 *
 * @author pokotyamu
 */
public class Pair {
    private Object x;
    private Object y;
    
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
    
    @Override
    public String toString(){
        return "["+x+","+y+"]";
    }
    
}
