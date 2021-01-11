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

        private JButton main_buttonClient;
        private JButton main_buttonServer;

    public MainUI() {
        // Creating window setting it up
        super("VPN");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setVisible(true);

        // Defining the buttons
        main_buttonClient = new JButton("Client");
        main_buttonServer = new JButton("Server");

        main_buttonClient.addActionListener(this);
        main_buttonServer.addActionListener(this);

        this.add(main_buttonClient);
        this.add(main_buttonServer);
        displayClient();
    }
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == main_buttonClient) displayClient();
        if (event.getSource() == main_buttonServer) displayClient();
    }
    private void displayClient() {
        SwingUtilities.invokeLater(() -> new ClientUI());
    }
    private void displayServer() {
        SwingUtilities.invokeLater(() -> new ServerUI());
    }
    }
}
