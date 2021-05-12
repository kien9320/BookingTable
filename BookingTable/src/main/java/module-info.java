module com.mycompany.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    
    
    opens com.mycompany.app to javafx.fxml;
    exports com.mycompany.app;
    exports pojo;
}
