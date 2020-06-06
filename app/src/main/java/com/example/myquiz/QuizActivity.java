package com.example.myquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;


public class QuizActivity extends AppCompatActivity {

    private TextView questionView;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    private ArrayList<Question> questionList;
    private int currentQuestion;
    private final int questionNumber=10;
    private boolean quizEnded=false;
    private int delay=500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        //this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        questionView=findViewById(R.id.questionView);
        btn1=findViewById(R.id.option1);
        btn2=findViewById(R.id.option2);
        btn3=findViewById(R.id.option3);
        btn4=findViewById(R.id.option4);

        btn1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!quizEnded)
                    checkAnswer(1, btn1);
            }
        });
        btn2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!quizEnded)
                    checkAnswer(2, btn2);
            }
        });
        btn3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!quizEnded)
                    checkAnswer(3, btn3);
            }
        });
        btn4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!quizEnded)
                    checkAnswer(4, btn4);
            }
        });

        questionList=QuestionReceiver.getQuestions();
        Collections.shuffle(questionList);
        currentQuestion=0;
        showNextQuestion();
        startAnimation(5000);
    }

    private void showNextQuestion(){
        if(currentQuestion>=10){
            quizEnded=true;
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    // Actions to do after 5 seconds
                    finishQuiz();
                }
            }, delay);
        }else {
            questionView.setText(questionList.get(currentQuestion).getQuestion());
            btn1.setText(questionList.get(currentQuestion).getOption1());
            btn2.setText(questionList.get(currentQuestion).getOption2());
            btn3.setText(questionList.get(currentQuestion).getOption3());
            btn4.setText(questionList.get(currentQuestion).getOption4());
        }
    }

    private void checkAnswer(int option, final Button btn){
        if(questionList.get(currentQuestion).getAnswerNr()==option){
            currentQuestion++;
            btn.setBackgroundResource(R.drawable.rounded_button_correct);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    // Actions to do after 5 seconds
                    btn.setBackgroundResource(R.drawable.rounded_button_casual);
                    showNextQuestion();
                    startAnimation(5000);
                }
            }, delay);

        }else{
            quizEnded=true;
            btn.setBackgroundResource(R.drawable.rounded_button_wrong);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    // Actions to do after 5 seconds
                    finishQuiz();
                }
            }, delay);

        }
    }


    private void finishQuiz(){
        //Intent intent=new Intent(QuizActivity.this, MainActivity.class);
        //startActivity(intent);

        Intent backToMenu = new Intent(QuizActivity.this, MainActivity.class);
        backToMenu.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(backToMenu);
    }

    private void startAnimation(int duration){
        View circle2 = (ImageView) findViewById(R.id.btk);
        ScaleAnimation fade_in =  new ScaleAnimation(4f, 0f, 4f, 0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        fade_in.setDuration(duration);     // animation duration in milliseconds
        fade_in.setFillAfter(true);    // If fillAfter is true, the transformation that this animation performed will persist when it is finished.
        circle2.startAnimation(fade_in);
    }

}
