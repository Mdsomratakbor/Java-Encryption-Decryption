package EncryptionDecryptionUI;

import EncryptionDecryptionServices.EncryptionService;
import EncryptionDecryptionServices.IEncryptionService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MessageUI extends JFrame
{

    //declare variable
    private JPanel contentPane;
    public MessageUI(String message) throws Exception //constructor
    {
        setAlwaysOnTop(true);
        setResizable(false);
        setTitle("Message");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(130,50, 500,550);
        getContentPane().setBackground(Color.CYAN);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JTextArea messageBox;



        messageBox = new JTextArea();
        messageBox.setDisabledTextColor(Color.gray);
        messageBox.setEditable(false);
        messageBox.setLineWrap(true);
        messageBox.setOpaque(true);
        messageBox.setText(message);
        messageBox.setBounds(0, 0, 500, 350);




        JButton btnClose;
        btnClose = new JButton("Close");
        btnClose.setBackground(Color.red);
        btnClose.setForeground(Color.white);
        btnClose.setFont(new Font("Serif", Font.BOLD, 20));
        btnClose.setBounds(200,370,120, 32);
        btnClose.setOpaque(true);
        btnClose.setBorder(BorderFactory.createLineBorder(Color.white));







        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        btnClose.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent evt)
            {
                btnClose.setBackground(Color.YELLOW);
                btnClose.setBorder(BorderFactory.createLineBorder(Color.white));
            }
            public void mouseExited(MouseEvent evt)
            {
                btnClose.setBackground(Color.BLUE);
            }
        });




        contentPane.add(btnClose);

        contentPane.add(messageBox);












    }


}
