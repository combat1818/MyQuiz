package com.example.myquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CardView card;
    private CardView [] cardsTab=new CardView[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        /*
        Button buttonStartQuiz=findViewById(R.id.button_start_quiz);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startQuiz();
            }
        });*/

        addListeners();


    }
/*
    private void startQuiz(){
        Intent intent=new Intent(MainActivity.this, QuizActivity.class);
        startActivity(intent);
    }*/

    private void addListeners(){
        int temp;
        for(int i=1;i<=10;i++) {
            temp=getResources().getIdentifier("card"+i, "id", getPackageName());
            card = findViewById(temp);
            final int finalI = i;
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "clicked"+ finalI, Toast.LENGTH_SHORT).show();
                    showQuizInfo();
                }
            });
        }
    }

    private void showQuizInfo(){
        Intent intent=new Intent(MainActivity.this, QuizInfo.class);
        Bundle b = new Bundle();
        b.putString("color", "#f59e42");
        intent.putExtras(b);
        startActivity(intent);
    }
}
