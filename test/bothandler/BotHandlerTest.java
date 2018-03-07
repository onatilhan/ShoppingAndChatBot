/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bothandler;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Z50
 */
public class BotHandlerTest {
    
    public BotHandlerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class BotHandler.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        BotHandler.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTweetWriteFile method, of class BotHandler.
     */
    @Test
    public void testGetTweetWriteFile() throws Exception {
        System.out.println("getTweetWriteFile");
        String pBrand = "";
        BotHandler.getTweetWriteFile(pBrand);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computeSentic method, of class BotHandler.
     */
    @Test
    public void testComputeSentic() {
        System.out.println("computeSentic");
        BotHandler.computeSentic();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readFile method, of class BotHandler.
     */
    @Test
    public void testReadFile() {
        System.out.println("readFile");
        String model = "";
        ArrayList<String> expResult = null;
        ArrayList<String> result = BotHandler.readFile(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashMap method, of class BotHandler.
     */
    @Test
    public void testHashMap() throws Exception {
        System.out.println("hashMap");
        BotHandler.hashMap();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
