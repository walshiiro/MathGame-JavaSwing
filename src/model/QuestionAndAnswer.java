package model;

public class QuestionAndAnswer {
    private String level;
    private String question;
    private String answer;
    public QuestionAndAnswer(String level, String question, String answer) {
        this.level = level;
        this.question = question;
        this.answer = answer;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String toString() {
        return "QuestionAndAnswer level=" + level + ", question=" + question + ", answer=" + answer;
    }
}
