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
public class SpecialMeanTest {
    
    public SpecialMeanTest() {
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
     * Test of computePolarity method, of class SpecialMean.
     */
    @Test
    public void testComputePolarity() {
        System.out.println("computePolarity");
        double polarity = 0.0;
        ArrayList<String> comments = null;
        SpecialMean instance = new SpecialMean();
        double expResult = 0.0;
        double result = instance.computePolarity(polarity, comments);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
