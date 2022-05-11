package EncryptionDecryptionUI;

import EncryptionDecryptionServices.DecryptionService;
import EncryptionDecryptionServices.EncryptionService;
import EncryptionDecryptionServices.IDecryptionService;
import EncryptionDecryptionServices.IEncryptionService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DecryptionUI extends JFrame {
    //declare variable
    private JPanel contentPane;
    public DecryptionUI() throws Exception //constructor
    {


        IDecryptionService decryption =new DecryptionService();
        setResizable(false);
        setTitle("Decryption");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(130,50, 600,600);
        getContentPane().setBackground(Color.CYAN);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel decryptionKey, decryptionValue, decryptionResult;
        JButton btnProcess, btnClose;
        JTextField txtDecryptionKey, textDecryptionValue;
        JTextArea textAreaDecryptionResult;


        decryptionKey  = new JLabel("Decryption Key : ");
        decryptionKey.setBounds(75, 100, 150, 32);
        decryptionKey.setForeground(Color.pink);
        decryptionKey.setOpaque(true);
        decryptionKey.setFont(new Font("Serif", Font.BOLD, 16));

        decryptionValue  = new JLabel("Decryption Value : ");
        decryptionValue.setBounds(75, 140, 150, 32);
        decryptionValue.setForeground(Color.pink);
        decryptionValue.setOpaque(true);
        decryptionValue.setFont(new Font("Serif", Font.BOLD, 16));

        decryptionResult  = new JLabel("Decryption Result : ");
        decryptionResult.setBounds(75, 230, 150, 32);
        decryptionResult.setForeground(Color.pink);
        decryptionResult.setOpaque(true);
        decryptionResult.setFont(new Font("Serif", Font.BOLD, 16));

        txtDecryptionKey=new JTextField();
        txtDecryptionKey.setBounds(205, 100, 300, 32);

        textDecryptionValue=new JTextField();
        textDecryptionValue.setBounds(205, 140, 300, 32);

        textAreaDecryptionResult = new JTextArea();
        textAreaDecryptionResult.setBounds(205, 230, 300, 150);




        btnProcess = new JButton("Process");
        btnProcess.setBackground(Color.BLUE);
        btnProcess.setForeground(Color.white);
        btnProcess.setFont(new Font("Serif", Font.BOLD, 20));
        btnProcess.setBounds(220,180,120, 32);
        btnProcess.setOpaque(true);
        btnProcess.setBorder(BorderFactory.createLineBorder(Color.white));



        btnClose = new JButton("Close");
        btnClose.setBackground(Color.red);
        btnClose.setForeground(Color.white);
        btnClose.setFont(new Font("Serif", Font.BOLD, 20));
        btnClose.setBounds(220,400,120, 32);
        btnClose.setOpaque(true);
        btnClose.setBorder(BorderFactory.createLineBorder(Color.white));


        btnProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(txtDecryptionKey.getText().equals("")){
                        MessageUI message = new MessageUI("Please provide a key for decryption");
                        message.setVisible(true);
                    }
                    else if(txtDecryptionKey.getText().length()<=10){
                        MessageUI message = new MessageUI("Key length must be grater then or equals to 10 characters");
                        message.setVisible(true);
                    }
                    else if(textDecryptionValue.getText().equals("")){
                        MessageUI message = new MessageUI("Please provide a value for decryption");
                        message.setVisible(true);
                    }
                    textAreaDecryptionResult.setText(decryption.Decrypt(textDecryptionValue.getText(), txtDecryptionKey.getText() )) ;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        btnProcess.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent evt)
            {
                btnProcess.setBackground(Color.pink);
                btnProcess.setBorder(BorderFactory.createLineBorder(Color.white));
            }
            public void mouseExited(MouseEvent evt)
            {
                btnProcess.setBackground(Color.BLUE);
            }
        });



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

        contentPane.add(decryptionKey);
        contentPane.add(decryptionValue);
        contentPane.add(decryptionResult);


        contentPane.add(btnProcess);
        contentPane.add(btnClose);



        contentPane.add(txtDecryptionKey);
        contentPane.add(textDecryptionValue);
        contentPane.add(textAreaDecryptionResult);


    }


}
