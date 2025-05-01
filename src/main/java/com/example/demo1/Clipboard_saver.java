package com.example.demo1;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;

public class Clipboard_saver {
    //check constantly if any text copied to the clipboard and  if so print it
    public static void main(String[] args) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String lastText = "";

        while (true) {
            try {
                String currentText = (String) clipboard.getData(DataFlavor.stringFlavor);
                if (!currentText.equals(lastText)) {
                    System.out.println("Copied text: " + currentText);
                    lastText = currentText;
                }
                Thread.sleep(1000); // Check every second
            } catch (Exception e) {
                e.printStackTrace();
                //create gui
            }
        }
    }

}
