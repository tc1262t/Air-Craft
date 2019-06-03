package dashboardcoursework;

import dashboardcoursework.Battery;
import eu.hansolo.medusa.Gauge;
import java.io.File;

import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.RED;
import org.w3c.dom.*;
import javax.xml.parsers.*;

public class DashboardCoursework extends Application {
    
    
    
    double fuel;
    boolean fuelNotEmpty = true;
    double speed = 0;
    double newSpeed = 0;
    double litres = 15000;
    double oil = 1000;
    double vSpeed = 0;
    int altitude = 0;        
    
    DecimalFormat twoDecFormat = new DecimalFormat("#,###.00");
    
    ProgressBar fuelBar;
    ProgressIndicator pi;
    TextField speedTxt;
    Label lbFuel;
    Boolean up = true;
    Boolean down = true;
    boolean engineStarted = true;
    
    double energy = 0;
    Battery battery1 = new Battery(0, 100, GREEN, RED);
        
        ProgressBar pb = new ProgressBar(battery1.getCurrentEnergy());
        ProgressIndicator pind = new ProgressIndicator(battery1.getCurrentEnergy());
    
    int color = 282929;
    BorderPane main = new BorderPane();
    
    CustomButton XML = new CustomButton("Load XML");
    CustomButton btnUserInputs = new CustomButton("User Inputs");
    CustomButton btnDesign = new CustomButton("Choose Dashboard\n design color");
    
    CustomButton btnStart = new CustomButton("Start engine");    
    CustomButton btnFly = new CustomButton("Fly");
    CustomButton btnLand = new CustomButton("Land");
    
    CustomButton btnVUP = new CustomButton("Increase altitude");
    CustomButton btnVMID = new CustomButton("Maintain altitude");
    CustomButton btnVDOWN = new CustomButton("Decrease altitude");
          
    CustomButton btnUP = new CustomButton("Increase Speed");
    CustomButton btnMID = new CustomButton("Maintain Speed");
    CustomButton btnDOWN = new CustomButton("Decrease Speed");
    
    Thread thread = new Thread();
    Thread thread2 = new Thread();  
    Thread thread3 = new Thread();
    
    
    OilGauge oilGaugeControl = new OilGauge();
    Gauge oilGauge;
    
    FuelGauge fuelGaugeControl = FuelGauge.getInstance();
    Gauge fuelGauge;
    
    AirSpeedGauge airSpeedGaugeControl = AirSpeedGauge.getInstance();
    Gauge airSpeedGauge;
    
    VerticalSpeedGauge verticalSpeedGaugeControl = VerticalSpeedGauge.getInstance();
    Gauge verticalSpeedGauge;
    
    VerticalBar verticalBarControl = VerticalBar.getInstance();
    Gauge verticalBar;
    
    
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane grid = new GridPane();       
                
        GridLoops gc = new GridLoops();
        gc.gridColumnLoop(grid, 0, 1, 250);
        
        GridLoops gr = new GridLoops();
        gr.gridRowLoop(grid, 0, 1, 250);               
        
        
        //padding top, right, bottom, left
        grid.setPadding(new Insets(1, 1, 1, 1));
        //vertical spacing
        grid.setVgap(15);
        grid.setHgap(15);
        

        fuel = 1;        
        
        btnFly.setDisable(true);               
        
        fuelBar = new ProgressBar(fuel);
        pi = new ProgressIndicator(fuel);
        speedTxt = new TextField("10");
        speedTxt.setPrefWidth(50);
        lbFuel = new Label("Fuel remaining: " + litres + " litres");
        lbFuel.setTextFill(Color.web("#ffffff"));
        btnUP.setDisable(true);
        btnDOWN.setDisable(true);
        btnMID.setDisable(true);
                          
        btnVUP.setDisable(true);
        btnVMID.setDisable(true);
        btnVDOWN.setDisable(true);
        
        
        oilGauge = oilGaugeControl.create();
        airSpeedGauge = airSpeedGaugeControl.create();
        verticalSpeedGauge = verticalSpeedGaugeControl.create();
        verticalBar = verticalBarControl.create();
        fuelGauge = fuelGaugeControl.create();
        
        
    
        

