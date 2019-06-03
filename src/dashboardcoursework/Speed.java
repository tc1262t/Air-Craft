/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboardcoursework;

import javafx.scene.control.TextField;


public class Speed {
    
    double fuel;
    double speed = 0;
    double newSpeed = 0;
    double litres = 700;
    TextField speedTxt;
    
    
     public void SpeedIncrease() {
       speed = Double.parseDouble(speedTxt.getText());
                    speed += 0.17;
       
   }
    
     
     
     public void SpeedDecrease() {
         
         speed = Double.parseDouble(speedTxt.getText());
                    speed -= 0.17;
         
         
     }
     
    
    
    
}
