module com.example.hacktheterminal {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.hacktheterminal to javafx.fxml;
    exports com.example.hacktheterminal;


    exports Controlador;
    opens Controlador to javafx.fxml;

    exports Model;
    opens Model to javafx.fxml;
}