        GridPane.setConstraints(btnMID, 3, 4);
        GridPane.setConstraints(btnDOWN, 3, 5);
        GridPane.setConstraints(btnFly, 2, 4);
        GridPane.setConstraints(oilGauge, 1 ,0);
        GridPane.setConstraints(fuelGauge, 2, 0);
        GridPane.setConstraints(airSpeedGauge, 0, 0);
        GridPane.setConstraints(verticalSpeedGauge,3, 0);
        
        grid.getChildren().addAll(oilGauge, fuelGauge, btnFly, airSpeedGauge, /*verticalBar,*/ verticalSpeedGauge, btnUP);
        
        GridPane grid2 = new GridPane();
        
        for (int i = 1; i < 6; i++){
            ColumnConstraints column = new ColumnConstraints(108);            
            grid2.getColumnConstraints().add(column);           
        }
        
        for (int i = 0; i < 5; i++){
            RowConstraints row = new RowConstraints(50);
            grid2.getRowConstraints().add(row);
        }
        
        grid2.setVgap(15);
        grid2.setHgap(15);
        
        //grid2.add(fuelBar, 0, 1);
        //grid2.add(lbFuel, 1,1);
        grid2.add(btnUP, 4, 2);
        grid2.add(btnMID, 4, 3);
        grid2.add(btnDOWN, 4, 4);
        grid2.add(btnFly, 3, 3);
        grid2.add(btnVUP, 2, 2);
        grid2.add(btnVMID, 2, 3);
        grid2.add(btnVDOWN, 2, 4);
        grid2.add(btnStart, 3, 5);
        grid2.add(btnLand, 3, 4);
        grid2.add(XML, 0, 2);
        grid2.add(btnUserInputs, 0, 3);
        grid2.add(btnDesign, 0, 4);
        grid2.add(pb, 0, 5);
        
                
        VBox left = new VBox(10);
        left.getChildren().add(grid);
        left.getChildren().add(grid2);
                        
        VBox right = new VBox(3);
        right.getChildren().addAll(verticalBar);
       
        
                       
        
        main.setStyle("-fx-background-color: #" + color);
        main.setLeft(left);
        main.setRight(right);
        
        btnStart.setOnAction(r -> { 
            increaseBar();
            decreaseOil();
            startEngine();                     
        });
        
        btnFly.setOnAction(r -> {
            btnVMID.setDisable(false);
            btnVDOWN.setDisable(false);
            increaseAltitude(); 
                });
        
        btnVMID.setOnAction(r -> {
            decreaseAltitude();
        });
        
        btnUP.setOnAction(r -> increaseSpeed());
        btnDOWN.setOnAction(r -> decreaseSpeed());
        btnMID.setOnAction(r -> maintainSpeed());        
        XML.setOnAction (r -> XML());
        //btnUserInputs.setOnAction(r -> {UserInputs us = new UserInputs();});
        
        btnUserInputs.setOnAction((ActionEvent event) -> userInputs()); 
        btnDesign.setOnAction(r -> changeDesign());
        
        //btnDesign.setOnAction(r -> BatterySelector());
//        btnDesign.setOnAction((ActionEvent event) ->
//           new UserInputs());
         
        
        
        
        Scene scene = new Scene(main, 1000, 650);
        
        primaryStage.setTitle("Airplane dashboard");
        primaryStage.setScene(scene);
        primaryStage.show();
        
