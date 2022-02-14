module com.example.authorizationjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.authorizationjavafx to javafx.fxml;
    exports com.example.authorizationjavafx;
}