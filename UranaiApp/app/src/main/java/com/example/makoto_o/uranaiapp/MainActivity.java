package com.example.makoto_o.uranaiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

    //入力された名前
    public static final String INPUT_NAME = "InputName";

    public static final String RESULT_NUMBER = "ResultNumber";

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

        yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    daySpinner.setAdapter(createDayAdapter());
                    Log.d("yearSpinner", "onItemSelectedが選ばれました。");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Spinnerで値が選択されたときイベント
        // 月選択用Spinnerにリスナーを設定する

        //litnerの文法
        //○○Listner(new xxListner() {
        //  イベントが発生した時の処理
        // };
        //
        monthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            //選択されている月が変わった（何か選択された）時の処理
            // patent : setOnItemSelectedListenerを設定したビュー
            // view : 実際に選択されたビュー
            // position : 何行目が選択されたか。1950が選択されると0
            // id : positionと同じ
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                daySpinner.setAdapter(createDayAdapter());
                Log.d("monthSpinner", "onItemSelectedが選ばれました。");

            }

            @Override
            //何も選択していない時の処理
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d("monthSpinner", "onNothingSelectedがよばれました。");
            }
        });

        // 『占う』ボタンを押したというイベントを取得するためのリスナー設定
        Button button = (Button) findViewById(R.id.divineButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intentクラスのオブジェクトを生成
                //第一引数がMainActivityのコンテキスト（MainActivity）
                //コンテキスト：アプリの情報や状態を保つもの
                //第二引数が遷移先のクラス
                Intent intent = new Intent(MainActivity.this,
                        ResultActivity.class);

                //レイアウトからEditTextを取り出す
                //toString : Object
                EditText editText = (EditText)findViewById(R.id.nameEditText);
                String name = editText.getText().toString();

                //0~9の文字を求める方法
                //1.年＋月＋日（1950年１月１日だと1950 + 1 + 1=1952を求める
                //2.足し合わせた結果の一桁目を取り出し、数字とする。
                int year = (int)yearSpinner.getSelectedItem();
                int month = (int)monthSpinner.getSelectedItem();
                int day = (int)daySpinner.getSelectedItem();

                int resultNumber = year + month + day;
                // String.valueOf=文字列に変換するメソッド
                String resultString = String.valueOf(resultNumber);
                String str = resultString.substring(3);
                Log.d("占い結果の数字", str);

                resultNumber = Integer.parseInt(str);



                //画面遷移前に遷移先に渡したいデータをセットしておく
                //第一引数が、渡すデータに付ける名前
                //第二引数が、実際に渡すデータ
                intent.putExtra(INPUT_NAME, name);
                intent.putExtra(RESULT_NUMBER, resultNumber);

                //画面遷移の処理を行うためのメソッド
                //intent(遷移先や渡すデータなどが入っている）
                startActivity(intent);
            }
        });

       // Button button = new Button(this);
       // button.setOnClickListener(new View.OnClickListener() {
       //  @Override
       //    public void onClick(View v) {
       //
       //  }
       // });



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

        //1.今、何月が選択されているかを取得する。
        int month = (int) monthSpinner.getSelectedItem();

        //2.選択されている月が４月、６月、9月、11月のいずれかの時、日の上限を30日とする。
        // == 同じ
        // || もしくは
        int day = 31;
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            day = 30;
        }

        //1.選択されている月が２月の場合
        //2.まず選択されている年を取得する
        //3.選択されている年が閏年の場合は２９日までとする。
        //4.閏年でなければ２８日までとする.
        else if (month == 2) {
            int year = (int) yearSpinner.getSelectedItem();

            if (year % 4 == 0 && year % 100 != 0) {
                day = 29;
            }

            else {
                day = 28;
            }
        }





        // for文を回してArrayAdapterに値をセット
        for (int i = 1; i <= day; i++) {
            dayAdapter.add(i);
        }

        return dayAdapter;
    }

}
