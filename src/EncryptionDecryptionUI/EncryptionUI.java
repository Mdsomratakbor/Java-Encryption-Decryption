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

public class EncryptionUI extends JFrame {
    //declare variable
    private JPanel contentPane;
    public EncryptionUI() throws Exception //constructor
    {


        IEncryptionService ed =new EncryptionService();
        setResizable(false);
        setTitle("Encryption");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(130,50, 600,600);
        getContentPane().setBackground(Color.CYAN);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel encryptionKey, encryptionValue, encryptionResult;
        JButton btnProcess, btnClose;
        JTextField txtEncryptionKey, textEncryptionValue;
        JTextArea textAreaEncryptionResult;


        encryptionKey  = new JLabel("Encryption Key : ");
        encryptionKey.setBounds(75, 100, 150, 32);
        encryptionKey.setForeground(Color.pink);
        encryptionKey.setOpaque(true);
        encryptionKey.setFont(new Font("Serif", Font.BOLD, 16));

        encryptionValue  = new JLabel("Encryption Value : ");
        encryptionValue.setBounds(75, 140, 150, 32);
        encryptionValue.setForeground(Color.pink);
        encryptionValue.setOpaque(true);
        encryptionValue.setFont(new Font("Serif", Font.BOLD, 16));

        encryptionResult  = new JLabel("Encryption Result : ");
        encryptionResult.setBounds(75, 230, 150, 32);
        encryptionResult.setForeground(Color.pink);
        encryptionResult.setOpaque(true);
        encryptionResult.setFont(new Font("Serif", Font.BOLD, 16));

        txtEncryptionKey=new JTextField();
        txtEncryptionKey.setBounds(205, 100, 300, 32);

        textEncryptionValue=new JTextField();
        textEncryptionValue.setBounds(205, 140, 300, 32);

        textAreaEncryptionResult = new JTextArea();
        textAreaEncryptionResult.setLineWrap(true);
        textAreaEncryptionResult.setBounds(205, 230, 300, 150);




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
                    if(txtEncryptionKey.getText().equals("")){
                        MessageUI message = new MessageUI("Please provide a key for encryption");
                        message.setVisible(true);
                    }
                    else if(txtEncryptionKey.getText().length()<=10){
                        MessageUI message = new MessageUI("Key length must be grater then or equals to 10 characters");
                        message.setVisible(true);
                    }
                    else if(textEncryptionValue.getText().equals("")){
                        MessageUI message = new MessageUI("Please provide a value for encryption");
                        message.setVisible(true);
                    }

                    else{
                        textAreaEncryptionResult.setText(ed.encrypt(textEncryptionValue.getText(), txtEncryptionKey.getText() )) ;
                    }

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

        contentPane.add(encryptionKey);
        contentPane.add(encryptionValue);
        contentPane.add(encryptionResult);


        contentPane.add(btnProcess);
        contentPane.add(btnClose);



        contentPane.add(txtEncryptionKey);
        contentPane.add(textEncryptionValue);
        contentPane.add(textAreaEncryptionResult);












    }
//

}
