package spbstu.opp.course.translator;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class TranslatorController {
    private static final String VOCABULARY_IS_NOT_LOADED = "Vocabulary is not loaded";

    public Label vocabularyStatus;
    public TextArea inputText;
    public TextArea translatedArea;

    private VocabularyBankFile vocabularyFile = new VocabularyBankFile();

    public void onChooseVocabulary(ActionEvent actionEvent) {
        vocabularyStatus.setText(VOCABULARY_IS_NOT_LOADED);
        vocabularyFile.clear();

        var fc = new FileChooser();
        fc.setTitle("Choose vocabulary file");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", "*.txt", "*.*"));
        var window = inputText.getScene().getWindow();
        var file = fc.showOpenDialog(window);
        if (file == null)
            return;

        try {
            var path = file.toPath().toString();
            vocabularyFile.load(path);
            vocabularyStatus.setText(path);
        } catch (InvalidFileFormatException | FileReadException e) {
            showError(file, e);
        }
    }

    public void onReadFromFile(ActionEvent actionEvent) {
        var fc = new FileChooser();
        fc.setTitle("Choose text file to translate");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", "*.txt", "*.*"));
        var window = inputText.getScene().getWindow();
        var file = fc.showOpenDialog(window);

        if (file == null)
            return;

        try {
            var content = Files.readString(file.toPath(), StandardCharsets.UTF_8);
            inputText.setText(content);
        } catch (IOException e) {
            showError(file, e);
        }
    }

    public void onTranslate(ActionEvent actionEvent) {
        if (vocabularyFile.isEmpty()) {
            var alert = new Alert(Alert.AlertType.INFORMATION, "Can't translate without vocabulary file!");
            alert.showAndWait();
            return;
        }

        var translator = new TextTranslator(vocabularyFile, inputText.getText());
        translatedArea.setText(translator.translate());
    }

    private static void showError(File file, Exception e) {
        var alert = new Alert(
                Alert.AlertType.ERROR, "Can't read file " + file.getPath() + " " + e.getMessage()
        );
        alert.showAndWait();
    }
}
