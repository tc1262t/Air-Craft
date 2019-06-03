
package dashboardcoursework;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ColorYellowTest {
    
    public ColorYellowTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getColor method, of class ColorYellow.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        ColorYellow instance = new ColorYellow();
        int expResult = 777529;
        int result = instance.getColor();
        assertEquals(expResult, result);
      
        
    }
    
}
