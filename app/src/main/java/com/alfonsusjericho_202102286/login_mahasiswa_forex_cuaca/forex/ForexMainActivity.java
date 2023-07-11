package com.alfonsusjericho_202102286.login_mahasiswa_forex_cuaca.forex;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.alfonsusjericho_202102286.login_mahasiswa_forex_cuaca.R;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.text.DecimalFormat;

import cz.msebera.android.httpclient.Header;

public class ForexMainActivity extends AppCompatActivity {
    private ProgressBar loadingBar;
    private SwipeRefreshLayout swipe1;
    private TextView btcTV, eurTV, idrTV, usdTV, hkdTV, bobTV, audTV, inrTV, phpTV, rubTV;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forex_main);
        swipe1 = findViewById(R.id.swipeRefreshLayout1);
        btcTV = findViewById(R.id.btcTextView);
        eurTV = findViewById(R.id.eurTextView);
        idrTV = findViewById(R.id.idrTextView);
        usdTV = findViewById(R.id.usdTextView);
        hkdTV = findViewById(R.id.hkdTextView);
        bobTV = findViewById(R.id.bobTextView);
        audTV = findViewById(R.id.audTextView);
        inrTV = findViewById(R.id.inrTextView);
        phpTV = findViewById(R.id.phpTextView);
        rubTV = findViewById(R.id.rubTextView);
        loadingBar = findViewById(R.id.loadingProgressBar);
        initForex();
        initSwipeRefreshLayout();
    }
    private void initSwipeRefreshLayout(){
        swipe1.setOnRefreshListener(() -> {
            initForex();
            swipe1.setRefreshing(false);
        });
    }

    private void initForex() {
        loadingBar.setVisibility(TextView.VISIBLE);
        String url = "https://openexchangerates.org/api/latest.json?app_id=a65bc2d5037744b18fcd55c85d11371f";
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                RootModel rootModel = gson.fromJson(new String(responseBody), RootModel.class);
                RatesModel ratesModel = rootModel.getRatesModel();

                double btc = ratesModel.getIDR() / ratesModel.getBTC();
                double eur = ratesModel.getIDR() / ratesModel.getEUR();
                double idr = ratesModel.getIDR();
                double usd = ratesModel.getIDR() / ratesModel.getUSD();
                double hkd = ratesModel.getIDR() / ratesModel.getHKD();
                double bob = ratesModel.getIDR() / ratesModel.getBOB();
                double aud = ratesModel.getIDR() / ratesModel.getAUD();
                double inr = ratesModel.getIDR() / ratesModel.getINR();
                double php = ratesModel.getIDR() / ratesModel.getPHP();
                double rub = ratesModel.getIDR() / ratesModel.getRUB();

                btcTV.setText(formatNumber(btc, "###,##0.##"));
                eurTV.setText(formatNumber(eur, "###,##0.##"));
                idrTV.setText(formatNumber(idr, "###,##0.##"));
                usdTV.setText(formatNumber(usd, "###,##0.##"));
                hkdTV.setText(formatNumber(hkd, "###,##0.##"));
                bobTV.setText(formatNumber(bob, "###,##0.##"));
                audTV.setText(formatNumber(aud, "###,##0.##"));
                inrTV.setText(formatNumber(inr, "###,##0.##"));
                phpTV.setText(formatNumber(php, "###,##0.##"));
                rubTV.setText(formatNumber(rub, "###,##0.##"));

                loadingBar.setVisibility(TextView.INVISIBLE);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                loadingBar.setVisibility(TextView.INVISIBLE);
            }
        });
    }

    public String formatNumber(double number, String format){
        DecimalFormat decimalFormat = new DecimalFormat(format);
        return decimalFormat.format(number);
    }

}