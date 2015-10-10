package com.example.makoto_o.uranaiapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //年選択用のSpinner
    private Spinner yearSpinner;

    //月選択用のSpinner
    private Spinner monthSpinner;

    //日選択用のSpinner
    private Spinner daySpinner;

    //static final=定数
    /** 開始年 */
    private static final int START_YEAR = 1950;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //レイアウトからSpinnerを持ってくる
        yearSpinner = (Spinner)findViewById(R.id.yearSpinner);
        monthSpinner = (Spinner)findViewById(R.id.monthSpinner);
        daySpinner = (Spinner)findViewById(R.id.daySpinner);

       //Logを出力する。
       // Log.d("レイアウトのどのパーツを返しているか","ログ表示テストです");


        // Spinnerにデータをセットする
        yearSpinner.setAdapter(createYearAdapter());
        monthSpinner.setAdapter(createMonthAdapter());
        daySpinner.setAdapter(createDayAdapter());


    }

    //<Integer>=ジェネリックス
    //このArrayAdapterにはInteger型のデータしか入らない
    private ArrayAdapter<Integer> createYearAdapter() {
        // ArrayAdapterの初期化
        ArrayAdapter<Integer> yearAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item);

        // 現在、西暦何年かを取得する
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);

        // for文を回してArrayAdapterに値をセット
        for (int i = START_YEAR; i <= year; i++) {
            yearAdapter.add(i);
        }

        return yearAdapter;
    }

    //月のArrayAdapterを作成
    private ArrayAdapter<Integer> createMonthAdapter() {
        // ArrayAdapterの初期化
        ArrayAdapter<Integer> monthAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item);

        // ドロップダウン時の画面レイアウトを設定
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // for文を回してArrayAdapterに値をセット
        for (int i = 1; i <= 12; i++) {
            monthAdapter.add(i);
        }

        return monthAdapter;
    }

    //日のArrayAdapterを作成

    private ArrayAdapter<Integer> createDayAdapter() {
        // ArrayAdapterの初期化
        ArrayAdapter<Integer> dayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item);

        // ドロップダウン時の画面レイアウトを設定
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // for文を回してArrayAdapterに値をセット
        Integer day = 31;
        for (int i = 1; i <= day; i++) {
            dayAdapter.add(i);
        }

        return dayAdapter;
    }

}
