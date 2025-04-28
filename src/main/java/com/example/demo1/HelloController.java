package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onClipboardButtonClick() {
        Clipboard_saver.main(null);
    }

    @FXML
    protected void onClipboardButtonClick2() {
        Clipboard_saver.main(null);
    }

    @FXML
    private TextField searchField;

    @FXML
    private ListView<String> clipboardListView;

    @FXML
    private Button copyButton;

    @FXML
    private Button deleteButton;
}