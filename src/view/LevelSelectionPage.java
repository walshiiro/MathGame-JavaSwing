package view;

import controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class LevelSelectionPage extends JPanel {
    private JLabel welcomeLabel;
    private JButton btnlevel1;
    private JButton btnlevel2;
    private JButton btnlevel3;
    private JButton btnlevel4;


    private Image backgroundImage;

    public LevelSelectionPage(Controller controller) {
        // Initialize components
        setLayout(null);
        try {
            backgroundImage = ImageIO.read(new File("image/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        welcomeLabel = new JLabel("Chọn level bạn muốn chơi", JLabel.CENTER);
        btnlevel1 = new JButton("Level 1");
        btnlevel2 = new JButton("Level 2");
        btnlevel3 = new JButton("Level 3");
        btnlevel4 = new JButton("Level 4");


        welcomeLabel.setBounds(200, 150, 400, 55);
        welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnlevel1.setBounds(300, 250, 200, 30);
        btnlevel2.setBounds(300, 300, 200, 30);
        btnlevel3.setBounds(300, 350, 200, 30);
        btnlevel4.setBounds(300, 400, 200, 30);
        btnlevel1.setFocusPainted(false);
        btnlevel1.setBorderPainted(true);
        btnlevel1.setBackground(Color.WHITE);
        btnlevel2.setFocusPainted(false);
        btnlevel2.setBorderPainted(true);
        btnlevel2.setBackground(Color.WHITE);
        btnlevel3.setFocusPainted(false);
        btnlevel3.setBorderPainted(true);
        btnlevel3.setBackground(Color.WHITE);
        btnlevel4.setFocusPainted(false);
        btnlevel4.setBorderPainted(true);
        btnlevel4.setBackground(Color.WHITE);



        add(welcomeLabel);
        add(btnlevel1);
        add(btnlevel2);
        add(btnlevel3);
        add(btnlevel4);

        setPreferredSize(new Dimension(800, 600));

//        buttonEnter.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String username = textUsername.getText().trim();
//                if (username.isEmpty()) {
//                    JOptionPane.showMessageDialog(null, "Please enter a username.");
//                } else {
//                    JOptionPane.showMessageDialog(null, "Welcome, " + username + "!");
//                }
//            }
//        });
        btnlevel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                controller.showPlayPage();
            }
        });

        btnlevel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showPlayPagelvl2();
            }
        });

        btnlevel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showPlayPagelvl3();
            }
        });
        btnlevel4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               controller.showPlayPagelvl4();
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