         //DashboardControl sb = new DashboardControl();         
        // sb.changeFuelGauge(oilGaugeControl, 23);
         //sb.changeTitle(oilGaugeControl, "fds");
    }

    public static void main(String[] args) {
        launch(args); 
        
    }
    
    public void changeDesign(){
        final ToggleGroup radgroup = new ToggleGroup();
        
        RadioButton rb1 = new RadioButton("high");
        rb1.setToggleGroup(radgroup);       
        rb1.setUserData("high");
        rb1.setSelected(true);
        
        RadioButton rb2 = new RadioButton("medium");
        rb2.setToggleGroup(radgroup);
        rb2.setUserData("medium");
        
        RadioButton rb3 = new RadioButton("low");
        rb3.setToggleGroup(radgroup);
        rb3.setUserData("low");
        
        Button test = new Button ("Change color");
        
        Label colorlbl = new Label ("Choose your\n color");

        
        test.setOnAction(r -> {
            ColorInterface selectedBattery = ColorFactory.createColor(radgroup.getSelectedToggle().getUserData().toString());
                colorlbl.setText("colour: " + selectedBattery.getColor());
                color = selectedBattery.getColor();
                main.setStyle("-fx-background-color: #" + color);
        });
        
        
            GridPane grid3 = new GridPane();
            
            GridLoops gc3 = new GridLoops();
            gc3.gridColumnLoop(grid3, 0, 8, 100);
        
            GridLoops gr3 = new GridLoops();
            gr3.gridRowLoop(grid3, 0, 8, 50);
            
            grid3.add(colorlbl, 1 ,2);
            grid3.add(test, 1, 7);
            grid3.add(rb1, 1, 4);
            grid3.add(rb2, 1, 5);
            grid3.add(rb3, 1, 6);             
            
            Scene secondScene = new Scene(grid3, 400, 500);
            
            Stage secondStage = new Stage();
            secondStage.setTitle("User inputs");
            secondStage.setScene(secondScene);            
            secondStage.show();
    }
    
    public void userInputs(){
        
        
        GridPane grid3 = new GridPane(); 
        
            Label speedlbl = new Label("Input speed");
            TextField speedtxt = new TextField();            
            Label oillbl = new Label("Input oil");
            TextField oiltxt = new TextField();            
            Label fuellbl = new Label("Input fuel"); 
            TextField fueltxt = new TextField();            
            Label airspeedlbl = new Label ("Input air speed");
            TextField airspeedtxt = new TextField();            
            Label altitudelbl = new Label ("Input altitude");
            TextField altitudetxt = new TextField();            
            Label secondLabel = new Label("User inputs");

                                         
            grid3.add(secondLabel, 1 ,1);            
            grid3.add(speedlbl, 1, 3);
            grid3.add(speedtxt, 2, 3);            
            grid3.add(oillbl, 1, 4);
            grid3.add(oiltxt, 2, 4);            
            grid3.add(fuellbl, 1, 5);
            grid3.add(fueltxt, 2, 5);            
            grid3.add(airspeedlbl, 1, 6);
            grid3.add(airspeedtxt, 2, 6);            
            grid3.add(altitudelbl, 1, 7);
            grid3.add(altitudetxt, 2, 7);            
//            StackPane userInputsWindow = new StackPane();
//            userInputsWindow.getChildren().add(secondLabel);           
            Scene secondScene = new Scene(grid3, 400, 500);            
            Stage secondStage = new Stage();
            secondStage.setTitle("User inputs");
            secondStage.setScene(secondScene);                                    
            //Set position of second window, related to primary window.
           // secondStage.setX(primaryStage.getX() + 250);
            //secondStage.setY(primaryStage.getY() + 100);            
            secondStage.show();
        }
    
        
    
    public void increaseBar() {                        
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (fuel > 0.00) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(DashboardCoursework.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    Platform.runLater(() -> {
                        fuel = fuel - fuelConsumption();
                        
                        fuelBar.setProgress(fuel);
                        fuelGauge.setValue(litres);
                        pi.setProgress(fuel);
                        litres = 700*fuel;
                        lbFuel.setText("Fuel remaining: " + twoDecFormat.format(litres) + " litres\n" + "consumes litres per second " + twoDecFormat.format(fuelConsumption()*700));
                    });
                }
            }
        }).start();       
        } 
        
    
        public void increaseSpeed() {   
            
        btnMID.setDisable(false);
        btnDOWN.setDisable(false);
        btnUP.setDisable(true);
            
        Thread thread3 = new Thread(() -> {  
            up = true;
            down = false;
            while (up == true) {
//                 while (up == true){
                     if (speed > 100){
                         btnFly.setDisable(false);
                     }
                {
                try {
                    Thread.sleep(100);
                    airSpeedGauge.setValue(speed);                                        
                    //speed = Double.parseDouble(speedTxt.getText());
                    energy += 0.01;
                    pind.setProgress(energy);
                    pb.setProgress(energy);
                     speed += 2;
                    } catch (InterruptedException ex) {
                    Logger.getLogger(DashboardCoursework.class.getName()).log(Level.SEVERE, null, ex);
                    }                                                     
            }}          
    });
                thread3.start();       
        } 
           
        public void decreaseSpeed() {              
            btnDOWN.setDisable(true);
            btnUP.setDisable(false);
            
            Thread thread2 = new Thread(() -> {
                down = true;
                up = false;              
             while (down == true) {
                 //while (down == true){
                {
                try {
                    Thread.sleep(101);
                    airSpeedGauge.setValue(speed);
                    speed -= 1;
                    } catch (InterruptedException ex) {
                    Logger.getLogger(DashboardCoursework.class.getName()).log(Level.SEVERE, null, ex);
                    }                                                    
             }}
//            }            
    });
                    thread2.start();                          
                    }
        
        public void decreaseOil(){            
            
            Thread thread4 = new Thread(() -> {
                while (engineStarted == true) {
                    try {
                        Thread.sleep(102);
                        oilGauge.setValue(oil);
                        oil -= 1;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(DashboardCoursework.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            thread4.start();            
        }
        
        public void increaseAltitude(){
            Thread thread5 = new Thread(() -> {
                while (engineStarted == true){
                    try {
                        Thread.sleep(200);
                        verticalSpeedGauge.setValue(vSpeed);
                        vSpeed = speed * 0.4;
                        altitude += vSpeed*1.5;
                        verticalBar.setValue(altitude/5);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(DashboardCoursework.class.getName()).log(Level.SEVERE, null, ex);
                    }
                };
            }); 
            thread5.start();
        } 
        
        public void decreaseAltitude() {
            Thread thread6 = new Thread(() -> {
                while (fuelNotEmpty == true){
                    try{
                        Thread.sleep(190);
                        vSpeed = speed * 0.4;
                        altitude -= vSpeed*1.5;
                        verticalBar.setValue(altitude/5);
                    }
                    catch (InterruptedException ex){
                        Logger.getLogger(DashboardCoursework.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            thread6.start();
        }
        
        public void maintainSpeed() {
            btnUP.setDisable(false);
            btnDOWN.setDisable(false);
           up = false;
           down = false;
        }

        public void startEngine() {
            oilGauge.setValue(oil);
            fuelGauge.setValue(litres);
            btnStart.setDisable(true);
            btnUP.setDisable(false);
        }
   
    public double fuelConsumption(){
        double fuelConsumption = Double.parseDouble(speedTxt.getText())/1000;
        return fuelConsumption;
    }

    
    public void XML() {
        
        try {	
         File inputFile = new File("new.xml");
         DocumentBuilderFactory dbFactory 
            = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" 
            + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("Gauge");
         System.out.println("----------------------------");
         
                 
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" 
               + nNode.getNodeName());
              if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               
               oilGauge.setValue(Double.parseDouble(eElement.getElementsByTagName("OilGauge").item(0).getTextContent()));
               airSpeedGauge.setValue(Double.parseDouble(eElement.getElementsByTagName("AirSpeedGauge").item(0).getTextContent()));
               verticalSpeedGauge.setValue(Double.parseDouble(eElement.getElementsByTagName("VerticalSpeedGauge").item(0).getTextContent()));
               
               fuelGauge.setValue(Double.parseDouble(eElement.getElementsByTagName("FuelGauge").item(0).getTextContent()));
               verticalBar.setValue(Double.parseDouble(eElement.getElementsByTagName("VerticalBar").item(0).getTextContent()));                                                            
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }        
    };               
    }
   