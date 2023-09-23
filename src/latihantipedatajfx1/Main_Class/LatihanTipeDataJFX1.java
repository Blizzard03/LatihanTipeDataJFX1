/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package latihantipedatajfx1.Main_Class;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Muhamad Ariq Rasyid
 */
public class LatihanTipeDataJFX1 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/latihantipedatajfx1/FXML/Rental_Mobil.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Latihan Tipe Data JFX1 - Rental Kendaraan");
        stage.setResizable(false);
        stage.setIconified(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
