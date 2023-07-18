package com.alfonsusjericho_202102286.login_mahasiswa_forex_cuaca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.alfonsusjericho_202102286.login_mahasiswa_forex_cuaca.cuaca.CuacaMainActivity;
import com.alfonsusjericho_202102286.login_mahasiswa_forex_cuaca.forex.ForexMainActivity;
import com.alfonsusjericho_202102286.login_mahasiswa_forex_cuaca.intent.IntentMainActivity;
import com.alfonsusjericho_202102286.login_mahasiswa_forex_cuaca.mahasiswa.TampilMahasiswaActivity;

public class MenuActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "p";
    private Button _tampilMahasiswaButton, _tampilForexButton, _tampilCuacaButton, _tampilIntentButton;
    private Intent _tampilMahasiswaIntent, _tampilForexIntent, _tampilCuacaIntent, _tampilIntentIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        setTitle("Halo - " + name);

        setContentView(R.layout.activity_menu);
        initTampilMahasiswaButton();
        initTampilForexButton();
        initTampilCuacaButton();
        initTampilIntentButton();
    }
    private void initTampilMahasiswaButton(){
        _tampilMahasiswaButton = findViewById(R.id.tampilMahasiswaButton);

        _tampilMahasiswaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _tampilMahasiswaIntent = new Intent(getApplicationContext(), TampilMahasiswaActivity.class);
                startActivity(_tampilMahasiswaIntent);
            }
        });
    }

    private void initTampilForexButton(){
        _tampilForexButton = findViewById(R.id.tampilForexButton);
        _tampilForexButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _tampilForexIntent = new Intent(getApplicationContext(), ForexMainActivity.class);
                startActivity(_tampilForexIntent);
            }
        });
    }

    private void initTampilCuacaButton(){
        _tampilCuacaButton = findViewById(R.id.tampilCuacaButton);
        _tampilCuacaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _tampilCuacaIntent = new Intent(getApplicationContext(), CuacaMainActivity.class);
                startActivity(_tampilCuacaIntent);
            }
        });
    }
    private void initTampilIntentButton(){
        _tampilIntentButton = findViewById(R.id.tampilIntentButton);
        _tampilIntentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _tampilIntentIntent = new Intent(getApplicationContext(), IntentMainActivity.class);
                startActivity(_tampilIntentIntent);
            }
        });
    }


}