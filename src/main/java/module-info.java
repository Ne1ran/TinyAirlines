module com.example.card_account {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.j;
    requires java.sql;


    opens com.example.tiny_airlines to javafx.fxml;
    opens com.example.tiny_airlines.models to javafx.base;
    exports com.example.tiny_airlines;
}