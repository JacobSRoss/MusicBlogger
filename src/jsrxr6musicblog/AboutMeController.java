/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsrxr6musicblog;

import java.awt.Font;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javax.swing.JTextArea;

/**
 * FXML Controller class
 *
 * @author Jacob 2015
 */
public class AboutMeController extends Switchable implements Initializable {

    @FXML
    private TextArea textArea1;
    
    @FXML
    private TextArea textArea2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        textArea1.setText(
                "My name is Jacob Ross\n" 
                + "Pawprint: jsrxr6\n"
                + "Student Number: 18134516\n"
                + "I love music and thought that it would be cool to listen to it and write about it at the same time!\n"
        );
        textArea2.setText(
                "This application is meant to be a place where you can listen to music and write about that music at the same time.\n"
                + "Anything that you write can be saved as HTML so you can copy and paste right into a website!\n"
        );
    }
    
    @FXML
    private void handleGoToListen(){
        Switchable.switchTo("Player");
    }
    
    @FXML
    private void handleGoToWrite(){
        Switchable.switchTo("Writer");
    }
}
