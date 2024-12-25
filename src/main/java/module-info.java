module org.example.potoki4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires jakarta.jakartaee.web.api;
    requires spring.data.jpa;
    requires java.sql;



    opens org.example.potoki4 to javafx.fxml;
    exports org.example.potoki4;

}