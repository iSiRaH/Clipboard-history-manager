module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires java.desktop;
    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;
    exports com.example.demo1.Services;
    opens com.example.demo1.Services to javafx.fxml;
    exports com.example.demo1.Controllers;
    opens com.example.demo1.Controllers to javafx.fxml;
}