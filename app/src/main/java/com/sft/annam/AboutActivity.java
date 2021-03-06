package com.sft.annam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by SFT on 4/11/2016.
 */
public class AboutActivity extends AppCompatActivity {
    TextView appName;
    Button eula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeFullScreen();
        setContentView(R.layout.about);
        initViews();
        initButton();
        setAppName();
    }

    private void initButton() {
        eula = (Button) findViewById(R.id.eula);
        eula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AppEULA(AboutActivity.this).show();
            }
        });
    }

    private void initViews() {
        appName = (TextView)findViewById(R.id.appName);
    }

    private void setAppName() {
        appName.setText("Farmer App v1.0.0.6");
    }

    private void makeFullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void onBackPressed() {
        Intent ownerHome = new Intent(getApplicationContext(), Home.class);
        startActivity(ownerHome);
        AboutActivity.this.finish();
    }
}
