package com.example.myquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuizInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_info);

/*
        circle2 = (ImageView) findViewById(R.id.circle2);
        ScaleAnimation fade_in =  new ScaleAnimation(0f, 1f, 0f, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        fade_in.setDuration(1000);     // animation duration in milliseconds
        fade_in.setFillAfter(true);    // If fillAfter is true, the transformation that this animation performed will persist when it is finished.
        circle2.startAnimation(fade_in);*/

        Button buttonStartQuiz=findViewById(R.id.btn);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startQuiz();
            }
        });


    }



    private void startQuiz(){
        Intent intent=new Intent(QuizInfo.this, QuizActivity.class);
        startActivity(intent);
    }
}
