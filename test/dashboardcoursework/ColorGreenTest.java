/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboardcoursework;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ColorGreenTest {
    
    public ColorGreenTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getColor method, of class ColorGreen.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        ColorGreen instance = new ColorGreen();
        int expResult = 305639;
        int result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }
    
}
