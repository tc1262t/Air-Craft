/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboardcoursework;

import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.GaugeBuilder;
import eu.hansolo.medusa.Section;
import eu.hansolo.medusa.TickMarkType;
import javafx.geometry.Orientation;
import javafx.scene.paint.Color;


public class VerticalBar extends DashboardControl implements Dials, fxGauge{
 
     private Gauge verticalBar;
        
        private static VerticalBar instance = null;
        
        public static synchronized VerticalBar getInstance(){
            
            if(instance==null) instance =new VerticalBar();
            return instance;
        }
        

     @Override
              public Gauge create() {
     verticalBar = GaugeBuilder.create()
                             .skinType(Gauge.SkinType.LINEAR)
                             .sections(new Section(0, 16.66666, "0", Color.web("#11632f")),  //use hex table to chose colour of bar
                                       new Section(16.66666, 33.33333, "1", Color.web("#36843d")),
                                       new Section(33.33333, 50.0, "2", Color.web("#67a328")),
                                       new Section(50.0, 66.66666, "3", Color.web("#80b940")),
                                       new Section(66.66666, 83.33333, "4", Color.web("#95c262")),
                                       new Section(83.33333, 1000.0, "5", Color.web("#badf8d")))
                             .title("Altitude")
                             .unit("feet")
                             .prefSize(150, 600)
                             .threshold(50)
                             .orientation(Orientation.VERTICAL)
                             .animated(true)
                             //.titleColor(Color.WHITE)
                             .unitColor(Color.WHITE)
                             .tickLabelColor(Color.WHITE)
                             .tickMarkColor(Color.RED)
             //.minValue(0)
             .maxValue(50000)
             .valueColor(Color.WHITE)
                             .build();    
       
   
    return verticalBar;
    
}

    
              
              
    
    
}
