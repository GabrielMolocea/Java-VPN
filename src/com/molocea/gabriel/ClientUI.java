package com.molocea.gabriel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClientUI extends JFrame implements ActionListener, GUIInterface {
    
    // Host 
    private JLabel m_labelHost;
    private TextField m_txtHost;
    
    // Port
    private JLabel m_labelPort;
    private TextField m_textPort;
    
    // Shared Key
    private JLabel m_labelSharedKey;
    private TextField m_txtSharedKey;
    
    // Start Stop
    private JButton m_buttonStart;
    private JButton m_buttonStop;

    // Data to be sent
    private JLabel m_labelInput;
    private TextField m_txtInput;
    private JButton m_buttonInput;

    // Data to be received
    private JLabel m_labelConsole;
    private JTextArea m_txtConsole;

    private ClientInterface m_crypt;

    public ClientUI() {
        super("Client");
        this.setSize(500,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.setVisible(true);

        // Host
        m_buttonStart = new JButton("Connect");
        m_buttonStop = new JButton("Disconnect");
        m_buttonStop.setEnabled(false);
        m_buttonStart.addActionListener(this);
        m_buttonStop.addActionListener(this);

        // Data to be sent

    }
}
