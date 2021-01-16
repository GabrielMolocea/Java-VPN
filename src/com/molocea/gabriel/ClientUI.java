package com.molocea.gabriel;

import com.sun.security.ntlm.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
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
        m_labelInput = new JLabel("Data to be Sent:");
        m_txtInput = new TextField();
        m_buttonInput = new JButton("Sent");
        m_txtInput.setEditable(false);
        m_buttonInput.setEnabled(false);
        m_buttonInput.addActionListener(this);

        // Data as Received
        m_labelConsole = new JLabel("Data as Received");
        m_txtConsole = new JTextArea();
        m_txtConsole.setEditable(false);
        JScrollPane txtConsoleScroll = new JScrollPane(m_txtConsole);

        // Host
        layout.putConstraint(SpringLayout.WEST, m_txtHost, 110, SpringLayout.WEST, this.getContentPane());
        layout.putConstraint(SpringLayout.EAST, m_txtHost, -5, SpringLayout.EAST, this.getContentPane());
        layout.putConstraint(SpringLayout.EAST, m_labelHost, -5, SpringLayout.WEST, m_txtHost);

        // Port
        layout.putConstraint(SpringLayout.WEST, m_textPort, 0, SpringLayout.WEST, m_txtHost);
        layout.putConstraint(SpringLayout.NORTH, m_textPort, 5, SpringLayout.SOUTH, m_txtHost);

        layout.putConstraint(SpringLayout.EAST, m_labelPort, -5, SpringLayout.WEST, m_textPort);
        layout.putConstraint(SpringLayout.NORTH, m_labelPort, 5, SpringLayout.SOUTH, m_txtHost);
        
        // Shared Key
        //Shared Key
        layout.putConstraint(SpringLayout.WEST, m_txtSharedKey, 0, SpringLayout.WEST, m_txtHost );
        layout.putConstraint(SpringLayout.NORTH, m_txtSharedKey, 5, SpringLayout.SOUTH, m_txtHost );
        layout.putConstraint(SpringLayout.EAST, m_txtSharedKey, -5, SpringLayout.EAST, this.getContentPane());

        layout.putConstraint(SpringLayout.EAST, m_labelSharedKey, -5, SpringLayout.WEST, m_txtHost );
        layout.putConstraint(SpringLayout.NORTH, m_labelSharedKey, 5, SpringLayout.SOUTH, m_txtHost );


        //Start / Stop
        layout.putConstraint(SpringLayout.NORTH, m_buttonStart, 5, SpringLayout.SOUTH, m_txtSharedKey);
        layout.putConstraint(SpringLayout.WEST, m_buttonStart, 0, SpringLayout.WEST, m_txtSharedKey);

        layout.putConstraint(SpringLayout.NORTH, m_buttonStop, 5, SpringLayout.SOUTH, m_txtSharedKey);
        layout.putConstraint(SpringLayout.WEST, m_buttonStop, 5, SpringLayout.EAST, m_buttonStart);

        //Data to be Sent
        layout.putConstraint(SpringLayout.WEST, m_txtInput, 0, SpringLayout.WEST, m_buttonStart );
        layout.putConstraint(SpringLayout.NORTH, m_txtInput, 5, SpringLayout.SOUTH, m_buttonStart );
        layout.putConstraint(SpringLayout.EAST, m_txtInput, -74, SpringLayout.EAST, this.getContentPane());

        layout.putConstraint(SpringLayout.EAST, m_labelInput, -5, SpringLayout.WEST, m_buttonStart);
        layout.putConstraint(SpringLayout.NORTH, m_labelInput, 5, SpringLayout.SOUTH, m_buttonStart );

        layout.putConstraint(SpringLayout.WEST, m_buttonInput, 5, SpringLayout.EAST, m_txtInput );
        layout.putConstraint(SpringLayout.NORTH, m_buttonInput, 5, SpringLayout.SOUTH, m_buttonStart );


        //Data as Received
        layout.putConstraint(SpringLayout.WEST, txtConsoleScroll, 0, SpringLayout.WEST, m_txtInput );
        layout.putConstraint(SpringLayout.NORTH, txtConsoleScroll, 5, SpringLayout.SOUTH, m_txtInput );
        layout.putConstraint(SpringLayout.SOUTH, txtConsoleScroll, -5, SpringLayout.SOUTH, this.getContentPane());
        layout.putConstraint(SpringLayout.EAST, txtConsoleScroll, -5, SpringLayout.EAST, this.getContentPane());

        layout.putConstraint(SpringLayout.EAST, m_labelConsole, -5, SpringLayout.WEST, txtConsoleScroll );
        layout.putConstraint(SpringLayout.NORTH, m_labelConsole, 5, SpringLayout.SOUTH, m_txtInput );

        //Host
        this.add(m_labelHost);
        this.add(m_txtHost);

        //Port
        this.add(m_labelPort);
        this.add(m_textPort);

        //Shared Key
        this.add(m_labelSharedKey);
        this.add(m_txtSharedKey);

        //Start / Stop
        this.add(m_buttonStart);
        this.add(m_buttonStop);

        //Data to be Sent
        this.add(m_labelInput);
        this.add(m_txtInput);
        this.add(m_buttonInput);

        //Data as Received
        this.add(m_labelConsole);
        this.add(txtConsoleScroll);

        m_crypt = new Client(this);
    }
}
