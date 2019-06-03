/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboardcoursework;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;



public class ColorInterfaceTest {
    
    public ColorInterfaceTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getColor method, of class ColorInterface.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        ColorInterface instance = new ColorInterfaceImpl();
        int expResult = 0;
        int result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    public class ColorInterfaceImpl implements ColorInterface {

        public int getColor() {
            return 0;
        }
    }
    
}
