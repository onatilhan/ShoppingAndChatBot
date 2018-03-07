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
public class ProductFactoryTest {
    
    public ProductFactoryTest() {
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
     * Test of getProduct method, of class ProductFactory.
     */
    @Test
    public void testGetProduct_8args_1() {
        System.out.println("getProduct");
        String type = "";
        String pBrand = "";
        String pModel = "";
        int pPrice = 0;
        String processor = "";
        int ram = 0;
        String os = "";
        String gCard = "";
        Product expResult = null;
        Product result = ProductFactory.getProduct(type, pBrand, pModel, pPrice, processor, ram, os, gCard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProduct method, of class ProductFactory.
     */
    @Test
    public void testGetProduct_9args() {
        System.out.println("getProduct");
        String type = "";
        String brand = "";
        String model = "";
        int pPrice = 0;
        int cameraSize = 0;
        String colorStr = "";
        String resolution = "";
        String os = "";
        int storage = 0;
        Product expResult = null;
        Product result = ProductFactory.getProduct(type, brand, model, pPrice, cameraSize, colorStr, resolution, os, storage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProduct method, of class ProductFactory.
     */
    @Test
    public void testGetProduct_8args_2() {
        System.out.println("getProduct");
        String type = "";
        String pBrand = "";
        String pModel = "";
        int pPrice = 0;
        int dpi = 0;
        String colour = "";
        String connectivity = "";
        String weight = "";
        Product expResult = null;
        Product result = ProductFactory.getProduct(type, pBrand, pModel, pPrice, dpi, colour, connectivity, weight);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProduct method, of class ProductFactory.
     */
    @Test
    public void testGetProduct_7args() {
        System.out.println("getProduct");
        String type = "";
        String brand = "";
        String model = "";
        int pPrice = 0;
        String weight = "";
        String colour = "";
        String storage = "";
        Product expResult = null;
        Product result = ProductFactory.getProduct(type, brand, model, pPrice, weight, colour, storage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
