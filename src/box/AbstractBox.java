/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package box;

import sqlbox.ProcessData;

/**
 *
 * @author pokotyamu
 */
public abstract class AbstractBox {
    
    public ProcessData actionBox(Object... args){
        switch(args[0].getClass().getName()){
            //加工プロセス要素が引数として渡された時の処理
            case "AbstractBox":
                return ((AbstractBox) args[0]).actionBox(args);
            //AbstractSQL
            //SQLの条件が引数として渡された時の処理
            case "java.lang.String":
                return getProcessData((String) args[0]);
            //AbstaractFunctionBox　
            //プロセスデータが引数として渡された時の処理
            case "sqlbox.ProcessData":
                //Listに再度キャストし直す※要検討
                ProcessData[] pds = new ProcessData[100];
                for(int index = 0; index < args.length; index++){
                    pds[index] = (ProcessData) args[index];
                }
                return function(pds);
        }
        return null;
    }

    public ProcessData function(ProcessData... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ProcessData getProcessData(String whereString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
