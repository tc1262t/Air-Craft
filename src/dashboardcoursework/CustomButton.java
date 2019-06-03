/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboardcoursework;

import javafx.scene.control.Button;

/**
 *
 * @author Nerijus
 */
public class CustomButton extends Button{
    
    public CustomButton (String name){
        setMaxWidth(120);
        setMinWidth(120);
        setText(name);
        setStyle("-fx-border-color:red; -fx-background-color: white; -fx-text-fill: black");
    }
    
}
