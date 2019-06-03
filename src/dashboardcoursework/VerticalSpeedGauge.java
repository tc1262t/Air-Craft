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
import eu.hansolo.medusa.TickMarkType;
import javafx.scene.paint.Color;

/**
 *
 * @author Nerijus
 */
public class VerticalSpeedGauge extends DashboardControl implements Dials{
    
    private Gauge verticalSpeedGauge;
        
        private static VerticalSpeedGauge instance = null;
        
        public static synchronized VerticalSpeedGauge getInstance(){
            
            if(instance==null) instance =new VerticalSpeedGauge();
            return instance;
        }
   // temp gauge              
        
        public Gauge create() {
            
            verticalSpeedGauge = GaugeBuilder.create()
                               .borderPaint(Color.RED)
                               .foregroundBaseColor(Color.WHITE)
                               .prefSize(250, 250)
                               .startAngle(140)
                               .angleRange(270) ///////////////////
                               //.minValue(0)
                               .maxValue(800)
                               .valueVisible(false)
                               .minorTickMarksVisible(false)
                               .majorTickMarkType(TickMarkType.BOX)
                               .mediumTickMarkType(TickMarkType.BOX)
                               .title("VERTICAL SPEED")
                               .needleShape(NeedleShape.ROUND)
                               .needleSize(NeedleSize.THIN)
                               .needleColor(Color.rgb(234, 67, 38))
                               .knobColor(Gauge.BRIGHT_COLOR)
                               .customTickLabelsEnabled(true)
                               .customTickLabelFontSize(40)
                               .customTickLabels("0", "100", "200", "300", "400", "500", "600", "700", "800")
                               .animated(true)
                               .build();
            
            return verticalSpeedGauge;
            
        }
   
    
    
}
