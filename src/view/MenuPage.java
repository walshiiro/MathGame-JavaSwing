package view;

import controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MenuPage extends JPanel {
    private JLabel welcomeLabel;
    private JButton btnPlay;
    private JButton btnLeaderBoard;
    private JButton btnQuit;

    private Image backgroundImage;

    public MenuPage(Controller controller) {
        // Initialize components
        setLayout(null);
        try {
            backgroundImage = ImageIO.read(new File("image/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        welcomeLabel = new JLabel("Chào mừng bạn đến với MathGame", JLabel.CENTER);
        btnPlay = new JButton("Chơi");
        btnLeaderBoard = new JButton("Bảng xếp hạng");
        btnQuit = new JButton("Đăng xuất");


        welcomeLabel.setBounds(200, 150, 400, 55);
        welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnPlay.setBounds(300, 250, 200, 30);
        btnLeaderBoard.setBounds(300, 350, 200, 30);
        btnQuit.setBounds(300, 450, 200, 30);
        btnPlay.setFocusPainted(false);
        btnPlay.setBorderPainted(true);
        btnPlay.setBackground(Color.WHITE);
        btnLeaderBoard.setFocusPainted(false);
        btnLeaderBoard.setBorderPainted(true);
        btnLeaderBoard.setBackground(Color.WHITE);
        btnQuit.setFocusPainted(false);
        btnQuit.setBorderPainted(true);
        btnQuit.setBackground(Color.WHITE);



        add(welcomeLabel);
        add(btnPlay);
        add(btnLeaderBoard);
        add(btnQuit);

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
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showLevelSelectionPage();

            }
        });

        btnLeaderBoard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showLeaderBoardPage();
            }
        });

        btnQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showLoginPage();
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
