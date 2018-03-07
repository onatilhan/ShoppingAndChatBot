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
public class ProductTweetsTest {
    
    public ProductTweetsTest() {
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
     * Test of setList method, of class ProductTweets.
     */
    @Test
    public void testSetList() {
        System.out.println("setList");
        ArrayList<String> myList = null;
        ProductTweets instance = null;
        instance.setList(myList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComments method, of class ProductTweets.
     */
    @Test
    public void testGetComments() {
        System.out.println("getComments");
        ProductTweets instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getComments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHashtag method, of class ProductTweets.
     */
    @Test
    public void testGetHashtag() {
        System.out.println("getHashtag");
        ProductTweets instance = null;
        String expResult = "";
        String result = instance.getHashtag();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPolarity method, of class ProductTweets.
     */
    @Test
    public void testSetPolarity() {
        System.out.println("setPolarity");
        ProductTweets instance = null;
        instance.setPolarity();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sentic method, of class ProductTweets.
     */
    @Test
    public void testSentic() {
        System.out.println("sentic");
        ProductTweets instance = null;
        instance.sentic();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class ProductTweets.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        ProductTweets instance = null;
        instance.print();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class ProductTweets.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        ProductTweets other = null;
        ProductTweets instance = null;
        int expResult = 0;
        int result = instance.compareTo(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ProductTweets.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ProductTweets instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
