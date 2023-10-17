module com.endasssignment.javaendassignmentt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.endasssignment.javaendassignment to javafx.fxml;
    exports com.endasssignment.javaendassignment;
    exports com.endasssignment.javaendassignment.Controller;
    opens com.endasssignment.javaendassignment.Controller to javafx.fxml;
    exports com.endasssignment.javaendassignment.Database;
    opens com.endasssignment.javaendassignment.Database to javafx.fxml;
    exports com.endasssignment.javaendassignment.Model;
    opens com.endasssignment.javaendassignment.Model to javafx.fxml;
    exports com.endasssignment.javaendassignment.Service;
    opens com.endasssignment.javaendassignment.Service to javafx.fxml;
}