module spbstu.opp.course {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens spbstu.opp.course to javafx.fxml;
    opens spbstu.opp.course.stratagy to javafx.fxml;
    opens spbstu.opp.course.annotation to javafx.fxml;
    opens spbstu.opp.course.translator to javafx.fxml;
    opens spbstu.opp.course.stream_api to javafx.fxml;
    exports spbstu.opp.course;
}