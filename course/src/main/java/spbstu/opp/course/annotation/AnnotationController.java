package spbstu.opp.course.annotation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import spbstu.opp.course.helper.TextAreaLogger;

public class AnnotationController {
    @FXML private TextArea logArea;

    private ExampleClass exampleClass;
    private TextAreaLogger logger;

    @FXML
    public void initialize() {
        logger = new TextAreaLogger(logArea);
        exampleClass = new ExampleClass(logger);
    }

    public void onStart(ActionEvent actionEvent) {
        RepeatRunner.run(exampleClass);
    }

    public void onClear(ActionEvent actionEvent) {
        logger.clear();
    }
}
