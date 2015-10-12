package com.example.makoto_o.javabasic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // @Override：アノテーション(忠告)
    // このメソッドはオーバーライドされていますよ、と周知している
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Carクラスのオブジェクト(インスタンス)を生成する。
        Car car = new Car();
        // Carクラスのフィールド
        // Carクラスに車の情報をセット
        car.number = "A12345";
        car.gas = 20;
        car.carType = "普通車";

        Car car2 = new Car("B98765", 30, "中型");
        // getInstanceのInstance = オブジェクト
//        Calendar calendar = Calendar.getInstance();

        // スーパーカーの宣言
        SuperCar superCar1 = new SuperCar();
//        SuperCar superCar2 = new SuperCar("B98765", 30, "中型");
        superCar1.number = "C99999";
        superCar1.gas = 100;
        superCar1.carType = "大型";
        // スーパーカー出力
        superCar1.showNumber();
//        superCar1.showCarType();
//        Log.d("★★★★★車の走行可能距離★★★★★", "残り" + superCar1.calcGas() + "km");
//        Log.d("★★★★★車の走行可能距離★★★★★", "残り" + superCar1.calcGas(10) + "km");

        // Carクラスのメソッド
        // Carクラスの機能を使う
        // +：文字列の連結
        car.showNumber();
//        car.showCarType();
//        Log.d("★★★★★車の走行可能距離★★★★★", "残り" + car.calcGas() + "km");
//        Log.d("★★★★★車の走行可能距離★★★★★", "残り" + car.calcGas(10) + "km");

        // car2のメソッド実行
//        car2.showNumber();
//        car2.showCarType();
//        Log.d("★★★★★car2の走行可能距離★★★★★", "残り" + car2.calcGas() + "km");
//        Log.d("★★★★★car2の走行可能距離★★★★★", "残り" + car2.calcGas(20) + "km");
    }
}
