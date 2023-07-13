package com.alfonsusjericho_202102286.login_mahasiswa_forex_cuaca.cuaca;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.alfonsusjericho_202102286.login_mahasiswa_forex_cuaca.R;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class CuacaMainActivity extends AppCompatActivity {

    private RecyclerView _recyclerView2;
    private SwipeRefreshLayout _swipeRefreshLayout2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        _recyclerView2 = findViewById(R.id.recyclerView2);
        _swipeRefreshLayout2 = findViewById(R.id.swipeRefreshLayout2);

        initRecyclerView2();
        initSwipeRefreshLayout2();
    }

    private void initSwipeRefreshLayout2() {
        _swipeRefreshLayout2.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initRecyclerView2();
                _swipeRefreshLayout2.setRefreshing(false);
            }
        });
    }

    private void initRecyclerView2() {
        String url = "https://api.openweathermap.org/data/2.5/forecast?id=1630789&appid=b9ca6756e58c63d263c8d82e856b8d6c";
        AsyncHttpClient ahc = new AsyncHttpClient();

        ahc.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                RootModel rm = gson.fromJson(new String(responseBody), RootModel.class);
                RecyclerView.LayoutManager lm = new LinearLayoutManager(CuacaMainActivity.this);
                CuacaAdapter ca = new CuacaAdapter(rm);

                _recyclerView2.setLayoutManager(lm);
                _recyclerView2.setAdapter(ca);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}