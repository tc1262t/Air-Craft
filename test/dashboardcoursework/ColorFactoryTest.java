/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboardcoursework;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sofina
 */
public class ColorFactoryTest {
    
    public ColorFactoryTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of createColor method, of class ColorFactory.
     */
    @Test
    public void testCreateColor() {
        System.out.println("createColor");
        String type = "";
        ColorInterface expResult = null;
        ColorInterface result = ColorFactory.createColor(type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
