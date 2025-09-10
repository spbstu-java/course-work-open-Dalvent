package spbstu.opp.course.stratagy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import spbstu.opp.course.helper.TextAreaLogger;

public class StrategyController {
    @FXML private Label heroNameText;
    @FXML private Label currentLocationText;
    @FXML private TextField targetLocationField;
    @FXML private ComboBox<String> movementModeComboBox;
    @FXML private TextArea logArea;

    private Hero hero;
    private TextAreaLogger logger;

    @FXML
    public void initialize() {
        logger = new TextAreaLogger(logArea);
        hero = new Hero(logger, "Alex", "Home");

        movementModeComboBox.getItems().addAll(
                "None",
                WalkHeroMovement.NAME,
                HorseHeroMovement.NAME,
                FlyHeroMovement.NAME
        );
        movementModeComboBox.getSelectionModel().select(0);
        heroNameText.setText("Current Location: " + hero.getHeroName());
        currentLocationText.setText("Current Location: " + hero.getCurrentLocation());
    }

    public void onGo(ActionEvent actionEvent) {
        String target = targetLocationField.getText();
        if (target == null || target.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Target location is empty!");
            alert.setHeaderText(null);
            alert.setContentText("Please, write location for hero to move on");
            alert.showAndWait();
            return;
        }

        hero.move(target);

        currentLocationText.setText("Current Location: " + hero.getCurrentLocation());
        targetLocationField.setText("");
    }

    public void onMovementChanged(ActionEvent actionEvent) {
        String name = movementModeComboBox.getSelectionModel().getSelectedItem();
        hero.setMovement(nameToMovement(name));
    }

    private HeroMovement nameToMovement(String name) {
        return switch (name) {
            case WalkHeroMovement.NAME -> new WalkHeroMovement();
            case HorseHeroMovement.NAME -> new HorseHeroMovement();
            case FlyHeroMovement.NAME -> new FlyHeroMovement();
            default -> null;
        };
    }

    public void onClear(ActionEvent actionEvent) {
        logger.clear();
    }
}
