package org.example;

import javax.swing.*;

public class DecryptScreen {

    JFrame frame;
    JPanel panel;
    String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encrypt(String message, int key) {
        int messageLength = message.length();
        String result = "";

        for (int i = 0; i < messageLength; i++) {
            char character = message.charAt(i);
            if (character == ' ') {
                result += " ";
                continue;
            }
            char upperChar = Character.toUpperCase(character);
            int index = symbols.indexOf(upperChar);
            int newIndex = (index + key) % symbols.length();
            char newChar = symbols.charAt(newIndex);
            result += newChar;
        }
        return result;
    }

    public String decrypt(String cipherText, int key) {
        int messageLength = cipherText.length();
        String result = "";

        for (int i = 0; i < messageLength; i++) {
            char character = cipherText.charAt(i);
            if (character == ' ') {
                result += " ";
                continue;
            }
            char upperChar = Character.toUpperCase(character);
            int index = symbols.indexOf(upperChar);
            int newIndex = ((index - key) + symbols.length()) % symbols.length();
            char newChar = symbols.charAt(newIndex);
            result += newChar;
        }

        return result;
    }
}
