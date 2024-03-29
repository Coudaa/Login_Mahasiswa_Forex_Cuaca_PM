package com.alfonsusjericho_202102286.login_mahasiswa_forex_cuaca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private Button _loginButton;
    private EditText _idEditText, _passwordEditText;
    private Intent _menuIntent;
    private String _id, _password, _url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _idEditText = findViewById(R.id.idEditText);
        _loginButton = findViewById(R.id.loginButton);
        _passwordEditText = findViewById(R.id.passwordEditText);

        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _id = _idEditText.getText().toString();
                _password = _passwordEditText.getText().toString();
                _url = "https://stmikpontianak.net/011100862/login.php?id=" + _id + "&password=" + _password;

                AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
                asyncHttpClient.get(_url, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        String hasil = new String(responseBody);

                        if (!hasil.equals("[{\"idCount\":\"1\"}]")) {
                            Toast.makeText(getApplicationContext(), "ID dan password anda tidak cocok.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(getApplicationContext(), "Selamat datang, " + _id, Toast.LENGTH_SHORT).show();

                        _menuIntent = new Intent(getApplicationContext(), MenuActivity.class);
                        _menuIntent.putExtra(MenuActivity.EXTRA_NAME, _id);
                        startActivity(_menuIntent);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}