
import PSPData.DataSet;
import PSPData.UserData;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kaori
 */
public class runTest {
    public void main(String[] args)
    {
        System.out.println("Test runTest!");
        //UserData userdata = testACTLOC.testACTLOC().getUserData(0);
        //userdata.debugPrint();
        //PrintDataSet(testACTLOC.testACTLOC());
    }
    
    // DataSet の中身を確認する
    public void PrintDataSet(DataSet Data)
    {
        System.out.println("I just want to PrintOut DataSet!");
        
        //System.out.print(Data.getUserData(0).getPairs());
        
        /*
        for(int i = 0; i < Data.getUserDataSize(); i++)
        {
            DataSet Obj = new DataSet("PROJECTID", "ACTLOC");
            System.out.println(DataSet.getUserData(i));
        
        }
        */
    }
}
