package com.mycompany.app;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pojo.Branch;
import pojo.Pax;
import pojo.TimeR;
import service.BranchService;
import service.JdbcUtils;
import service.PaxService;
import service.ReservationService;
import service.TimeService;

public class PrimaryController implements Initializable {
   
    @FXML
    private ComboBox <Branch> cbBranchs;
    
    
    @FXML
    public ComboBox<Pax>  cbPaxs;
    
    @FXML
    private Button btnSearch;
    
    @FXML
    public ComboBox <TimeR> cbTimes;
    
    @FXML
    private Label  mess;
   
    
    @FXML
    public DatePicker cbdate;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection conn = JdbcUtils.getConn();
            BranchService s = new BranchService(conn);
            PaxService p = new PaxService(conn);
            TimeService t = new TimeService(conn);
            
            this.cbTimes.setItems(FXCollections.observableArrayList(t.getTime()));
            
            this.cbPaxs.setItems(FXCollections.observableArrayList(p.getPax()));
            
            this.cbBranchs.setItems(FXCollections.observableArrayList(s.getBr()));
            
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        
    }
    
    
    public void Search(ActionEvent event) throws IOException  {
        try{
            
            int sl = Integer.parseInt(this.cbPaxs.getSelectionModel().getSelectedItem().toString());
            String name = this.cbBranchs.getSelectionModel().getSelectedItem().toString();
            Date d = java.sql.Date.valueOf(LocalDate.parse(this.cbdate.getValue().toString()));
            LocalDate now = LocalDate.now ();  
            Date n = java.sql.Date.valueOf(now);
 
            Connection conn = JdbcUtils.getConn();
            ReservationService rs = new ReservationService(conn);
            int sum = rs.CountPaxByBranchAndDate(name, d);
            if(d.compareTo(n)==-1){
                mess.setText("Ngay khong hop le. Vui long nhap lai");
            }else{
                if(this.cbBranchs.getValue()!= null && this.cbPaxs.getValue()!= null && this.cbTimes.getValue()!= null && this.cbdate.getValue()!= null){

                    if(sl+sum <= 30){
                       // Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                       // FXMLLoader loader = new FXMLLoader();
                       // loader.setLocation(getClass().getResource("secondary.fxml"));
                       // Parent sampleParent = loader.load();
                       // Scene scene = new Scene(sampleParent);
                       // stage.setScene(scene);
                       setWindow();
                       mess.setText("");

                    }else{

                        mess.setText("Full reservation at this branch");
                    }
                }else{
                    mess.setText("Please complete all fields");
                    this.btnSearch.setDisable(true);
                }
            }
            
        }catch( SQLException ex){
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public void setWindow() throws IOException{
        FXMLLoader mainLoad = new FXMLLoader(getClass().getResource("secondary.fxml"));
        Parent mainRoot = (Parent) mainLoad.load();
        SecondaryController sec = mainLoad.getController();
        String textPax = this.cbPaxs.getSelectionModel().getSelectedItem().toString();
        String textTime = this.cbTimes.getSelectionModel().getSelectedItem().toString();
        String textDate = this.cbdate.getValue().toString();
        String textBranch = this.cbBranchs.getSelectionModel().getSelectedItem().toString();

        sec.Paxs.setText(textPax);
        sec.Times.setText(textTime);
        sec.date.setText(textDate);
        sec.check.setText(textBranch);
        Stage stage = new Stage();
        Scene scene = new Scene(mainRoot, 912, 611);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
    public void hideWindow() throws IOException{
        FXMLLoader mainLoad = new FXMLLoader(getClass().getResource("primary.fxml"));
        Parent mainRoot = (Parent) mainLoad.load();
        Stage stage = new Stage();
        Scene scene = new Scene(mainRoot);
        stage.setScene(scene);
    }
    
    private void setupDate(){
        Date now = (Date) new java.util.Date(); 
        
        Date d = java.sql.Date.valueOf(LocalDate.parse(this.cbdate.getValue().toString()));
        if(d.compareTo(now)==-1){
            mess.setText("Invalid date. Please try again! ");
            this.btnSearch.setDisable(true);
            
        }
    }

}
