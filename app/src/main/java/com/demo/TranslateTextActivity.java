package com.demo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class TranslateTextActivity extends AppCompatActivity {
    EditText text;
    TextView englishText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.enter_text);
        englishText = findViewById(R.id.translatedText);

    }

    public void translate(View v) {

        TranslateAPI translateAPI = new TranslateAPI(
                Language.ENGLISH,   //Source Language
                Language.HINDI,         //Target Language
                text.getText().toString());           //Query Text

        translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
            @Override
            public void onSuccess(String translatedText) {
                Log.d("TAG", "onSuccess: "+translatedText);
                englishText.setText(translatedText);
            }
            @Override
            public void onFailure(String ErrorText) {
                Log.d("TAG", "onFailure: "+ErrorText);
            }
        });
    }
}