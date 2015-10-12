package com.example.makoto_o.javabasic;

import android.util.Log;

/**
 * Created by Hitoshi on 2015/10/11.
 */

// 継承 クラスを拡張する(パワーアップさせる)
// 1つまでしか継承できない
// 継承先(サブクラス) extends 継承元(スーパークラス)
// スーパークラスのフィールド、メソッドを引き継いでいる。
// コンストラクタは引き継がれません。
// SuperCarはCarのサブクラス
public class SuperCar extends Car {

    // オーバーライド スーパークラスにあるメソッドを上書きする
    // @Override オーバーライド時に、スペルミスを防いでくれる
    @Override
    public void showNumber() {
        // D/車のナンバー: C99999
        super.showNumber();

        // D/スーパーカーのナンバー: C99999
        Log.d("スーパーカーのナンバー", number);
    }

}
