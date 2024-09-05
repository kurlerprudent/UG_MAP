module org.example.ui_design {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ui_design to javafx.fxml;
    exports org.example.ui_design;
}