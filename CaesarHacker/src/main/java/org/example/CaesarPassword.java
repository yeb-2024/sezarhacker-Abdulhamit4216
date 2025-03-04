package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaesarPassword implements ActionListener {
    JFrame frame;
    JPanel panel;
    JLabel mainLabel, subLabel;
    JTextField inputField, secondInputField;
    JButton encryptButton, decryptButton;
    Font font;

    CaesarPassword() {
        frame = new JFrame("Home Page");
        mainLabel = new JLabel("Caesar Cipher Method");
        font = new Font("Arial", Font.PLAIN, 24);
        encryptButton = createButton("Encrypt");
        decryptButton = createButton("Decrypt");
        panel = new JPanel();
    }

    public void start() {
        frame.setLayout(new GridLayout(2, 1));
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainLabel);

        panel.setLayout(new FlowLayout());
        panel.add(encryptButton);
        panel.add(decryptButton);

        mainLabel.setHorizontalAlignment(JLabel.CENTER);
        mainLabel.setVerticalAlignment(JLabel.CENTER);
        mainLabel.setFont(font);

        frame.add(panel);
        frame.setVisible(true);
    }

    public JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == encryptButton) {
            EncryptScreen encryptScreen = new EncryptScreen();
            encryptScreen.start();
            frame.dispose();
        }
        if (e.getSource() == decryptButton) {
            DecryptEncryption decryptEncryption = new DecryptEncryption();
            decryptEncryption.start();
            frame.dispose();
        }
    }
}
