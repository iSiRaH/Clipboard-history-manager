package com.example.demo1.Controllers;

import com.example.demo1.Clipboard_saver;
import com.example.demo1.Services.ClipboardDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField searchField;

    @FXML
    private ListView<String> clipboardListView;

    @FXML
    private Button copyButton;

    @FXML
    private Button deleteButton;

    private ObservableList<String> clipboardItems;

    @FXML
    public void initialize() {
        clipboardItems = FXCollections.observableArrayList();
        clipboardListView.setItems(clipboardItems);

        // Start clipboard monitoring in a new thread
        Thread clipboardThread = new Thread(new Clipboard_saver(clipboardItems));
        clipboardThread.setDaemon(true);
        clipboardThread.start();

        copyButton.setOnAction(event -> onInsert());

    }

    private void onInsert() {
        String str = searchField.getText();
        ClipboardDatabase clipboardDatabase = new ClipboardDatabase();
        try {
            clipboardDatabase.insertClipboarditem(str);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void onDeleteButtonClick() {
        String selectedItem = clipboardListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            clipboardItems.remove(selectedItem);
        }
    }
}