import controller.Controller;
import model.QuestionList;
import model.UserList;
import view.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
      QuestionList questionList = new QuestionList();
      UserList userList = new UserList();
       questionList.readFromFile();
       userList.readFromFile();
      Controller cl = new Controller(questionList,userList);
      cl.start();




    }
}
