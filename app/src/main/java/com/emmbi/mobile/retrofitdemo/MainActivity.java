package com.emmbi.mobile.retrofitdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.emmbi.mobile.retrofitdemo.model.CreateObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextView pinLabel = (TextView) findViewById(R.id.pin_label);

        Gson gson = new GsonBuilder()
                //.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://bebetrack.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CreateObject createObject = new CreateObject();
        createObject.setInternationalCode("321");
        createObject.setPhone("938 3838");

        ApiEndpointInterface apiEndpointInterface = retrofit.create(ApiEndpointInterface.class);
        Call<CreateObject> create = apiEndpointInterface.create(createObject);

        create.enqueue(new Callback<CreateObject>() {
            @Override
            public void onResponse(Response<CreateObject> response, Retrofit retrofit) {
                CreateObject responseObject = response.body();

                pinLabel.setText("Pin: " + responseObject.getPin());
                AccountManager.getToken(MainActivity.this);

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
