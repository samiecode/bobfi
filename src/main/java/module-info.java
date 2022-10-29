module com.bobfi.bobfi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires commons.validator;
    requires mysql.connector.java;


    opens com.bobfi.bobfi to javafx.fxml;
    exports com.bobfi.bobfi;
    exports com.bobfi.bobfi.controller;
    opens com.bobfi.bobfi.controller to javafx.fxml;
    exports com.bobfi.bobfi.db;
    opens com.bobfi.bobfi.db to javafx.fxml;
}