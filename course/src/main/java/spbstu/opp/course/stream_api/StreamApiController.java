package spbstu.opp.course.stream_api;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import spbstu.opp.course.helper.TextAreaLogger;

import java.util.Arrays;

public class StreamApiController {
    @FXML private TextArea inputArea;
    @FXML private ToggleGroup methodsGroup;
    @FXML private RadioButton averageRadio;
    @FXML private RadioButton newAndUppercaseRadio;
    @FXML private RadioButton uniqueSquaresRadio;
    @FXML private RadioButton lastRadio;
    @FXML private RadioButton sumEvenRadio;
    @FXML private RadioButton mapFirstCharRadio;

    @FXML private TextArea logArea;
    private TextAreaLogger logger;

    @FXML
    public void initialize() {
        logger = new TextAreaLogger(logArea);
        averageRadio.fire();
    }

    public void onRun(ActionEvent actionEvent) {
        String input = inputArea.getText();
        if (input == null || input.isBlank()) {
            logger.warn("Input is empty.");
            return;
        }

        RadioButton selected = (RadioButton) methodsGroup.getSelectedToggle();
        if (selected == null) {
            logger.warn("Input is empty.");
            return;
        }

        try {
            doSelectedOperation(selected, input);
        } catch (Exception e) {
            var alert = new Alert(
                    Alert.AlertType.ERROR, "Error on doing operation" + "\n" + e.getMessage()
            );
            alert.showAndWait();
        }
    }

    private void doSelectedOperation(RadioButton selected, String input) {
        if (isIntOperation(selected)) {
            var intValues = Arrays.stream(input.split("\\s+"))
                    .filter(s -> !s.isBlank())
                    .map(Integer::parseInt)
                    .toList();

            if (selected == averageRadio) {
                logger.log("Average " + ListHelper.average(intValues));
            } else if (selected == uniqueSquaresRadio) {
                logger.log("Unique Squares" + ListHelper.uniqueSquares(intValues));
            } else if (selected == sumEvenRadio) {
                logger.log("Sum Even " + ListHelper.sumEven(intValues));
            }
            return;
        }

        var stringValues = Arrays.stream(input.split("\\s+"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();

        if (selected == newAndUppercaseRadio) {
            logger.log("New and Upper radio: " + ListHelper.upperNew(stringValues));
        } else if (selected == lastRadio) {
            logger.log("Last: " + ListHelper.last(stringValues));
        } else if (selected == mapFirstCharRadio) {
            logger.log("map first char: " + ListHelper.mapByFirstChar(stringValues));
        }
    }

    public void onClear(ActionEvent actionEvent) {
        logger.clear();
    }

    private boolean isIntOperation(RadioButton selected) {
        return selected == averageRadio
                || selected == uniqueSquaresRadio
                || selected == sumEvenRadio;
    }
}

