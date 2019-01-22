package com.example.jonat.smarthomejojo;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class homep extends AppCompatActivity implements View.OnClickListener, Callback {

    boolean oncafsmile;
    boolean onlumsmile;
    boolean onventilonsmile;
    boolean onventiloffsmile;
    boolean oncaffrown;
    boolean onlumfrown;
    boolean onventilonfrown;
    boolean onventilofffrown;
    boolean oncafmouth;
    boolean onlummouth;
    boolean onventilonmouth;
    boolean onventiloffmouth;


    public SharedPreferences prefs;
    private String urlom = "http://192.168.43.224:8080/~/in-cse/in-name";
    private Snackbar snackbar;
    private final OkHttpClient client = new OkHttpClient();
    private TextView resultsTextViewn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        resultsTextViewn = new TextView(this);
        setContentView(R.layout.homeparam);
        resultsTextViewn = findViewById(R.id.textView7);;
        snackbar = Snackbar.make(findViewById(android.R.id.content), "Requête en cours d'exécution",
                Snackbar.LENGTH_INDEFINITE);


        Context context = getApplicationContext();
        prefs = PreferenceManager.getDefaultSharedPreferences(context);

        //CAFETIERE smile
        Switch cafSwitchsmile = findViewById(R.id.switch1);
        oncafsmile = prefs.getBoolean("Oncafsmile", false);  //default is true
        if (oncafsmile == true)
        {
            cafSwitchsmile.setChecked(true);
        }       else
        {
            cafSwitchsmile.setChecked(false);
        }

        //LUMIERE smile
        Switch lumSwitchsmile = findViewById(R.id.switch2);
        onlumsmile = prefs.getBoolean("Onlumsmile", false);  //default is true
        if (onlumsmile == true)
        {
            lumSwitchsmile.setChecked(true);
        }       else
        {
            lumSwitchsmile.setChecked(false);
        }

        //VENTILON smile
        Switch ventilonSwitchsmile = findViewById(R.id.switch3);
        onventilonsmile = prefs.getBoolean("Onventilonsmile", false);  //default is true
        if (onventilonsmile == true)
        {
            ventilonSwitchsmile.setChecked(true);
        }       else
        {
            ventilonSwitchsmile.setChecked(false);
        }

        //VENTILOFF smile
        Switch ventiloffSwitchsmile = findViewById(R.id.switch10);
        onventiloffsmile = prefs.getBoolean("Onventiloffsmile", false);  //default is true
        if (onventiloffsmile == true)
        {
            ventiloffSwitchsmile.setChecked(true);
        }       else
        {
            ventiloffSwitchsmile.setChecked(false);
        }

        ////////////////////////////////////////////////////////////////
        ////////FROWN
        //CAFETIERE frown
        Switch cafSwitchfrown = findViewById(R.id.switch5);
        oncaffrown = prefs.getBoolean("Oncaffrown", false);  //default is true
        if (oncaffrown == true)
        {
            cafSwitchfrown.setChecked(true);
        }       else
        {
            cafSwitchfrown.setChecked(false);
        }

        //LUMIERE frown
        Switch lumSwitchfrown = findViewById(R.id.switch4);
        onlumfrown = prefs.getBoolean("Onlumfrown", false);  //default is true
        if (onlumfrown == true)
        {
            lumSwitchfrown.setChecked(true);
        }       else
        {
            lumSwitchfrown.setChecked(false);
        }

        //VENTILON frown
        Switch ventilonSwitchfrown = findViewById(R.id.switch6);
        onventilonfrown = prefs.getBoolean("Onventilonfrown", false);  //default is true
        if (onventilonfrown == true)
        {
            ventilonSwitchfrown.setChecked(true);
        }       else
        {
            ventilonSwitchfrown.setChecked(false);
        }

        //VENTILOFF frown
        Switch ventiloffSwitchfrown = findViewById(R.id.switch11);
        onventilofffrown = prefs.getBoolean("Onventilofffrown", false);  //default is true
        if (onventilofffrown == true)
        {
            ventiloffSwitchfrown.setChecked(true);
        }       else
        {
            ventiloffSwitchfrown.setChecked(false);
        }


        //////////////////////////////////////////////////////////
        ///////////MOUTH
        //CAFETIERE mouth
        Switch cafSwitchmouth = findViewById(R.id.switch8);
        oncafmouth = prefs.getBoolean("Oncafmouth", false);  //default is true
        if (oncafmouth == true)
        {
            cafSwitchmouth.setChecked(true);
        }       else
        {
            cafSwitchmouth.setChecked(false);
        }

        //LUMIERE mouth
        Switch lumSwitchmouth = findViewById(R.id.switch7);
        onlummouth = prefs.getBoolean("Onlummouth", false);  //default is true
        if (onlummouth == true)
        {
            lumSwitchmouth.setChecked(true);
        }       else
        {
            lumSwitchmouth.setChecked(false);
        }

        //VENTILON mouth
        Switch ventilonSwitchmouth = findViewById(R.id.switch12);
        onventilonmouth = prefs.getBoolean("Onventilonmouth", false);  //default is true
        if (onventilonmouth == true)
        {
            ventilonSwitchmouth.setChecked(true);
        }       else
        {
            ventilonSwitchmouth.setChecked(false);
        }

        //VENTILOFF smile
        Switch ventiloffSwitchmouth = findViewById(R.id.switch9);
        onventiloffmouth = prefs.getBoolean("Onventiloffmouth", false);  //default is true
        if (onventiloffmouth == true)
        {
            ventiloffSwitchmouth.setChecked(true);
        }       else
        {
            ventiloffSwitchmouth.setChecked(false);
        }
    }
