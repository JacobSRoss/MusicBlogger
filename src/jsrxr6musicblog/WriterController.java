/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsrxr6musicblog;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Jacob 2015
 */
public class WriterController extends Switchable implements Initializable {

    @FXML
    public HTMLEditor htmlEditor;
    
    @FXML
    private AnchorPane anchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleSavePress() throws IOException{
        Stage primaryStage = (Stage)anchorPane.getScene().getWindow();
        String stringHtml = htmlEditor.getHtmlText();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(primaryStage);
        if (file != null) {
            handleSave(stringHtml, file);
        }
    }
    
    private void handleSave(String content, File file) throws IOException{
            FileWriter fileWriter = null;
             
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
    }
    
    @FXML
    private void handleGoToListen(){
        Switchable.switchTo("Player");
    }
    
    @FXML
    private void handleGoToAboutMe(){
        Switchable.switchTo("AboutMe");
    }
}
