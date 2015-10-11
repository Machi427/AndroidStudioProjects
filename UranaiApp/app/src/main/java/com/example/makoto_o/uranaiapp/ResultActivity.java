package com.example.makoto_o.uranaiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // 遷移元でセットしたnameを取り出す
        Intent intent = getIntent();

        //インテントにセットしてあるデータを取得
        String name = intent.getStringExtra(MainActivity.INPUT_NAME);
        int number = intent.getIntExtra(MainActivity.RESULT_NUMBER, 0);

        String[] array = getResources().getStringArray(R.array.results);

        TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
        TextView resultTextView = (TextView) findViewById(R.id.resultTextView);

        nameTextView.setText(name);
        resultTextView.setText(array[number]);
    }
}

