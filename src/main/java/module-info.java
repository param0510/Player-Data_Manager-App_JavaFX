module com.example.comp1008_assignment_2_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.comp1008_assignment_2_javafx to javafx.fxml;
    exports com.example.comp1008_assignment_2_javafx;
}