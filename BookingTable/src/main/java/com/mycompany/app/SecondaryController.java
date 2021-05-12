package com.mycompany.app;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import pojo.Branch;
import pojo.Pax;
import pojo.TimeR;
import service.JdbcUtils;
import service.PaxService;
import com.mycompany.app.PrimaryController;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import pojo.Baby;
import pojo.Reservation;
import pojo.Senior;
import service.BabyService;
import service.ReservationService;
import service.SeniorService;
    
public class SecondaryController  implements Initializable {
    
    @FXML
    public TextField Branchs;
    
    @FXML
    public TextField Paxs;
    
    @FXML
    private ComboBox <Baby> baby;
    
    @FXML
    private ComboBox <Senior> senior;
    
    @FXML
    public TextField Times;
    @FXML
    public TextField date;
    @FXML
    public TextField fName;
    @FXML
    public TextField lName;
    @FXML
    public TextField phone;
    @FXML
    public TextField mail;
    @FXML
    public TextArea require;
    @FXML
    private Label mess;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnNext;
    @FXML
    public Label  check;
    @FXML
    private Label invalid;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        try {
            Connection conn = JdbcUtils.getConn();
            FXMLLoader mainLoad = new FXMLLoader(getClass().getResource("primary.fxml"));
            Parent mainRoot = (Parent) mainLoad.load();
            PrimaryController controller = mainLoad.getController();
           
            //this.Paxs.setText((String) controller.getPax().toString());
            // String abc = pri.cbPaxs.getSelectionModel().getSelectedItem().toString();
//            System.out.println(abc);
            // this.Paxs.setText(pri.cbPaxs.getSelectionModel().getSelectedItem().toString());
            // this.Times.setText(pri.cbTimes.getSelectionModel().getSelectedItem().toString());
            // this.date.setText(pri.cbdate.getValue().toString());
            // this.Paxs.setText(pri.getPax());
            this.Paxs.setEditable(false);
            this.Times.setEditable(false);
            this.date.setEditable(false);
            BabyService b = new BabyService(conn);
            SeniorService e = new SeniorService(conn);
            this.baby.setItems(FXCollections.observableArrayList(b.getPax()));
            this.senior.setItems(FXCollections.observableArrayList(e.getPax()));
            conn.close();
            
       } catch (SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public void checkPax(int b, int s){
        b = Integer.parseInt(this.baby.getSelectionModel().getSelectedItem().toString());
        s = Integer.parseInt(this.senior.getSelectionModel().getSelectedItem().toString());
       int pax = Integer.parseInt(this.Paxs.getText());
       if(b+s > pax || s==0){
           this.baby.setStyle("-fx-border-color: red; ");
           this.senior.setStyle("-fx-border-color: red; ");
           this.invalid.setText("Invalid value");
       }
   }
   public void nextButton() throws IOException{
       btnNext.setOnAction(e->{
           try {
                int b = Integer.parseInt(this.baby.getSelectionModel().getSelectedItem().toString());
                int s = Integer.parseInt(this.senior.getSelectionModel().getSelectedItem().toString());
               checkPax(b, s);
               if(this.fName.getText()!=null || this.lName.getText()!=null
                       || this.phone.getText()!=null || this.mail.getText()!=null){
                   if(checkPhone()== false){
                       setWindow();
                   }else{
                       mess.setText("Phone number is available");
                   }
                   
               }else{
                   mess.setText("Please complete all fields");
               }
               
           } catch (IOException | SQLException | ParseException ex) {
               Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
   }
   

   public void setWindow() throws IOException{
        FXMLLoader mainLoad = new FXMLLoader(getClass().getResource("SUBMIT.fxml"));
        Parent mainRoot = (Parent) mainLoad.load();
        SUBMITController sub = mainLoad.getController();
        String textBaby = this.baby.getSelectionModel().getSelectedItem().toString();
        String textSenior = this.senior.getSelectionModel().getSelectedItem().toString();
        String textDate = this.date.getText();
        String textTime = this.Times.getText();
        String textFName = this.fName.getText();
        String textLName = this.lName.getText();
        String textPhone = this.phone.getText();
        String textEmail = this.mail.getText();
        String textRequire = this.require.getText();
        String textPax = this.Paxs.getText();
        String textBranch = this.check.getText();
        
        sub.Paxs.setText(textPax);
        sub.baby.setText(textBaby);
        sub.senior.setText(textSenior);
        sub.Times.setText(textTime);
        sub.date.setText(textDate);
        sub.Name.setText(textFName+" "+textLName);
        sub.mail.setText(textEmail);
        sub.phone.setText(textPhone);
        sub.require.setText(textRequire);
        sub.Branchs.setText(textBranch);
        
        Stage stage = new Stage();
        Scene scene = new Scene(mainRoot, 912, 611);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
      
  }
   public boolean checkPhone() throws SQLException, ParseException{
       boolean result = false;
       try{
           Connection conn = JdbcUtils.getConn();
       
            ReservationService rs = new ReservationService(conn);
            Date d;
            d = java.sql.Date.valueOf(LocalDate.parse(this.date.getText()));
            Reservation c = rs.getReservationByPhoneNumber(this.phone.getText(), (Date) d, this.check.getText());
            if(c!=null){
                result = true;
            }
        }catch(SQLException ex){
                Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
       return result;
   }
   
   
}