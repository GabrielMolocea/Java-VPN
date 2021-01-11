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

    }
}
