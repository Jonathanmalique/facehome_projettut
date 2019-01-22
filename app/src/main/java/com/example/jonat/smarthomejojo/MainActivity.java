package com.example.jonat.smarthomejojo;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;

import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {
    //TextView monTexte = null;
/*    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView text = new TextView(this);
        text.setText("Bonjour, vous me devez 1 000 000€.");
        setContentView(text);

        text = new TextView(this);
        text.setText(R.string.hello_world);

        setContentView(text);
    }*/


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*monTexte = (TextView) findViewById(R.id.text);
        monTexte.setText("Le texte de notre TextView");*/
    }

    public void page1(View view) {
        startActivity(new Intent(this, menu.class));
    }

}
