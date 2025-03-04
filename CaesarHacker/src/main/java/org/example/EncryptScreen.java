package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncryptScreen implements ActionListener {

    JFrame frame;
    JTextField keyTextField;
    JTextField messageTextField;
    JButton encryptButton;
    Font font;
    DecryptScreen decryptScreen;

    EncryptScreen() {
        frame = new JFrame("Encrypt");
        font = new Font("Arial", Font.PLAIN, 24);
        keyTextField = createTextField();
        messageTextField = createTextField();
        encryptButton = createButton("Encrypt");
        decryptScreen = new DecryptScreen();
    }

    public void start() {
        JPanel upperPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        upperPanel.add(new JLabel("Key"));
        upperPanel.add(keyTextField);

        JPanel lowerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        lowerPanel.add(new JLabel("Message"));
        lowerPanel.add(messageTextField);

        frame.add(upperPanel);
        frame.add(lowerPanel);
        frame.add(encryptButton);

        frame.setLayout(new GridLayout(3, 1));
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.addActionListener(this);
        return button;
    }

    public JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setFont(font);
        textField.setPreferredSize(new Dimension(200, 50));
        return textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String key = keyTextField.getText().trim();
        String message = messageTextField.getText().trim();
        String cipherText = decryptScreen.encrypt(message, Integer.parseInt(key));
        System.out.println("Key: " + key);
        System.out.println("Message: " + message);
        System.out.println("Cipher: " + cipherText);
        JOptionPane.showMessageDialog(frame, "Encrypted message: " + cipherText, "Encryption Result", JOptionPane.INFORMATION_MESSAGE);
    }
}
