package com.example.jonat.smarthomejojo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.FragmentTransaction;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class record extends AppCompatActivity implements View.OnClickListener, Callback{

    private String urlom = "http://192.168.43.234:8080/~/server";
    private TextView resultsTextView;
    private Snackbar snackbar;

    private final OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        resultsTextView = new TextView(this);
        setContentView(R.layout.recordface);
        resultsTextView = findViewById(R.id.textView5);;
        snackbar = Snackbar.make(findViewById(android.R.id.content), "Requête en cours d'exécution",
                Snackbar.LENGTH_INDEFINITE);
    }


    @Override
    public void onClick(View view){
        if (!isConnected()) {
            Snackbar.make(view, "Aucune connexion à internet.", Snackbar.LENGTH_LONG).show();
            return;
        }
        snackbar.show();

        Request request = new Request.Builder()
                .url(urlom)
                .get()
                .header("X-M2M-Origin", "admin:Cae-admin")
                .addHeader("Accept", "application/xml")
                .build();

        client.newCall(request).enqueue(this);
    }

    private boolean isConnected() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    @Override
    public void onFailure(Call call, IOException e) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                resultsTextView.setText("Erreur");
                snackbar.dismiss();
            }
        });
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        if (!response.isSuccessful()) {
            throw new IOException(response.toString());
        }

        final String body = response.body().string();

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                resultsTextView.setText(body);
                snackbar.dismiss();
            }
        });
    }
}
