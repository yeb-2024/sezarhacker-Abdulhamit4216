package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BruteForceScreen implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JTextField cipherTextField;
    private JButton startButton;
    private Font font;

    public BruteForceScreen() {
        frame = new JFrame("Brute-Force Şifre Çözme");
        panel = new JPanel(new GridLayout(3, 1, 10, 10));
        font = new Font("Arial", Font.PLAIN, 18);
        cipherTextField = new JTextField();
        startButton = new JButton("Şifreyi Çöz");

        cipherTextField.setFont(font);
        cipherTextField.setPreferredSize(new Dimension(300, 30));
        startButton.setFont(font);
        startButton.addActionListener(this);
    }

    public void basla() {
        panel.add(new JLabel("Şifreli Metni Girin:"));
        panel.add(cipherTextField);
        panel.add(startButton);

        frame.add(panel);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cipherText = cipherTextField.getText().toUpperCase();
        BruteForceDecrypt.decrypt(cipherText, frame);
    }
}
