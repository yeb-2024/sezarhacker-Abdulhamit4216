package org.example;

import javax.swing.*;

public class BruteForceDecrypt {

    public static void decrypt(String cipherText, JFrame frame) {
        String SYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String allResults = "";

        for (int key = 0; key < SYMBOLS.length(); key++) {
            String decryptedText = "";
            for (int i = 0; i < cipherText.length(); i++) {
                char c = cipherText.charAt(i);
                if (SYMBOLS.indexOf(c) != -1) {
                    int newIndex = (SYMBOLS.indexOf(c) - key + SYMBOLS.length()) % SYMBOLS.length();
                    decryptedText += SYMBOLS.charAt(newIndex);
                } else {
                    decryptedText += c;
                }
            }
            String result = "Anahtar #" + key + ": " + decryptedText;
            allResults += result + "\n";
        }
        JOptionPane.showMessageDialog(frame, allResults, "Şifreleme Sonucu", JOptionPane.INFORMATION_MESSAGE);
    }
}
