/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pojo.Pax;
import pojo.Reservation;
import service.JdbcUtils;
import service.ReservationService;


    

public class SUBMITController implements Initializable {
    @FXML
    public TextField Branchs;
    @FXML
    private Label mess;
    @FXML
    public TextField Paxs;
    
    @FXML
    public TextField baby;
    
    @FXML
    public TextField senior;
    
    @FXML
    public TextField Times;
    @FXML
    public TextField date;
    @FXML
    public TextField Name;
    @FXML
    public TextField phone;
    @FXML
    public TextField mail;
    @FXML
    public TextArea require;
    @FXML
    private Button btnSubmit;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.Paxs.setEditable(false);
        this.Times.setEditable(false);
        this.date.setEditable(false);
        this.Branchs.setEditable(false);
        this.baby.setEditable(false);
        this.mail.setEditable(false);
        this.phone.setEditable(false);
        this.senior.setEditable(false);
        this.Name.setEditable(false);
    }
       
    public void addReservation(ActionEvent evt){
        try{
            Connection conn = JdbcUtils.getConn();
            ReservationService rs = new ReservationService(conn);
            String name = this.Name.getText();
            String branch = this.Branchs.getText();
            String time = this.Times.getText();
            Date date = java.sql.Date.valueOf(LocalDate.parse(this.date.getText()));
            int pax = Integer.parseInt(this.Paxs.getText());
            int baby = Integer.parseInt(this.baby.getText());
            int senior = Integer.parseInt(this.senior.getText());
            String phone = this.phone.getText();
            String mail = this.mail.getText();
            String require = this.require.getText();
            
            Reservation p = new Reservation();
            
            p.setCustomer_Name(name);
            p.setCustomer_email(mail);
            p.setCustomer_phone(phone);
            p.setBaby(baby);
            p.setBranch_name(branch);
            p.setDate(date);
            p.setNote(require);
            p.setTime(time);
            p.setSenior(senior);
            p.setPax(pax);
            
            rs.addReservation(p);
            mess.setText("The reservation information has been confirmed");
            btnSubmit.setDisable(true);
        }catch(SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
}
