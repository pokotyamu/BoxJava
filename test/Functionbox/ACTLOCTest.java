/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionbox;

import PSPData.UserData;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sqlbox.DBBox;

/**
 *
 * @author kaori
 */
public class ACTLOCTest {
    
    public ACTLOCTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of function method, of class ACTLOC.
     */
    @Test
    public void testFunction() {
        System.out.println("function");
        String whereString = "ST_ID=1";
        ACTLOC instance = new ACTLOC();
        UserData expResult = DBBox.action("PROJECTID", "ACTLOC", whereString).getUserData(0);
        UserData result = instance.function(whereString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
