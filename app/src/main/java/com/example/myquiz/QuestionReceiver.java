package com.example.myquiz;

import java.util.ArrayList;

public class QuestionReceiver {

    //public Question(String question, String option1, String option2, String option3, int answerNr, int time)
    private static ArrayList<Question> questions=new ArrayList<>();
    private  static Question q1=new Question("A is correct", "A", "B", "C", "D", 1, 10);
    private  static Question q2=new Question("B is correct", "A", "B", "C", "D", 2, 10);
    private  static Question q3=new Question("C is correct", "A", "B", "C", "D", 3, 10);
    private  static Question q4=new Question("D is correct", "A", "B", "C", "D", 4, 10);
    private  static Question q5=new Question("A is correct", "A", "B", "C", "D", 1, 10);
    private  static Question q6=new Question("B is correct", "A", "B", "C", "D", 2, 10);
    private  static Question q7=new Question("C is correct", "A", "B", "C", "D", 3, 10);
    private  static Question q8=new Question("D is correct", "A", "B", "C", "D", 4, 10);
    private  static Question q9=new Question("A is correct", "A", "B", "C", "D", 1, 10);
    private  static Question q10=new Question("B is correct", "A", "B", "C", "D", 2, 10);

    public QuestionReceiver(){}

    public static ArrayList<Question> getQuestions(){
        questions.clear();
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);
        questions.add(q5);
        questions.add(q6);
        questions.add(q7);
        questions.add(q8);
        questions.add(q9);
        questions.add(q10);

        return questions;
    }
}
