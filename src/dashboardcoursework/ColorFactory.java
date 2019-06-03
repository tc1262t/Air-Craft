/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboardcoursework;


public class ColorFactory {
    
    public static ColorInterface createColor(String type) {
        switch (type) {
            case "high":
                return new ColorGreen();
            case "medium":
                return new ColorYellow();
            case "low":
                return new ColorRed();
            default:
                return null;
        }
    }
}
