/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboardcoursework;

import dashboardcoursework.SpeedInterface;
import dashboardcoursework.Speed;

/**
 *
 * @author tc1262t
 */
public class SpeedProxy implements SpeedInterface{
    
    Speed sp;
    
    public SpeedProxy(){}
    
    public void ChangeSpeed(){
        
        sp = new Speed();
        sp.SpeedIncrease();
        sp.SpeedIncrease();
        
        
        
    }

    @Override
    public void Increase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Decrease() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
