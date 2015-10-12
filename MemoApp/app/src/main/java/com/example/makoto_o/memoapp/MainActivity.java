package com.example.makoto_o.memoapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // ----------fields----------

    /** タイトル入力用エディットテキスト */
    private EditText titleEditText;
    /** コメント入力用エディットテキスト */
    private EditText commentEditText;

    /** プリファレンス */
    private SharedPreferences preferences;

    /** タイトル保存用キー */
    private static final String KEY_TITLE = "title";
    /** コメント保存用キー */
    private static final String KEY_COMMENT = "comment";
    /** 何も保存されていない時に返す文字列 */
    private static final String NOT_FOUND_DATA = "データが見つかりません。";

    // ----------methods----------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // レイアウトよりEditTextを取得
        titleEditText = (EditText) findViewById(R.id.titleEditText);
        commentEditText = (EditText) findViewById(R.id.commentEditText);

        // プリファレンスをデフォルト名で作成
        preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        // プリファレンスにデータが保存されていれば、保存されているデータをセットする
        if (!preferences.getString(KEY_TITLE, NOT_FOUND_DATA).equals(NOT_FOUND_DATA)) {
            titleEditText.setText(preferences.getString(KEY_TITLE, NOT_FOUND_DATA));
        }
        if (!preferences.getString(KEY_COMMENT, NOT_FOUND_DATA).equals(NOT_FOUND_DATA)) {
            commentEditText.setText(preferences.getString(KEY_COMMENT, NOT_FOUND_DATA));
        }

    }

}
