/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboardcoursework;

import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.Gauge.NeedleShape;
import eu.hansolo.medusa.Gauge.NeedleSize;
import eu.hansolo.medusa.GaugeBuilder;
import eu.hansolo.medusa.LcdDesign;
import eu.hansolo.medusa.LcdFont;
import eu.hansolo.medusa.TickMarkType;
import javafx.scene.paint.Color;

public class AirSpeedGauge extends DashboardControl implements Dials, fxGauge{
    
    private Gauge airSpeedGauge;
        
        private static AirSpeedGauge instance = null;
        
        public static synchronized AirSpeedGauge getInstance(){
            
            if(instance==null) instance =new AirSpeedGauge();
            return instance;
        }
   // temp gauge              
        
    @Override
        public Gauge create() {
            
            airSpeedGauge = GaugeBuilder
                               .create()
                               .borderPaint(Color.RED)
                               .foregroundBaseColor(Color.WHITE)
                               .prefSize(400, 400)
                               .startAngle(140)
                               .angleRange(270) ///////////////////
                               //.minValue(0)
                               .maxValue(750)
                               .unit("mph")
                                .decimals(0)
                               .lcdVisible(false)
                               .lcdDesign(LcdDesign.STANDARD)
                               .lcdFont(LcdFont.DIGITAL_BOLD)
                               
                               //.valueVisible(false)
                               .minorTickMarksVisible(false)
                               .majorTickMarkType(TickMarkType.BOX)
                               .mediumTickMarkType(TickMarkType.BOX)
                               .title("AIR SPEED")
                               .needleShape(NeedleShape.ROUND)
                               .needleSize(NeedleSize.THIN)
                               .needleColor(Color.rgb(234, 67, 38))
                               .knobColor(Gauge.BRIGHT_COLOR)
                               .customTickLabelsEnabled(true)
                               .customTickLabelFontSize(40)
                               .customTickLabels("0", "100", "200", "300", "400", "500", "600", "700", "800")
                               .animated(true)
                               .build();
            
            return airSpeedGauge;
            
        }

    
   
    
    
}