////////////////////////////////////////////////////////////////////////////
    ////////////sauver BOUTONS
    public void switchclickcaf_smile(View view) {

        oncafsmile = ((Switch) view).isChecked();
        if (oncafsmile) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Oncafsmile", true); // value to store
            editor.commit();

        } else {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Oncafsmile", false); // value to store
            editor.commit();
        }
    }

    public void switchclicklum_smile(View view) {

        onlumsmile = ((Switch) view).isChecked();
        if (onlumsmile) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Onlumsmile", true); // value to store
            editor.commit();

        } else {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Onlumsmile", false); // value to store
            editor.commit();
        }
    }

    public void switchclickventilon_smile(View view) {

        onventilonsmile = ((Switch) view).isChecked();
        if (onventilonsmile) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Onventilonsmile", true); // value to store
            editor.commit();

        } else {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Onventilonsmile", false); // value to store
            editor.commit();
        }
    }

    public void switchclickventiloff_smile(View view) {

        onventiloffsmile = ((Switch) view).isChecked();
        if (onventiloffsmile) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Onventiloffsmile", true); // value to store
            editor.commit();

        } else {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Onventiloffsmile", false); // value to store
            editor.commit();
        }
    }

    ////////////////////////////////////////////////
    public void switchclickcaf_frown(View view) {

        oncaffrown = ((Switch) view).isChecked();
        if (oncaffrown) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Oncaffrown", true); // value to store
            editor.commit();

        } else {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Oncaffrown", false); // value to store
            editor.commit();
        }
    }

    public void switchclicklum_frown(View view) {

        onlumfrown = ((Switch) view).isChecked();
        if (onlumfrown) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Onlumfrown", true); // value to store
            editor.commit();

        } else {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Onlumfrown", false); // value to store
            editor.commit();
        }
    }

    public void switchclickventilon_frown(View view) {

        onventilonfrown = ((Switch) view).isChecked();
        if (onventilonfrown) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Onventilonfrown", true); // value to store
            editor.commit();

        } else {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Onventilonfrown", false); // value to store
            editor.commit();
        }
    }

    public void switchclickventiloff_frown(View view) {

        onventilofffrown = ((Switch) view).isChecked();
        if (onventilofffrown) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Onventilofffrown", true); // value to store
            editor.commit();

        } else {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Onventilofffrown", false); // value to store
            editor.commit();
        }
    }

    ///////////////////////////////////////////////////////////////
    public void switchclickcaf_mouth(View view) {

        oncafmouth = ((Switch) view).isChecked();
        if (oncafmouth) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Oncafmouth", true); // value to store
            editor.commit();

        } else {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Oncafmouth", false); // value to store
            editor.commit();
        }
    }

    public void switchclicklum_mouth(View view) {

        onlummouth = ((Switch) view).isChecked();
        if (onlummouth) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Onlummouth", true); // value to store
            editor.commit();

        } else {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Onlummouth", false); // value to store
            editor.commit();
        }
    }

    public void switchclickventilon_mouth(View view) {

        onventilonmouth = ((Switch) view).isChecked();
        if (onventilonmouth) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Onventilonmouth", true); // value to store
            editor.commit();

        } else {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Onventilonmouth", false); // value to store
            editor.commit();
        }
    }

    public void switchclickventiloff_mouth(View view) {

        onventiloffmouth = ((Switch) view).isChecked();
        if (onventiloffmouth) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Onventiloffmouth", true); // value to store
            editor.commit();

        } else {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Onventiloffmouth", false); // value to store
            editor.commit();
        }
    }

