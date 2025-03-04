package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecryptEncryption implements ActionListener {

    JFrame frame;
    JTextField keyTextField;
    JTextField cipherTextField;
    JButton decryptButton;
    Font font;
    DecryptScreen decryptScreen;

    DecryptEncryption() {
        frame = new JFrame("Decrypt");
        font = new Font("Arial", Font.PLAIN, 24);
        keyTextField = createTextField();
        cipherTextField = createTextField();
        decryptButton = createButton("Decrypt");
        decryptScreen = new DecryptScreen();
    }

    public void start() {
        JPanel upperPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        upperPanel.add(new JLabel("Key"));
        upperPanel.add(keyTextField);

        JPanel lowerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        lowerPanel.add(new JLabel("Cipher"));
        lowerPanel.add(cipherTextField);

        frame.add(upperPanel);
        frame.add(lowerPanel);
        frame.add(decryptButton);

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
        String cipherText = cipherTextField.getText().trim();
        String message = decryptScreen.decrypt(cipherText, Integer.parseInt(key));
        System.out.println("Key: " + key);
        System.out.println("Cipher: " + cipherText);
        System.out.println("Message: " + message);
        JOptionPane.showMessageDialog(frame, "Decrypted message: " + message, "Decryption Result", JOptionPane.INFORMATION_MESSAGE);
    }
}
