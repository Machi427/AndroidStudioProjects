package com.example.makoto_o.javabasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Carクラスのオブジェクト（インスタンス）を生成する。
        Car car = new Car();
        //getInstanceのInstance = オブジェクト

        //Carクラスのフィールド
        //Carクラスの情報をセット
        car.number = "A12345";
        car.gas = 20;
        car.carType = "普通車";

        //Carクラスのメソッド
        //Carクラスの機能を使う
        car.showNumber();
        car.showCarType();
        Log.d("...車の走行距離...", "残り" + car.calcGas() + "km");
    }
}