////////////////////////////////////////////////////////////
    @Override
    public void onClick(View view){
        if (!isConnected()) {
            Snackbar.make(view, "Aucune connexion à internet.", Snackbar.LENGTH_LONG).show();
            return;
        }
        snackbar.show();


        Boolean cafetieresmile = prefs.getBoolean("Oncafsmile", true);
        if (cafetieresmile == true){
            String urlomMOTSO = urlom + "/MOTOR1/DATASO";
            MediaType XML = MediaType.parse("application/xml;ty=4");
            RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                    "    <cnf>message</cnf>\n" +
                    "    <con>\n" +
                    "      &lt;obj&gt;\n" +
                    "        &lt;str name=&quot;appId&quot; val=&quot;MOTOR1&quot;/&gt;\n" +
                    "        &lt;str name=&quot;category&quot; val=&quot;Servomotor &quot;/&gt;\n" +
                    "        &lt;int name=&quot;data&quot; val=&quot;1&quot;/&gt;\n" +
                    "        &lt;int name=&quot;unit&quot; val=&quot;1ON&quot;/&gt;\n" +
                    "      &lt;/obj&gt;\n" +
                    "    </con>\n" +
                    "</m2m:cin>");

            Request request = new Request.Builder()
                    .url(urlomMOTSO)
                    .header("X-M2M-Origin", "admin:admin")
                    .addHeader("Content-Type", "application/xml;ty=4")
                    .post(body)
                    .build();

            client.newCall(request).enqueue(this);
        }
        else if (cafetieresmile == false){
            String urlomMOTSO = urlom + "/MOTOR1/DATASO";
            MediaType XML = MediaType.parse("application/xml;ty=4");
            RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                    "    <cnf>message</cnf>\n" +
                    "    <con>\n" +
                    "      &lt;obj&gt;\n" +
                    "        &lt;str name=&quot;appId&quot; val=&quot;MOTOR1&quot;/&gt;\n" +
                    "        &lt;str name=&quot;category&quot; val=&quot;Servomotor &quot;/&gt;\n" +
                    "        &lt;int name=&quot;data&quot; val=&quot;0&quot;/&gt;\n" +
                    "        &lt;int name=&quot;unit&quot; val=&quot;0OFF&quot;/&gt;\n" +
                    "      &lt;/obj&gt;\n" +
                    "    </con>\n" +
                    "</m2m:cin>");

            Request request = new Request.Builder()
                    .url(urlomMOTSO)
                    .header("X-M2M-Origin", "admin:admin")
                    .addHeader("Content-Type", "application/xml;ty=4")
                    .post(body)
                    .build();

            client.newCall(request).enqueue(this);
        }

        Boolean lumieresmile = prefs.getBoolean("Onlumsmile", true);
        if (lumieresmile == true){
            String urlomLEDSO = urlom + "/LED1/DATASO";
            MediaType XML = MediaType.parse("application/xml;ty=4");
            RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                    "    <cnf>message</cnf>\n" +
                    "    <con>\n" +
                    "      &lt;obj&gt;\n" +
                    "        &lt;str name=&quot;appId&quot; val=&quot;LED1&quot;/&gt;\n" +
                    "        &lt;str name=&quot;category&quot; val=&quot;Light &quot;/&gt;\n" +
                    "        &lt;int name=&quot;data&quot; val=&quot;1&quot;/&gt;\n" +
                    "        &lt;int name=&quot;unit&quot; val=&quot;1ON&quot;/&gt;\n" +
                    "      &lt;/obj&gt;\n" +
                    "    </con>\n" +
                    "</m2m:cin>");

            Request request = new Request.Builder()
                    .url(urlomLEDSO)
                    .header("X-M2M-Origin", "admin:admin")
                    .addHeader("Content-Type", "application/xml;ty=4")
                    .post(body)
                    .build();

            client.newCall(request).enqueue(this);
        }
        else if (lumieresmile == false){
            String urlomLEDSO = urlom + "/LED1/DATASO";
            MediaType XML = MediaType.parse("application/xml;ty=4");
            RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                    "    <cnf>message</cnf>\n" +
                    "    <con>\n" +
                    "      &lt;obj&gt;\n" +
                    "        &lt;str name=&quot;appId&quot; val=&quot;LED1&quot;/&gt;\n" +
                    "        &lt;str name=&quot;category&quot; val=&quot;Light &quot;/&gt;\n" +
                    "        &lt;int name=&quot;data&quot; val=&quot;0&quot;/&gt;\n" +
                    "        &lt;int name=&quot;unit&quot; val=&quot;0OFF&quot;/&gt;\n" +
                    "      &lt;/obj&gt;\n" +
                    "    </con>\n" +
                    "</m2m:cin>");

            Request request = new Request.Builder()
                    .url(urlomLEDSO)
                    .header("X-M2M-Origin", "admin:admin")
                    .addHeader("Content-Type", "application/xml;ty=4")
                    .post(body)
                    .build();

            client.newCall(request).enqueue(this);
        }

        Boolean cafetierefrown = prefs.getBoolean("Oncaffrown", true);
        if (cafetierefrown == true){
            String urlomMOTNRV = urlom + "/MOTOR1/DATANRV";
            MediaType XML = MediaType.parse("application/xml;ty=4");
            RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                    "    <cnf>message</cnf>\n" +
                    "    <con>\n" +
                    "      &lt;obj&gt;\n" +
                    "        &lt;str name=&quot;appId&quot; val=&quot;MOTOR1&quot;/&gt;\n" +
                    "        &lt;str name=&quot;category&quot; val=&quot;Servomotor &quot;/&gt;\n" +
                    "        &lt;int name=&quot;data&quot; val=&quot;1&quot;/&gt;\n" +
                    "        &lt;int name=&quot;unit&quot; val=&quot;1ON&quot;/&gt;\n" +
                    "      &lt;/obj&gt;\n" +
                    "    </con>\n" +
                    "</m2m:cin>");

            Request request = new Request.Builder()
                    .url(urlomMOTNRV)
                    .header("X-M2M-Origin", "admin:admin")
                    .addHeader("Content-Type", "application/xml;ty=4")
                    .post(body)
                    .build();

            client.newCall(request).enqueue(this);
        }
        else if (cafetierefrown == false){
            String urlomMOTNRV = urlom + "/MOTOR1/DATANRV";
            MediaType XML = MediaType.parse("application/xml;ty=4");
            RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                    "    <cnf>message</cnf>\n" +
                    "    <con>\n" +
                    "      &lt;obj&gt;\n" +
                    "        &lt;str name=&quot;appId&quot; val=&quot;MOTOR1&quot;/&gt;\n" +
                    "        &lt;str name=&quot;category&quot; val=&quot;Servomotor &quot;/&gt;\n" +
                    "        &lt;int name=&quot;data&quot; val=&quot;0&quot;/&gt;\n" +
                    "        &lt;int name=&quot;unit&quot; val=&quot;0OFF&quot;/&gt;\n" +
                    "      &lt;/obj&gt;\n" +
                    "    </con>\n" +
                    "</m2m:cin>");

            Request request = new Request.Builder()
                    .url(urlomMOTNRV)
                    .header("X-M2M-Origin", "admin:admin")
                    .addHeader("Content-Type", "application/xml;ty=4")
                    .post(body)
                    .build();

            client.newCall(request).enqueue(this);
        }

        Boolean lumierefrown = prefs.getBoolean("Onlumfrown", true);
        if (lumierefrown == true){
            String urlomLEDNRV = urlom + "/LED1/DATANRV";
            MediaType XML = MediaType.parse("application/xml;ty=4");
            RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                    "    <cnf>message</cnf>\n" +
                    "    <con>\n" +
                    "      &lt;obj&gt;\n" +
                    "        &lt;str name=&quot;appId&quot; val=&quot;LED1&quot;/&gt;\n" +
                    "        &lt;str name=&quot;category&quot; val=&quot;Light &quot;/&gt;\n" +
                    "        &lt;int name=&quot;data&quot; val=&quot;1&quot;/&gt;\n" +
                    "        &lt;int name=&quot;unit&quot; val=&quot;1ON&quot;/&gt;\n" +
                    "      &lt;/obj&gt;\n" +
                    "    </con>\n" +
                    "</m2m:cin>");

            Request request = new Request.Builder()
                    .url(urlomLEDNRV)
                    .header("X-M2M-Origin", "admin:admin")
                    .addHeader("Content-Type", "application/xml;ty=4")
                    .post(body)
                    .build();

            client.newCall(request).enqueue(this);
        }
        else if (lumierefrown == false){
            String urlomLEDNRV = urlom + "/LED1/DATANRV";
            MediaType XML = MediaType.parse("application/xml;ty=4");
            RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                    "    <cnf>message</cnf>\n" +
                    "    <con>\n" +
                    "      &lt;obj&gt;\n" +
                    "        &lt;str name=&quot;appId&quot; val=&quot;LED1&quot;/&gt;\n" +
                    "        &lt;str name=&quot;category&quot; val=&quot;Light &quot;/&gt;\n" +
                    "        &lt;int name=&quot;data&quot; val=&quot;0&quot;/&gt;\n" +
                    "        &lt;int name=&quot;unit&quot; val=&quot;0OFF&quot;/&gt;\n" +
                    "      &lt;/obj&gt;\n" +
                    "    </con>\n" +
                    "</m2m:cin>");

            Request request = new Request.Builder()
                    .url(urlomLEDNRV)
                    .header("X-M2M-Origin", "admin:admin")
                    .addHeader("Content-Type", "application/xml;ty=4")
                    .post(body)
                    .build();

            client.newCall(request).enqueue(this);
        }


        Boolean cafetieremouth = prefs.getBoolean("Oncafmouth", true);
        if (cafetieremouth == true){
            String urlomMOTBO = urlom + "/MOTOR1/DATABO";
            MediaType XML = MediaType.parse("application/xml;ty=4");
            RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                    "    <cnf>message</cnf>\n" +
                    "    <con>\n" +
                    "      &lt;obj&gt;\n" +
                    "        &lt;str name=&quot;appId&quot; val=&quot;MOTOR1&quot;/&gt;\n" +
                    "        &lt;str name=&quot;category&quot; val=&quot;Servomotor &quot;/&gt;\n" +
                    "        &lt;int name=&quot;data&quot; val=&quot;1&quot;/&gt;\n" +
                    "        &lt;int name=&quot;unit&quot; val=&quot;1ON&quot;/&gt;\n" +
                    "      &lt;/obj&gt;\n" +
                    "    </con>\n" +
                    "</m2m:cin>");

            Request request = new Request.Builder()
                    .url(urlomMOTBO)
                    .header("X-M2M-Origin", "admin:admin")
                    .addHeader("Content-Type", "application/xml;ty=4")
                    .post(body)
                    .build();

            client.newCall(request).enqueue(this);
        }
        else if (cafetieremouth == false){
            String urlomMOTBO = urlom + "/MOTOR1/DATABO";
            MediaType XML = MediaType.parse("application/xml;ty=4");
            RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                    "    <cnf>message</cnf>\n" +
                    "    <con>\n" +
                    "      &lt;obj&gt;\n" +
                    "        &lt;str name=&quot;appId&quot; val=&quot;MOTOR1&quot;/&gt;\n" +
                    "        &lt;str name=&quot;category&quot; val=&quot;Servomotor &quot;/&gt;\n" +
                    "        &lt;int name=&quot;data&quot; val=&quot;0&quot;/&gt;\n" +
                    "        &lt;int name=&quot;unit&quot; val=&quot;0OFF&quot;/&gt;\n" +
                    "      &lt;/obj&gt;\n" +
                    "    </con>\n" +
                    "</m2m:cin>");

            Request request = new Request.Builder()
                    .url(urlomMOTBO)
                    .header("X-M2M-Origin", "admin:admin")
                    .addHeader("Content-Type", "application/xml;ty=4")
                    .post(body)
                    .build();

            client.newCall(request).enqueue(this);
        }

        Boolean lumieremouth = prefs.getBoolean("Onlummouth", true);
        if (lumieremouth == true){
            String urlomLEDBO = urlom + "/LED1/DATABO";
            MediaType XML = MediaType.parse("application/xml;ty=4");
            RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                    "    <cnf>message</cnf>\n" +
                    "    <con>\n" +
                    "      &lt;obj&gt;\n" +
                    "        &lt;str name=&quot;appId&quot; val=&quot;LED1&quot;/&gt;\n" +
                    "        &lt;str name=&quot;category&quot; val=&quot;Light &quot;/&gt;\n" +
                    "        &lt;int name=&quot;data&quot; val=&quot;1&quot;/&gt;\n" +
                    "        &lt;int name=&quot;unit&quot; val=&quot;1ON&quot;/&gt;\n" +
                    "      &lt;/obj&gt;\n" +
                    "    </con>\n" +
                    "</m2m:cin>");

            Request request = new Request.Builder()
                    .url(urlomLEDBO)
                    .header("X-M2M-Origin", "admin:admin")
                    .addHeader("Content-Type", "application/xml;ty=4")
                    .post(body)
                    .build();

            client.newCall(request).enqueue(this);
        }
        else if (lumieremouth == false){
            String urlomLEDBO = urlom + "/LED1/DATABO";
            MediaType XML = MediaType.parse("application/xml;ty=4");
            RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                    "    <cnf>message</cnf>\n" +
                    "    <con>\n" +
                    "      &lt;obj&gt;\n" +
                    "        &lt;str name=&quot;appId&quot; val=&quot;LED1&quot;/&gt;\n" +
                    "        &lt;str name=&quot;category&quot; val=&quot;Light &quot;/&gt;\n" +
                    "        &lt;int name=&quot;data&quot; val=&quot;0&quot;/&gt;\n" +
                    "        &lt;int name=&quot;unit&quot; val=&quot;0OFF&quot;/&gt;\n" +
                    "      &lt;/obj&gt;\n" +
                    "    </con>\n" +
                    "</m2m:cin>");

            Request request = new Request.Builder()
                    .url(urlomLEDBO)
                    .header("X-M2M-Origin", "admin:admin")
                    .addHeader("Content-Type", "application/xml;ty=4")
                    .post(body)
                    .build();

            client.newCall(request).enqueue(this);
        }

        Boolean ventilonsmile = prefs.getBoolean("Onventilonsmile", true);
        Boolean ventiloffsmile = prefs.getBoolean("Onventiloffsmile", true);
        String urlomFANSO = urlom + "/FAN1/DATASO";
        if (ventilonsmile == true){
            if (ventiloffsmile == false) {

                MediaType XML = MediaType.parse("application/xml;ty=4");
                RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                        "    <cnf>message</cnf>\n" +
                        "    <con>\n" +
                        "      &lt;obj&gt;\n" +
                        "        &lt;str name=&quot;appId&quot; val=&quot;FAN1&quot;/&gt;\n" +
                        "        &lt;str name=&quot;category&quot; val=&quot;Ventil &quot;/&gt;\n" +
                        "        &lt;int name=&quot;data&quot; val=&quot;1&quot;/&gt;\n" +
                        "        &lt;int name=&quot;unit&quot; val=&quot;1ON&quot;/&gt;\n" +
                        "      &lt;/obj&gt;\n" +
                        "    </con>\n" +
                        "</m2m:cin>");

                Request request = new Request.Builder()
                        .url(urlomFANSO)
                        .header("X-M2M-Origin", "admin:admin")
                        .addHeader("Content-Type", "application/xml;ty=4")
                        .post(body)
                        .build();

                client.newCall(request).enqueue(this);
            }
        }
        else if (ventilonsmile == false){
            if (ventiloffsmile == true){
                MediaType XML = MediaType.parse("application/xml;ty=4");
                RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                        "    <cnf>message</cnf>\n" +
                        "    <con>\n" +
                        "      &lt;obj&gt;\n" +
                        "        &lt;str name=&quot;appId&quot; val=&quot;FAN1&quot;/&gt;\n" +
                        "        &lt;str name=&quot;category&quot; val=&quot;Ventil &quot;/&gt;\n" +
                        "        &lt;int name=&quot;data&quot; val=&quot;0&quot;/&gt;\n" +
                        "        &lt;int name=&quot;unit&quot; val=&quot;0OFF&quot;/&gt;\n" +
                        "      &lt;/obj&gt;\n" +
                        "    </con>\n" +
                        "</m2m:cin>");

                Request request = new Request.Builder()
                        .url(urlomFANSO)
                        .header("X-M2M-Origin", "admin:admin")
                        .addHeader("Content-Type", "application/xml;ty=4")
                        .post(body)
                        .build();

                client.newCall(request).enqueue(this);
            }
            else if (ventiloffsmile == false){
                MediaType XML = MediaType.parse("application/xml;ty=4");
                RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                        "    <cnf>message</cnf>\n" +
                        "    <con>\n" +
                        "      &lt;obj&gt;\n" +
                        "        &lt;str name=&quot;appId&quot; val=&quot;FAN1&quot;/&gt;\n" +
                        "        &lt;str name=&quot;category&quot; val=&quot;Ventil &quot;/&gt;\n" +
                        "        &lt;int name=&quot;data&quot; val=&quot;2&quot;/&gt;\n" +
                        "        &lt;int name=&quot;unit&quot; val=&quot;2NOTHING&quot;/&gt;\n" +
                        "      &lt;/obj&gt;\n" +
                        "    </con>\n" +
                        "</m2m:cin>");

                Request request = new Request.Builder()
                        .url(urlomFANSO)
                        .header("X-M2M-Origin", "admin:admin")
                        .addHeader("Content-Type", "application/xml;ty=4")
                        .post(body)
                        .build();

                client.newCall(request).enqueue(this);
            }
        }


        Boolean ventilonfrown = prefs.getBoolean("Onventilonfrown", true);
        Boolean ventilofffrown = prefs.getBoolean("Onventilofffrown", true);
        String urlomFANNRV = urlom + "/FAN1/DATANRV";
        if (ventilonfrown == true){
            if (ventilofffrown == false) {

                MediaType XML = MediaType.parse("application/xml;ty=4");
                RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                        "    <cnf>message</cnf>\n" +
                        "    <con>\n" +
                        "      &lt;obj&gt;\n" +
                        "        &lt;str name=&quot;appId&quot; val=&quot;FAN1&quot;/&gt;\n" +
                        "        &lt;str name=&quot;category&quot; val=&quot;Ventil &quot;/&gt;\n" +
                        "        &lt;int name=&quot;data&quot; val=&quot;1&quot;/&gt;\n" +
                        "        &lt;int name=&quot;unit&quot; val=&quot;1ON&quot;/&gt;\n" +
                        "      &lt;/obj&gt;\n" +
                        "    </con>\n" +
                        "</m2m:cin>");

                Request request = new Request.Builder()
                        .url(urlomFANNRV)
                        .header("X-M2M-Origin", "admin:admin")
                        .addHeader("Content-Type", "application/xml;ty=4")
                        .post(body)
                        .build();

                client.newCall(request).enqueue(this);
            }
        }
        else if (ventilonfrown == false){
            if (ventilofffrown == true){
                MediaType XML = MediaType.parse("application/xml;ty=4");
                RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                        "    <cnf>message</cnf>\n" +
                        "    <con>\n" +
                        "      &lt;obj&gt;\n" +
                        "        &lt;str name=&quot;appId&quot; val=&quot;FAN1&quot;/&gt;\n" +
                        "        &lt;str name=&quot;category&quot; val=&quot;Ventil &quot;/&gt;\n" +
                        "        &lt;int name=&quot;data&quot; val=&quot;0&quot;/&gt;\n" +
                        "        &lt;int name=&quot;unit&quot; val=&quot;0OFF&quot;/&gt;\n" +
                        "      &lt;/obj&gt;\n" +
                        "    </con>\n" +
                        "</m2m:cin>");

                Request request = new Request.Builder()
                        .url(urlomFANNRV)
                        .header("X-M2M-Origin", "admin:admin")
                        .addHeader("Content-Type", "application/xml;ty=4")
                        .post(body)
                        .build();

                client.newCall(request).enqueue(this);
            }
            else if (ventilofffrown == false){
                MediaType XML = MediaType.parse("application/xml;ty=4");
                RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                        "    <cnf>message</cnf>\n" +
                        "    <con>\n" +
                        "      &lt;obj&gt;\n" +
                        "        &lt;str name=&quot;appId&quot; val=&quot;FAN1&quot;/&gt;\n" +
                        "        &lt;str name=&quot;category&quot; val=&quot;Ventil &quot;/&gt;\n" +
                        "        &lt;int name=&quot;data&quot; val=&quot;2&quot;/&gt;\n" +
                        "        &lt;int name=&quot;unit&quot; val=&quot;2NOTHING&quot;/&gt;\n" +
                        "      &lt;/obj&gt;\n" +
                        "    </con>\n" +
                        "</m2m:cin>");

                Request request = new Request.Builder()
                        .url(urlomFANNRV)
                        .header("X-M2M-Origin", "admin:admin")
                        .addHeader("Content-Type", "application/xml;ty=4")
                        .post(body)
                        .build();

                client.newCall(request).enqueue(this);
            }
        }


        Boolean ventilonmouth = prefs.getBoolean("Onventilonmouth", true);
        Boolean ventiloffmouth = prefs.getBoolean("Onventiloffmouth", true);
        String urlomFANBO = urlom + "/FAN1/DATABO";
        if (ventilonmouth == true){
            if (ventiloffmouth == false) {

                MediaType XML = MediaType.parse("application/xml;ty=4");
                RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                        "    <cnf>message</cnf>\n" +
                        "    <con>\n" +
                        "      &lt;obj&gt;\n" +
                        "        &lt;str name=&quot;appId&quot; val=&quot;FAN1&quot;/&gt;\n" +
                        "        &lt;str name=&quot;category&quot; val=&quot;Ventil &quot;/&gt;\n" +
                        "        &lt;int name=&quot;data&quot; val=&quot;1&quot;/&gt;\n" +
                        "        &lt;int name=&quot;unit&quot; val=&quot;1ON&quot;/&gt;\n" +
                        "      &lt;/obj&gt;\n" +
                        "    </con>\n" +
                        "</m2m:cin>");

                Request request = new Request.Builder()
                        .url(urlomFANBO)
                        .header("X-M2M-Origin", "admin:admin")
                        .addHeader("Content-Type", "application/xml;ty=4")
                        .post(body)
                        .build();

                client.newCall(request).enqueue(this);
            }
        }
        else if (ventilonmouth == false){
            if (ventiloffmouth == true){
                MediaType XML = MediaType.parse("application/xml;ty=4");
                RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                        "    <cnf>message</cnf>\n" +
                        "    <con>\n" +
                        "      &lt;obj&gt;\n" +
                        "        &lt;str name=&quot;appId&quot; val=&quot;FAN1&quot;/&gt;\n" +
                        "        &lt;str name=&quot;category&quot; val=&quot;Ventil &quot;/&gt;\n" +
                        "        &lt;int name=&quot;data&quot; val=&quot;0&quot;/&gt;\n" +
                        "        &lt;int name=&quot;unit&quot; val=&quot;0OFF&quot;/&gt;\n" +
                        "      &lt;/obj&gt;\n" +
                        "    </con>\n" +
                        "</m2m:cin>");

                Request request = new Request.Builder()
                        .url(urlomFANBO)
                        .header("X-M2M-Origin", "admin:admin")
                        .addHeader("Content-Type", "application/xml;ty=4")
                        .post(body)
                        .build();

                client.newCall(request).enqueue(this);
            }
            else if (ventiloffmouth == false){
                MediaType XML = MediaType.parse("application/xml;ty=4");
                RequestBody body = RequestBody.create(XML, "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" +
                        "    <cnf>message</cnf>\n" +
                        "    <con>\n" +
                        "      &lt;obj&gt;\n" +
                        "        &lt;str name=&quot;appId&quot; val=&quot;FAN1&quot;/&gt;\n" +
                        "        &lt;str name=&quot;category&quot; val=&quot;Ventil &quot;/&gt;\n" +
                        "        &lt;int name=&quot;data&quot; val=&quot;2&quot;/&gt;\n" +
                        "        &lt;int name=&quot;unit&quot; val=&quot;2NOTHING&quot;/&gt;\n" +
                        "      &lt;/obj&gt;\n" +
                        "    </con>\n" +
                        "</m2m:cin>");

                Request request = new Request.Builder()
                        .url(urlomFANBO)
                        .header("X-M2M-Origin", "admin:admin")
                        .addHeader("Content-Type", "application/xml;ty=4")
                        .post(body)
                        .build();

                client.newCall(request).enqueue(this);
            }
        }



        //.addHeader("Host", "192.168.43.234")
        //.addHeader("Connection", "close")
    }






    ////////////////////////////////////////
    ////REPONSES REQUETES
    ///
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
                resultsTextViewn.setText("Erreur");
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
                resultsTextViewn.setText(body);
                snackbar.dismiss();
            }
        });
    }

}
