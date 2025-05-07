package com.example.demo1;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import javafx.application.Platform;
import javafx.collections.ObservableList;

public class Clipboard_saver implements Runnable {
    private final ObservableList<String> clipboardItems;

    public Clipboard_saver(ObservableList<String> clipboardItems) {
        this.clipboardItems = clipboardItems;
    }

    @Override
    public void run() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String lastText = "";

        while (true) {
            try {
                String currentText = (String) clipboard.getData(DataFlavor.stringFlavor);
                if (!currentText.equals(lastText)) {
                    lastText = currentText;
                    Platform.runLater(() -> clipboardItems.add(0, currentText)); // Update UI
                }
                Thread.sleep(1000); // Check every second
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}