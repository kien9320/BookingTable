/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.sql.Date;
import java.sql.Time;


/**
 *
 * @author Admin
 */
public class Reservation {
    int id;
    int pax;
    int baby;
    int senior;
    Date date;
    String time;
    String note;
    String customer_Name;
    String customer_phone;
    String customer_email;
    String branch_name;

    public Reservation(){
        
    }

    public int getSenior() {
        return senior;
    }

    public void setSenior(int senior) {
        this.senior = senior;
    }

    public String getCustomer_Name() {
        return customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        this.customer_Name = customer_Name;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPax() {
        return pax;
    }

    public void setPax(int pax) {
        this.pax = pax;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public int getBaby() {
        return baby;
    }

    public void setBaby(int baby) {
        this.baby = baby;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", pax=" + pax + ", baby=" + baby + ", senior=" + senior + ", date=" + date + ", time=" + time + ", note=" + note + ", customer_Name=" + customer_Name + ", customer_phone=" + customer_phone + ", customer_email=" + customer_email + ", branch_name=" + branch_name + '}';
    }

    
}
