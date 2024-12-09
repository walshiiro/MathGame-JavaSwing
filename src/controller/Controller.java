package controller;
import model.*;

import java.awt.*;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import view.*;

import javax.swing.*;

public class Controller {
    Scanner sc = new Scanner(System.in);
    QuestionList questionList;
    public UserList userList;
    private CardLayout cardLayout;  // CardLayout để chuyển đổi giữa các trang
    private JPanel mainPanel;  // JPanel chính chứa các trang
    private JFrame frame;

    public String username;

    public Controller(QuestionList questionList, UserList userList) {

        this.questionList = questionList;
        this.userList = userList;

        frame = new JFrame("MathGame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        PlayPage playPage = new PlayPage(this);
        PlayPageLvl2 playPageLvl2 = new PlayPageLvl2(this);
        PlayPageLvl3 playPageLvl3 = new PlayPageLvl3(this);
        PlayPageLvl4 playPageLvl4 = new PlayPageLvl4(this);

        mainPanel.add(new LoginPage(this), "Login");
        mainPanel.add(new MenuPage(this), "Menu");


        mainPanel.add(playPage, "Play");
        mainPanel.add(playPageLvl2, "Play lvl2");
        mainPanel.add(playPageLvl3, "Play lvl3");
        mainPanel.add(playPageLvl4, "Play lvl4");

        mainPanel.add(new LevelSelectionPage(this), "Level Selection");
        mainPanel.add(new LeaderBoardPage(this,userList.scoreTable()),"LeaderBoard");

        frame.pack();
        frame.add(mainPanel);
        frame.setSize(800,600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);



    }





    public List<QuestionAndAnswer> Level1ListGenerate()
    {
        List<QuestionAndAnswer> data = questionList.getQuestions();
        String targetLevel = "Level 1";
        List<QuestionAndAnswer> filteredList = data.stream()
                .filter(q -> q.getLevel().equals(targetLevel))
                .collect(Collectors.toList());

            Collections.shuffle(filteredList);
            List<QuestionAndAnswer> randomQuestions = filteredList.subList(0, 10);

            return randomQuestions;

    }
    public List<QuestionAndAnswer> Level2ListGenerate()
    {
        List<QuestionAndAnswer> data = questionList.getQuestions();
        String targetLevel = "Level 2";
        List<QuestionAndAnswer> filteredList = data.stream()
                .filter(q -> q.getLevel().equals(targetLevel))
                .collect(Collectors.toList());

        Collections.shuffle(filteredList);
        List<QuestionAndAnswer> randomQuestions = filteredList.subList(0, 10);

        return randomQuestions;

    }
    public List<QuestionAndAnswer> Level3ListGenerate()
    {
        List<QuestionAndAnswer> data = questionList.getQuestions();
        String targetLevel = "Level 3";
        List<QuestionAndAnswer> filteredList = data.stream()
                .filter(q -> q.getLevel().equals(targetLevel))
                .collect(Collectors.toList());

        Collections.shuffle(filteredList);
        List<QuestionAndAnswer> randomQuestions = filteredList.subList(0, 10);

        return randomQuestions;

    }
    public List<QuestionAndAnswer> Level4ListGenerate()
    {
        List<QuestionAndAnswer> data = questionList.getQuestions();
        String targetLevel = "Level 4";
        List<QuestionAndAnswer> filteredList = data.stream()
                .filter(q -> q.getLevel().equals(targetLevel))
                .collect(Collectors.toList());

        Collections.shuffle(filteredList);
        List<QuestionAndAnswer> randomQuestions = filteredList.subList(0, 10);

        return randomQuestions;

    }

    public void showLoginPage()
    {
        cardLayout.show(mainPanel, "Login");
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    public void showMenuPage()
    {
        cardLayout.show(mainPanel, "Menu");
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    public void showLevelSelectionPage()
    {
        cardLayout.show(mainPanel, "Level Selection");
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    public void showPlayPage()
    {
        PlayPage playPage = (PlayPage) mainPanel.getComponent(2); // Lấy đối tượng PlayPage
        playPage.refreshQuestions(Level1ListGenerate()); // Làm mới danh sách câu hỏi
        cardLayout.show(mainPanel, "Play"); // Hiển thị trang Play
        mainPanel.revalidate(); // Làm mới giao diện
        mainPanel.repaint();
    }
    public void showPlayPagelvl2() {
        PlayPageLvl2 playPageLvl2 = (PlayPageLvl2) mainPanel.getComponent(3); // Lấy đối tượng PlayPageLvl2
        playPageLvl2.refreshQuestions(Level2ListGenerate()); // Làm mới danh sách câu hỏi
        cardLayout.show(mainPanel, "Play lvl2"); // Hiển thị trang Play lvl2
        mainPanel.revalidate(); // Làm mới giao diện
        mainPanel.repaint();
    }

    public void showPlayPagelvl3() {
        PlayPageLvl3 playPageLvl3 = (PlayPageLvl3) mainPanel.getComponent(4); // Lấy đối tượng PlayPageLvl3
        playPageLvl3.refreshQuestions(Level3ListGenerate()); // Làm mới danh sách câu hỏi
        cardLayout.show(mainPanel, "Play lvl3"); // Hiển thị trang Play lvl3
        mainPanel.revalidate(); // Làm mới giao diện
        mainPanel.repaint();
    }

    public void showPlayPagelvl4() {
        PlayPageLvl4 playPageLvl4 = (PlayPageLvl4) mainPanel.getComponent(5); // Lấy đối tượng PlayPageLvl4
        playPageLvl4.refreshQuestions(Level4ListGenerate()); // Làm mới danh sách câu hỏi
        cardLayout.show(mainPanel, "Play lvl4"); // Hiển thị trang Play lvl4
        mainPanel.revalidate(); // Làm mới giao diện
        mainPanel.repaint();
    }

    public void showLeaderBoardPage()
    {

        cardLayout.show(mainPanel, "LeaderBoard");
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void start()
    {
        showLoginPage();  // Hiển thị trang Login đầu tiên
        frame.setVisible(true);  // Hiển thị JFrame
    }










}
