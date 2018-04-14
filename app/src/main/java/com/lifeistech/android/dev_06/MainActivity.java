package com.lifeistech.android.dev_06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static java.lang.StrictMath.sqrt;

public class MainActivity extends AppCompatActivity {
    private static final int QUESTION_COUNT = 10;

    TextView textView,textView2;
    Random random = new Random();
    int questions[];
    int point;
    int answerCount;

    Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        textView2=(TextView)findViewById(R.id.textView2);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);

        questions = new int[QUESTION_COUNT];
        for (int i = 0; i < 10; i++) {
            questions[i] = random.nextInt(1000);
            Log.d("sosu", "questions=" + questions[i]);
        }
        point = 0;
        answerCount = 0;
        textView.setText(questions[answerCount] + "");

    }

    public void maru(View v) {
        boolean answer = true;

        int n = questions[answerCount];

        for (int i = 2; i < sqrt(n); i++) {
            if (n % i == 0) {
                Log.d("yakusu","i="+i);
                answer = false;
                break;
            }
        }
        Log.d("answer","sosu:"+answer);
        if (answer) {
            Toast.makeText(this, "正解", Toast.LENGTH_SHORT).show();
            point++;
            Log.d("maru", "正解:" + point);
        } else {
            Toast.makeText(this, "不正解", Toast.LENGTH_SHORT).show();
            Log.d("maru", "不正解:");
        }
        answerCount++;
        if (answerCount == QUESTION_COUNT) {
            String s="good";
            if(point<5){
                s="bad";
            }
            textView.setText(point + "点\n"+s);
            textView2.setText(null);
        } else {
            textView.setText(questions[answerCount] + "");
            textView2.setText(answerCount+1+"問目"+point+"〇"+(answerCount-point)+"×");

        }

    }

    public void batsu(View v) {
        boolean answer = true;

        int n = questions[answerCount];

        for (int i = 2; i < sqrt(n); i++) {
            if (n % i == 0) {
                Log.d("yakusu","i="+i);
                answer = false;
                break;
            }
        }
        Log.d("answer","sosu:"+answer);
        if (answer) {
            Toast.makeText(this, "不正解", Toast.LENGTH_SHORT).show();

            Log.d("batsu", "不正解:");
        } else {
            Toast.makeText(this, "正解", Toast.LENGTH_SHORT).show();
            point++;
            Log.d("batsu", "正解:" + point);
        }
        answerCount++;
        if (answerCount == QUESTION_COUNT) {
            textView2.setText(null);
            String s="good";
            if(point<5){
                s="bad";
            }
            textView.setText(point + "点\n"+s);
        } else {
            textView.setText(questions[answerCount] + "");
            textView2.setText(answerCount+1+"問目"+point+"〇"+(answerCount-point)+"×");
        }


    }

}