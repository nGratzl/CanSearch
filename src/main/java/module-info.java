module your.module.name {
    requires javafx.controls;
    requires javafx.fxml;

    exports at.cansearch;
    // If you use FXML and controllers, you may also need:
    opens at.cansearch to javafx.fxml;
}