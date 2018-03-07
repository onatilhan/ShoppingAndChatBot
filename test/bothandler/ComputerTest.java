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
public class ComputerTest {
    
    public ComputerTest() {
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
     * Test of getProcessor method, of class Computer.
     */
    @Test
    public void testGetProcessor() {
        System.out.println("getProcessor");
        Computer instance = null;
        String expResult = "";
        String result = instance.getProcessor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProcessor method, of class Computer.
     */
    @Test
    public void testSetProcessor() {
        System.out.println("setProcessor");
        String processor = "";
        Computer instance = null;
        instance.setProcessor(processor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRAM method, of class Computer.
     */
    @Test
    public void testGetRAM() {
        System.out.println("getRAM");
        Computer instance = null;
        int expResult = 0;
        int result = instance.getRAM();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRAM method, of class Computer.
     */
    @Test
    public void testSetRAM() {
        System.out.println("setRAM");
        int ram = 0;
        Computer instance = null;
        instance.setRAM(ram);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOS method, of class Computer.
     */
    @Test
    public void testGetOS() {
        System.out.println("getOS");
        Computer instance = null;
        String expResult = "";
        String result = instance.getOS();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOS method, of class Computer.
     */
    @Test
    public void testSetOS() {
        System.out.println("setOS");
        String os = "";
        Computer instance = null;
        instance.setOS(os);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getgCard method, of class Computer.
     */
    @Test
    public void testGetgCard() {
        System.out.println("getgCard");
        Computer instance = null;
        String expResult = "";
        String result = instance.getgCard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setgCard method, of class Computer.
     */
    @Test
    public void testSetgCard() {
        System.out.println("setgCard");
        String gCard = "";
        Computer instance = null;
        instance.setgCard(gCard);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Computer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Computer instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
