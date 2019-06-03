/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboardcoursework;

import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.GaugeBuilder;
import eu.hansolo.medusa.TickMarkType;
import javafx.scene.paint.Color;


/**
 *
 * @author Nerijus
 */
public class FuelGauge extends DashboardControl implements Dials, fxGauge {
    
    private static Gauge fuelGauge;
        
        private static FuelGauge instance = null;
        
        public static synchronized FuelGauge getInstance(){
            
            if(instance==null) instance =new FuelGauge();
            return instance;
        }
   // temp gauge              
        
        @Override
        public Gauge create() {
            
            fuelGauge = GaugeBuilder.create()
                    
                               .skinType(Gauge.SkinType.GAUGE)
                               .prefSize(150, 150)                   
                               .foregroundBaseColor(Color.WHITE)
                               .title("Fuel")
                               .valueVisible(false)
                               .angleRange(180)
                               .startAngle(270)
                   // .minValue(0)
                    .maxValue(700)
                               .needleShape(Gauge.NeedleShape.ROUND)
                               .needleSize(Gauge.NeedleSize.THICK)
                               .needleColor(Color.rgb(234, 67, 38))
                               .minorTickMarksVisible(false)
                               .mediumTickMarksVisible(false)
                               .majorTickMarkType(TickMarkType.BOX)
                               .knobColor(Gauge.DARK_COLOR)
                               .customTickLabelsEnabled(true)
                               .customTickLabelFontSize(36)
                               .customTickLabels("E", "", "", "", "", "", "", "", "F")
                               .animated(true)
                               .build();
            
            return fuelGauge;
            
        }

   
   
    
    
}
