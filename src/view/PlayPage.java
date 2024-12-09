package view;

import controller.Controller;
import model.QuestionAndAnswer;
import model.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayPage extends JPanel {
    private JLabel welcomeLabel;
    private JButton btnlevel1;
    private JButton btnlevel2;
    private JButton btnlevel3;
    private JButton btnlevel4;
    private List<QuestionAndAnswer> questions; // Danh sách câu hỏi
    private int currentQuestionIndex = 0; // Chỉ số câu hỏi hiện tại
    private Image backgroundImage;
    public int point=0;
    Controller controller;
    public PlayPage(Controller controller) {
        setLayout(null);
        this.controller = controller;
        try {
            backgroundImage = ImageIO.read(new File("image/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Lấy danh sách câu hỏi từ controller
        questions = controller.Level1ListGenerate();

        // Khởi tạo các thành phần giao diện
        welcomeLabel = new JLabel("", JLabel.CENTER);
        welcomeLabel.setBounds(200, 150, 400, 55);
        welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(welcomeLabel);

        btnlevel1 = createButton(150, 250);
        btnlevel2 = createButton(450, 250);
        btnlevel3 = createButton(150, 400);
        btnlevel4 = createButton(450, 400);

        add(btnlevel1);
        add(btnlevel2);
        add(btnlevel3);
        add(btnlevel4);

        setPreferredSize(new Dimension(800, 600));

        // Hiển thị câu hỏi đầu tiên
        showQuestion();
    }

    public void refreshQuestions(List<QuestionAndAnswer> newQuestions) {
        this.questions = newQuestions; // Cập nhật danh sách câu hỏi mới
        this.currentQuestionIndex = 0; // Đặt lại câu hỏi đầu tiên
        this.point = 0; // Đặt lại điểm về 0
        showQuestion(); // Hiển thị câu hỏi đầu tiên
    }


    /**
     * Tạo JButton với vị trí chỉ định.
     */
    private JButton createButton(int x, int y) {
        JButton button = new JButton();
        button.setBounds(x, y, 200, 80);
        button.setFocusPainted(false);
        button.setBorderPainted(true);
        button.setBackground(Color.WHITE);
        button.addActionListener(this::handleAnswer);
        return button;
    }

    /**
     * Hiển thị câu hỏi hiện tại và cập nhật giao diện.
     */
    private void showQuestion() {
        if (currentQuestionIndex >= questions.size()) {
            JOptionPane.showMessageDialog(this, "Bạn đã hoàn thành tất cả câu hỏi!");
            for(User u: controller.userList.getUsers())
            {
                if(u.getName().equalsIgnoreCase(controller.username))
                {
                    u.setPoints(u.getPoints() + point);
                    controller.userList.writeToFile();

                    break;
                }
            }

            point=0;
            currentQuestionIndex = 0;
            controller.showMenuPage();

        }

        // Lấy câu hỏi hiện tại
        QuestionAndAnswer currentQuestion = questions.get(currentQuestionIndex);
        welcomeLabel.setText(currentQuestion.getQuestion());

        // Tạo danh sách đáp án
        List<String> ans = new ArrayList<>();
        ans.add(currentQuestion.getAnswer());
        ans.add(String.valueOf(Integer.valueOf(currentQuestion.getAnswer()) + 1));
        ans.add(String.valueOf(Integer.valueOf(currentQuestion.getAnswer()) - 1));
        ans.add(String.valueOf(Integer.valueOf(currentQuestion.getAnswer()) - 2));
        Collections.shuffle(ans);

        // Cập nhật văn bản cho các nút
        btnlevel1.setText(ans.get(0));
        btnlevel2.setText(ans.get(1));
        btnlevel3.setText(ans.get(2));
        btnlevel4.setText(ans.get(3));

        // Gắn đáp án đúng vào ActionCommand để xử lý
        btnlevel1.setActionCommand(ans.get(0));
        btnlevel2.setActionCommand(ans.get(1));
        btnlevel3.setActionCommand(ans.get(2));
        btnlevel4.setActionCommand(ans.get(3));
    }

    /**
     * Xử lý khi người dùng chọn đáp án.
     */
    private void handleAnswer(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String selectedAnswer = clickedButton.getActionCommand();

        // Kiểm tra đáp án
        QuestionAndAnswer currentQuestion = questions.get(currentQuestionIndex);
        if (selectedAnswer.equals(currentQuestion.getAnswer())) {
            JOptionPane.showMessageDialog(this, "Đúng rồi!");
            point++;
        } else {
            JOptionPane.showMessageDialog(this, "Sai rồi!");
        }

        // Chuyển sang câu hỏi tiếp theo
        currentQuestionIndex++;
        showQuestion();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
