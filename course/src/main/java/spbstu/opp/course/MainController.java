package spbstu.opp.course;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.StackPane;
import java.io.IOException;
import java.util.Objects;

public class MainController {
    @FXML private StackPane strategyView, annotationView, translatorView, streamApiView;

    @FXML
    public void initialize() {
        try {
            Node stratagyFmxl = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("strategy-view.fxml")));
            strategyView.getChildren().add(stratagyFmxl);

            Node annotationFxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("annotation-view.fxml")));
            annotationView.getChildren().add(annotationFxml);

            Node translatorFxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("translator-view.fxml")));
            translatorView.getChildren().add(translatorFxml);

            Node streamApiFxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("stream-api-view.fxml")));
            streamApiView.getChildren().add(streamApiFxml);
        } catch (IOException e) {
            System.err.println("Error while loading application" + ": " + e.getMessage());
            var alert = new Alert(
                    Alert.AlertType.ERROR, "Error while loading application" + "\n" + e.getMessage()
            );
            alert.showAndWait();
        }
    }

}