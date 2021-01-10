package com.molocea.gabriel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainUI());
    }

    @SuppressWarnings("serial")
    public class MainUI extends JFrame implements ActionListener {

        private JButton main_btnClient;
        private JButton main_btnServer;

    public MainUI() {
        // Creating window setting it up
        super("VPN");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setVisible(true);

        // Defining the buttons
        main_btnClient = new JButton("Client");
        main_btnServer = new JButton("Server");

        main_btnClient.addActionListener(this);
        main_btnServer.addActionListener(this);

        this.add(main_btnClient);
        this.add(main_btnServer);
        displayClient();
    }
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == main_btnClient) displayClient();
        if (event.getSource() == main_btnServer) displayClient();
    }
    private void displayClient() {
        SwingUtilities.invokeLater(() -> new ClientUI());
    }
    private void displayServer() {
        SwingUtilities.invokeLater(() -> new ServerUI());
    }
    }
}
