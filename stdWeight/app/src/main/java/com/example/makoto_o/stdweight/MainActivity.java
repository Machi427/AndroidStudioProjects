package com.example.makoto_o.stdweight;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends Activity {
    //標準体重
    double stdWeight;
    //メッセージ用のテキスト
    String stdWeightTxt;
    String errorMsg;

    //小数点以下２桁まで表示するフォーマット
    DecimalFormat myFormat = new DecimalFormat("###.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //文字列リソースを取得
        Resources res = getResources();
        stdWeightTxt = res.getString(R.string.stdWeight);
        errorMsg = res.getString(R.string.erroMsg);
    }

    //ボタンがクリックされた
    public void onClickButton(View view) {
        //身長が入力されているEditText
        EditText heightText = (EditText) findViewById(R.id.heightText);
        String heightStr = heightText.getText().toString();

        //結果を表示するTextView
        TextView stdWeightTextView = (TextView) findViewById(R.id.stdWeightText);

        try {
            //標準体重を計算する
            double height = Double.parseDouble(heightStr);
            stdWeight = Math.pow(height / 100, 2) * 22;
            String stdWeightStr = myFormat.format(stdWeight);
            stdWeightTextView.setText(stdWeightTxt + stdWeightStr + "Kg" );



        } catch (NumberFormatException e) {
            Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show();
        }
    }

}
