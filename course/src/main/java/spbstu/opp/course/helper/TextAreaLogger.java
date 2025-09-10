package spbstu.opp.course.helper;

import javafx.scene.control.TextArea;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TextAreaLogger {
    private final DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final TextArea textArea;

    public TextAreaLogger(TextArea textArea) {
        this.textArea = textArea;
        this.textArea.setEditable(false);
    }

    public void log(String message) {
        append("INFO", message);
    }

    public void warn(String message) {
        append("WARN", message);
    }

    public void error(String message) {
        append("ERROR", message);
    }

    private void append(String level, String message) {
        var timestamp = LocalTime.now().format(timeFormat);
        textArea.appendText(String.format("[%s] [%s] %s%n", timestamp, level, message));
    }

    public void clear() {
        textArea.clear();
    }
}
