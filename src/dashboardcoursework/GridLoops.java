
package dashboardcoursework;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;


public class GridLoops extends DashboardCoursework{
    
    public void gridColumnLoop(GridPane grid, int minLoop, int maxLoop, int size){
    for (int i = 0; i < maxLoop; i++){
            ColumnConstraints column = new ColumnConstraints(size);            
            grid.getColumnConstraints().add(column);           
        } 
    }
    
    public void gridRowLoop(GridPane grid, int minLoop, int maxLoop, int size){
    for (int i = 0; i < maxLoop; i++){
            RowConstraints row = new RowConstraints(size);            
            grid.getRowConstraints().add(row);           
        } 
    }   
    
}
