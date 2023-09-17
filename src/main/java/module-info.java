module com.example.myfirstgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.myfirstgame to javafx.fxml;
    exports com.example.myfirstgame;
}