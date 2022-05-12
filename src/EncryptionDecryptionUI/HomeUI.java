package EncryptionDecryptionUI;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HomeUI extends  JFrame {

    public  HomeUI() throws IOException {

        BufferedImage myPicture = ImageIO.read(new File("images/source.gif"));

        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(160,100, 280,280);
        picLabel.setBackground(Color.white);
        picLabel.setOpaque(true);
        add(picLabel);


        JLabel projectTitle;
        projectTitle=new JLabel("Encryption and Decryption Application");
        projectTitle.setBounds(130,50, 340,40);
        projectTitle.setBackground(Color.white);
        projectTitle.setForeground(Color.pink);
        projectTitle.setOpaque(true);
        projectTitle.setFont(new Font("Serif", Font.BOLD, 20));
        projectTitle.setHorizontalTextPosition(JLabel.CENTER);
        projectTitle.setVerticalTextPosition(JLabel.CENTER);
        add(projectTitle);


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
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });

        btnDecryption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //call the object of NewWindow and set visible true
                DecryptionUI frame = null;
                try {
                    DecryptionUI encryptionForm = new DecryptionUI();
                    frame = new DecryptionUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                frame.setVisible(true);
                //set default close operation
               setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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


        btnEncryption.setBounds(180,400,120, 40);
        btnDecryption.setBounds(320,400,120, 40);

        add(btnEncryption);
        add(btnDecryption);


        setResizable(false);
        setTitle("Home");
        setSize(600,600);
        getContentPane().setBackground(Color.CYAN);
         setLayout(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                //try - catch block
                try
                {
                    //Create object of NewWindow
                    HomeUI frame = new HomeUI();
                    //set frame visible true
                    frame.setVisible(true);
                    frame.transferFocusBackward();
                   // frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }




}
