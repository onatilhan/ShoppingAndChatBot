/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bothandler;

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
public class MouseTest {
    
    public MouseTest() {
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
     * Test of setDpi method, of class Mouse.
     */
    @Test
    public void testSetDpi() {
        System.out.println("setDpi");
        int dpi = 0;
        Mouse instance = null;
        instance.setDpi(dpi);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDpi method, of class Mouse.
     */
    @Test
    public void testGetDpi() {
        System.out.println("getDpi");
        Mouse instance = null;
        int expResult = 0;
        int result = instance.getDpi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColourStr method, of class Mouse.
     */
    @Test
    public void testGetColourStr() {
        System.out.println("getColourStr");
        Mouse instance = null;
        String expResult = "";
        String result = instance.getColourStr();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColorStr method, of class Mouse.
     */
    @Test
    public void testSetColorStr() {
        System.out.println("setColorStr");
        String colourStr = "";
        Mouse instance = null;
        instance.setColorStr(colourStr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConnectivity method, of class Mouse.
     */
    @Test
    public void testGetConnectivity() {
        System.out.println("getConnectivity");
        Mouse instance = null;
        String expResult = "";
        String result = instance.getConnectivity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConnectiviy method, of class Mouse.
     */
    @Test
    public void testSetConnectiviy() {
        System.out.println("setConnectiviy");
        String connectivity = "";
        Mouse instance = null;
        instance.setConnectiviy(connectivity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWeight method, of class Mouse.
     */
    @Test
    public void testSetWeight() {
        System.out.println("setWeight");
        String weight = "";
        Mouse instance = null;
        instance.setWeight(weight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeight method, of class Mouse.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        Mouse instance = null;
        String expResult = "";
        String result = instance.getWeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Mouse.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Mouse instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
