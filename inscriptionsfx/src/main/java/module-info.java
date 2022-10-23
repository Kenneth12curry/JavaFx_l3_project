module ism.inscriptions {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires mysql.connector.java;
    requires java.sql;
   


    opens ism.inscriptions.controllers to javafx.fxml;
    exports ism.inscriptions;
    exports ism.inscriptions.entities;
}
