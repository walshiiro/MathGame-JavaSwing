package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import controller.Controller;
import model.User;

public class LoginPage extends JPanel {
    private JLabel welcomeLabel;
    private JLabel labelUsername;
    private JTextField textUsername;
    private JButton buttonEnter;
    private Image backgroundImage;


    public LoginPage(Controller controller) {
        setLayout(null);
        try {
            backgroundImage = ImageIO.read(new File("image/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        welcomeLabel = new JLabel("Chào mừng bạn!");
        labelUsername = new JLabel("Nhập tên của bạn vào đây: ");
        textUsername = new JTextField();
        buttonEnter = new JButton("Enter");

        welcomeLabel.setBounds(320, 150, 281, 55);
        welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelUsername.setBounds(200, 250, 200, 30);
        textUsername.setBounds(400, 250, 200, 30);
        buttonEnter.setBounds(350, 400, 100, 30);
        buttonEnter.setFocusPainted(false);
        buttonEnter.setBorderPainted(true);
        buttonEnter.setBackground(Color.WHITE);

        buttonEnter.setContentAreaFilled(false);


        add(welcomeLabel);
        add(labelUsername);
        add(textUsername);
        add(new JLabel());
        add(buttonEnter);

        setPreferredSize(new Dimension(800, 600));

        buttonEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textUsername.getText().trim();
                if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a username.");
                } else {
                    JOptionPane.showMessageDialog(null, "Welcome, " + username + "!");
                    if(!controller.userList.checkUser(username)) {
                        controller.userList.addUser(new User(username,0));
                        controller.userList.writeToFile();
                    }
                    controller.username = username;

                    controller.showMenuPage();


                }
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
