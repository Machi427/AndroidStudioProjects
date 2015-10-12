package com.example.makoto_o.javabasic;

import android.util.Log;

iimport android.util.Log;

public class Car {

    // フィールド：車に必要な情報

    // 車のナンバー
    public String number;
    // ガソリン量
    public int gas;
    // 車のタイプ
    public String carType;

    // コンストラクタ
    // フィールドに値をセットするために使われることが多い
    // コンストラクタは宣言しなくてもOK → なければシステムが勝手に作ってくれる
    public Car(String number, int gas, String carType) {
        // this:Carクラス(このクラス自身)を指す
        // 引数とフィールドが同じ名前だった時に、区別する際に使う
        this.number = number;
        this.gas = gas;
        this.carType = carType;
    }

    // コンストラクタは複数作れる→オーバーロードという機能があるから
    // オーバーロード:同じ名前のコンストラクタ(メソッド)を複数作ることができる機能
    // どうやって違いを判別しているか→引数
    // 引数の数、順序を見て判断
    // 引数、名前が全く同じコンストラクタを作ろうとするとエラーになる
    public Car() {

    }

    // メソッド：車の機能

    // 車のナンバーをお知らせする
    // void：返り値が帰ってこない
    public void showNumber() {
        Log.d("車のナンバー", number);
    }

    // 車のタイプをお知らせする
    public void showCarType() {
        Log.d("車のタイプ", carType);
    }

    // 車のガソリン量から、残り何キロ走れるか計算する
    // int型を返すメソッド
    public int calcGas() {
        int run = gas * 2;

        return run;
    }

    public int calcGas(int power) {
        int run = gas * power;

        return run;
    }

    public class car2 {

    }
}


// カレー作るメソッド
// 人参、玉ねぎなどが引数(カレー作りに必要な材料=メソッドを実行するのに必要なもの)
//    public Curry createCurry(人参、玉ねぎ、肉、ジャガイモ、ご飯) {
//        // カレーを作る処理
//
//        return curry;
//    }
