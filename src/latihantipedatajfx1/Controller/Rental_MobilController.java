/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package latihantipedatajfx1.Controller;

import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import latihantipedatajfx1.Model.Rental_Kendaraan_Models;

/**
 * FXML Controller class
 *
 * @author Muhamad Ariq Rasyid
 */
public class Rental_MobilController implements Initializable {

    Rental_Kendaraan_Models mdl = new Rental_Kendaraan_Models();
    Locale Indonesia = new Locale("in", "ID");
    NumberFormat formater = NumberFormat.getCurrencyInstance(Indonesia);
    @FXML
    private DatePicker datepicker_pinjam;
    @FXML
    private DatePicker datepicker_sewa;
    @FXML
    private TextField Total_Harga;
    @FXML
    private TextField lamasewa_text;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Hitung_Button(ActionEvent event) {
        SimpleDateFormat tgl = new SimpleDateFormat("dd-MM-yyyy");
        try {
            mdl.setTgl_pinjam(tgl.parse(datepicker_pinjam.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
            ));
            mdl.setTgl_kembali(tgl.parse(datepicker_sewa.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
            ));
        } catch (ParseException e) {
            e.printStackTrace();

        }
        long stgl = Math.round(1.0 * (mdl.getTgl_kembali().getTime()
                - mdl.getTgl_pinjam().getTime()) / (1000 * 60 * 60 * 24));

        lamasewa_text.setText(String.valueOf(stgl));
        double hari = Double.parseDouble(lamasewa_text.getText());
        mdl.setHarga(300000*hari);
        
        Total_Harga.setText(formater.format(mdl.getHarga()));
        
       
    }

    @FXML
    private void Hapus_button(ActionEvent event) {
        datepicker_pinjam.getEditor().clear();
        datepicker_sewa.getEditor().clear();
        Total_Harga.setText("");
        datepicker_pinjam.requestFocus();
    }

    @FXML
    private void Keluar_button(ActionEvent event) {
        System.exit(0);
    }

}
