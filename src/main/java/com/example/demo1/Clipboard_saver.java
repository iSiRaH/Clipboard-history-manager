package com.example.demo1;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;

import com.example.demo1.Services.ClipboardDatabase;
import javafx.application.Platform;
import javafx.collections.ObservableList;


public class Clipboard_saver implements Runnable {
    private final ObservableList<String> clipboardItems;
    private final ClipboardDatabase db = new ClipboardDatabase();

    public Clipboard_saver(ObservableList<String> clipboardItems) {
        this.clipboardItems = clipboardItems;
    }

    // ... constructor ...

    @Override
    public void run() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String lastText = "";

        while (true) {
            try {
                String currentText = (String) clipboard.getData(DataFlavor.stringFlavor);
                if (!currentText.equals(lastText)) {
                    lastText = currentText;
                    db.insertClipboarditem(currentText); // Save to DB
                    Platform.runLater(() -> clipboardItems.add(0, currentText));
                }
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}