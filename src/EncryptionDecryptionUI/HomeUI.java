package EncryptionDecryptionUI;

import EncryptionDecryptionServices.EncryptionService;
import EncryptionDecryptionServices.IEncryptionService;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HomeUI {

    public static void main(String[] args)  {

        JFrame home=new JFrame();

        home.setTitle("Home");
        JLabel projectTitle;
        projectTitle=new JLabel("Encryption and Decryption Application");
        projectTitle.setBounds(130,50, 340,40);
        projectTitle.setBackground(Color.white);
        projectTitle.setForeground(Color.pink);
        projectTitle.setOpaque(true);
        projectTitle.setFont(new Font("Serif", Font.BOLD, 20));
        projectTitle.setHorizontalTextPosition(JLabel.CENTER);
        projectTitle.setVerticalTextPosition(JLabel.CENTER);
        home.add(projectTitle);


        JButton btnEncryption, btnDecryption;

        btnEncryption = new JButton("Encryption");
        btnDecryption = new JButton("Decryption");

        btnEncryption.setBackground(Color.lightGray);
        btnDecryption.setBackground(Color.lightGray);
        btnEncryption.setOpaque(true);


        btnEncryption.setBorder(BorderFactory.createLineBorder(Color.white));
        btnDecryption.setBorder(BorderFactory.createLineBorder(Color.white));


        btnEncryption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //call the object of NewWindow and set visible true
                EncryptionUI frame = null;
                try {

                    EncryptionUI encryptionForm = new EncryptionUI();


                    frame = new EncryptionUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                frame.setVisible(true);
                //set default close operation
                //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });

        btnDecryption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        btnEncryption.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent evt)
            {
                btnEncryption.setBackground(Color.white);
                btnEncryption.setBorder(BorderFactory.createLineBorder(Color.pink));
            }
            public void mouseExited(MouseEvent evt)
            {
                btnEncryption.setBackground(Color.lightGray);
            }
        });
        btnDecryption.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent evt)
            {
                btnDecryption.setBackground(Color.white);
                btnDecryption.setBorder(BorderFactory.createLineBorder(Color.pink));
            }
            public void mouseExited(MouseEvent evt)
            {
                btnDecryption.setBackground(Color.lightGray);
            }
        });


        btnEncryption.setForeground(Color.black);
        btnDecryption.setForeground(Color.black);


        btnEncryption.setFont(new Font("Serif", Font.BOLD, 16));
        btnDecryption.setFont(new Font("Serif", Font.BOLD, 16));


        btnEncryption.setBounds(180,100,120, 40);
        btnDecryption.setBounds(320,100,120, 40);

        home.add(btnEncryption);
        home.add(btnDecryption);



        home.setSize(600,600);
        home.getContentPane().setBackground(Color.CYAN);
        home.setLayout(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        home.setLocation(dim.width/2-home.getSize().width/2, dim.height/2-home.getSize().height/2);
        home.setVisible(true);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.setAlwaysOnTop(true);
    }




}
