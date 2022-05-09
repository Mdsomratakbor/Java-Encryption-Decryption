package EncryptionDecryptionUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomeUI {

    public static void main(String[] args) {
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


        JButton encryption, decryption;

        encryption = new JButton("Encryption");
        decryption = new JButton("Decryption");

        encryption.setBackground(Color.lightGray);
        decryption.setBackground(Color.lightGray);
        encryption.setOpaque(true);


        encryption.setBorder(BorderFactory.createLineBorder(Color.white));
        decryption.setBorder(BorderFactory.createLineBorder(Color.white));

        encryption.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent evt)
            {
                encryption.setBackground(Color.white);
                encryption.setBorder(BorderFactory.createLineBorder(Color.pink));
            }
            public void mouseExited(MouseEvent evt)
            {
                encryption.setBackground(Color.lightGray);
            }
        });
        decryption.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent evt)
            {
                decryption.setBackground(Color.white);
                decryption.setBorder(BorderFactory.createLineBorder(Color.pink));
            }
            public void mouseExited(MouseEvent evt)
            {
                decryption.setBackground(Color.lightGray);
            }
        });


        encryption.setForeground(Color.black);
        decryption.setForeground(Color.black);


        encryption.setFont(new Font("Serif", Font.BOLD, 16));
        decryption.setFont(new Font("Serif", Font.BOLD, 16));

       
        encryption.setBounds(180,100,120, 40);
        decryption.setBounds(320,100,120, 40);

        home.add(encryption);
        home.add(decryption);



        home.setSize(600,600);
        home.getContentPane().setBackground(Color.CYAN);
        home.setLayout(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        home.setLocation(dim.width/2-home.getSize().width/2, dim.height/2-home.getSize().height/2);
        home.setVisible(true);
        home.setAlwaysOnTop(true);
    }




}
