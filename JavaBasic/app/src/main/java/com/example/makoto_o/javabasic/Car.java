package com.example.makoto_o.javabasic;

import android.util.Log;

/**
 * Created by makoto_o on 15/10/10.
 */
public class Car {
    //フィールド
    //車に必要な情報

    //車のナンバー
    public String number;
    //ガソリン量
    public int gas;
    //車のタイプ
    public String carType;

    //車のナンバーをお知らせする
    //void 返り値が帰ってこない
    public void showNumber() {
        Log.d("車のナンバー", number);
    }

    //車のタイプをお知らせする
    public void showCarType() {
        Log.d("車のタイプ", carType);
    }

    //車のガソリン量から、残り何キロ走れるかを計算する
    //int型を返すメソッド
    public int calcGas() {
        int num = gas * 2;

        return num;
    }
}
