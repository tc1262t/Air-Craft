
package dashboardcoursework;

import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.RED;


public class Battery {
    
    
    
    private int maxEnergy = 100;
    private int energy = 0;
    private int currentEnergy = 0;
    private Color colorLow = RED;
    private Color colorHigh = GREEN;
    private boolean functional = true;
    
    public String name = "Battery";
    
    ProgressBar pb = new ProgressBar(currentEnergy);
    ProgressIndicator pi = new ProgressIndicator(currentEnergy);
    
    public int getMaxEnergy()
    {
        return maxEnergy;
    }
    
    public int getEnergy()
    {
        return energy;
    }
    
    public int getCurrentEnergy()
    {
        return currentEnergy;
    }
    
    public Color getColorLow()
    {
        return colorLow;
    }
    
    public Color getColorHigh()
    {
        return colorHigh;
    }
    
    public void setCurrentEnergy(int decreaseEnergy)
    {
        currentEnergy = currentEnergy - decreaseEnergy;
        
        if (currentEnergy > 50)
        {
            pb.setStyle("-fx-control-inner-background: #" + colorHigh);
        } else if (currentEnergy > 0)
        {
            pb.setStyle("-fx-control-inner-background: #" + colorLow);
        } else 
        {
            pb.setStyle("-fx-control-inner-background: #" + colorLow);
            functional = false;
        }
            
    }
    
    public Battery (int newCurrentEnergy, int newMaxEnergy, Color newColorLow, Color newColorHigh)
    {
        currentEnergy = newCurrentEnergy;
        maxEnergy = newMaxEnergy;
        colorLow = newColorLow;
        colorHigh = newColorHigh;
    }
    
    
}
