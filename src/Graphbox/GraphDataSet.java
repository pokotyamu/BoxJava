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
public class GraphDataSet {
    
    private ArrayList<SeriesData> xAsix;
    private ArrayList<SeriesData> yAsix;
    
    private String title;

    public GraphDataSet(){
        xAsix = new ArrayList();
        yAsix = new ArrayList();
    }
    
    public void addXasix(SeriesData sdata){
        xAsix.add(sdata);
    }
    
    public void addYasix(SeriesData sdata){
        yAsix.add(sdata);
    }
    
    public void debugPrint(){
        System.out.println("xasix");
        for (SeriesData x : xAsix) {
            x.debugPrint();
        }
        System.out.println("xasix");
        for (SeriesData y : yAsix) {
            y.debugPrint();
        }
    }
    
}
