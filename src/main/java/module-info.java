module com.example.zaneviewcontrollerphotoapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zaneviewcontrollerphotoapp to javafx.fxml;
    exports com.example.zaneviewcontrollerphotoapp;
}