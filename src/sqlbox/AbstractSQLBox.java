/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlbox;

import PSPData.UserData;
import box.AbstractBox;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pokotyamu
 */
public abstract class AbstractSQLBox extends AbstractBox{
    private final String URL = "jdbc:derby://localhost:1527/PSP_for_E";
    private final String usr = "root";
    private final String pass = "root";
    
    private final String keyString;
    private final String valueString;
    private Connection conn;
    
    //SQL作成部分。
    //実装部でSQLが変わる
    public abstract String createSQL(String whereString);
    
    public AbstractSQLBox(String keyString,String valueString){
        this.keyString = keyString;
        this.valueString = valueString;
    }
    
    //DBへの接続
    private void connection(){
        try {
            this.conn = DriverManager.getConnection(URL, usr, pass);
        } catch (SQLException ex) {
            Logger.getLogger(AbstractSQLBox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //DBへの接続をクローズ
    private void close(){
        try {
            this.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AbstractSQLBox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //SQLの実行結果を取得
    private ResultSet getResultSet(String sql){
        ResultSet result = null;
        try {
            Statement stmt = this.conn.createStatement();
            result = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AbstractSQLBox.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    //接続〜クローズまでを一括して実行
    //最終的に、このメソッドが呼ばれる
    @Override
    public UserData getUserData(String whereString) {
        connection();
        ResultSet result = getResultSet(createSQL(whereString));
        UserData ps = new UserData(this.keyString,this.valueString,result);
        close();
        return ps;
    }
    
    // SUBMITION_ID が指定された時
    public UserData actionBox(String whereString, String submitionID){
        if(this instanceof AbstractSQLBox){
            return getUserData(whereString, submitionID);
        }else{
            return function(whereString);
        }
    }
    
    // SUBMITION_ID が指定された時
    public UserData getUserData(String whereString, String submitionID)
    {
        connection();
        ResultSet result = getResultSet(createSQL(whereString));
        UserData ps = new UserData(this.keyString,this.valueString,result,submitionID);
        close();
        return ps;
    }
}
