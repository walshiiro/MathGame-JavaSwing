package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class QuestionList {
    List<QuestionAndAnswer> questions = new ArrayList<>();
    public QuestionList() {}
    public void addQuestion(QuestionAndAnswer question) {
        questions.add(question);
    }
    public void readFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("questionfile.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 3) {
                    try {
                        QuestionAndAnswer variety = new QuestionAndAnswer(fields[0].trim(), fields[1].trim(),fields[2].trim());
                        questions.add(variety);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    public List<QuestionAndAnswer> getQuestions() {
        return questions;
    }
}
