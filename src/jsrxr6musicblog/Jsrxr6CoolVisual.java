/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsrxr6musicblog;

import static java.lang.Integer.min;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Jacob 2015
 */
public class Jsrxr6CoolVisual implements Visualizer {
    
    private final String name = "Jsrxr6 Cool Visual";
    
    private Integer numBands;
    private AnchorPane vizPane;
    
    private Double width = 0.0;
    private Double height = 0.0;
    private Double bandWidth = 0.0;
    
    private final Double hue = 050.0;
    private final Double opacity = 0.5;
    
    private Circle[] circles;
    private Rectangle flash;
    
    private ImageView imageView;
    private Image image;
    private final String imageName = "Jsrxr6Woah.jpg";
    
    public Jsrxr6CoolVisual() {
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void start(Integer numBands, AnchorPane vizPane) {
        end();
        
        this.numBands = numBands;
        this.vizPane = vizPane;
        
        height = vizPane.getHeight();
        width = vizPane.getWidth();
        
        bandWidth = width / numBands;
        
        circles = new Circle[numBands];
        
        imageView = new ImageView();
        image = new Image(getClass(). getResourceAsStream(imageName));
        imageView.setImage(image);
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
        imageView.setPreserveRatio(true);
        vizPane.getChildren().add(imageView);
        
        flash = new Rectangle(width, height);
        flash.setFill(Color.hsb(hue, 1.0, 1.0, 0.25));
        vizPane.getChildren().add(flash);
        
        for (int i=0; i<numBands; i++) {
            
            Circle circle = new Circle();
            circle.setCenterX(bandWidth / 2 + bandWidth * i);
            circle.setCenterY(height);
            circle.setRadius(40.0f);
            circle.setFill(Color.hsb(hue, 1.0, 1.0, opacity));
            vizPane.getChildren().add(circle);
            circles[i] = circle;
            
        }

    }
    
    @Override
    public void end() {
        if (circles != null) {
            for(Circle circle : circles) {
                vizPane.getChildren().remove(circle);
            }
            circles = null;
        }
        if (imageView != null){
            vizPane.getChildren().remove(imageView);
            imageView = null;
        }
        if (flash != null){
            vizPane.getChildren().remove(flash);
            flash = null;
        }
        
    }
    
    @Override
    public void update(double timestamp, double duration, float[] magnitudes, float[] phases) {
        if (circles == null) {
            return;
        }
        
        Integer number = min(circles.length, magnitudes.length);
        

        for (int i=0; i<number; i++) {
            circles[i].setRadius(Math.abs(magnitudes[i]));
            circles[i].setFill(Color.hsb(hue + (magnitudes[i] * 6.0), 1.0, 1.0, (opacity + (magnitudes[i]/100) * -1)));
            flash.setFill(Color.hsb(((60.0 + magnitudes[0])/60.0) * 360, 1.0, 1.0, 0.25));
            imageView.setRotate(phases[0]);
            flash.setRotate(phases[0]);
        }
    }
}
