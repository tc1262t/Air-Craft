/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboardcoursework;

import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.GaugeBuilder;
import eu.hansolo.medusa.TickMarkType;
import eu.hansolo.medusa.skins.ModernSkin;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class OilGauge extends DashboardControl implements Dials{
    
        public Gauge oilGauge;
        
         //public OilGauge () {}
        
        @Override
        public Gauge create() {
           // oilGauge.setTitle("lol");
            oilGauge = GaugeBuilder.create()
                               .skinType(Gauge.SkinType.GAUGE)
                               .prefSize(150, 150)
                               .foregroundBaseColor(Color.WHITE)
                    
                              // .title("OIL")
                               .valueVisible(false)
                               .angleRange(180)
                               .startAngle(270)
                    //.minValue(0)
                    .maxValue(1000)
                   // .value(64)
                               .needleShape(Gauge.NeedleShape.ROUND)
                               .needleSize(Gauge.NeedleSize.THICK)
                               .needleColor(Color.rgb(234, 67, 38))
                               .minorTickMarksVisible(false)
                               .mediumTickMarksVisible(false)
                               .majorTickMarkType(TickMarkType.BOX)
                               .knobColor(Gauge.DARK_COLOR)
                               .customTickLabelsEnabled(true)
                               .customTickLabelFontSize(36)
                               .customTickLabels("E", "", "", "", "", "", "", "", "", "", "F")
                               .animated(true)
                               .build();
            
            return oilGauge;
            
//            Gauge oil = new Gauge();
//                
//            
//                oil.setSkin(new ModernSkin(oil));
//                
//                //oil.setTitle("gdf");
//                
//            return oil;
            
            
        }


    
   
    
    
}
