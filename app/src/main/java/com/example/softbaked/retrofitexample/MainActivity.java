package com.example.softbaked.retrofitexample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.softbaked.retrofitexample.api.RetrofitManager;
import com.example.softbaked.retrofitexample.api.time.TimeService;
import com.example.softbaked.retrofitexample.api.time.model.ServerTimeGson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private Button mButtonPushToRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textview_main);
        mButtonPushToRequest = (Button) findViewById(R.id.button_main);
        mButtonPushToRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestServerTime(view.getContext());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void requestServerTime(final Context contextForToast) {
        TimeService service = RetrofitManager.getRetrofit().create(TimeService.class);
        Call<ServerTimeGson> call = service.getServerTime();
        call.enqueue(new Callback<ServerTimeGson>() {
            @Override
            public void onResponse(Call<ServerTimeGson> call, Response<ServerTimeGson> response) {
                if (response.isSuccessful()) {
                    setTimeData(response.body());
                } else {
                    Toast.makeText(contextForToast, "onResponse is not successful", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ServerTimeGson> call, Throwable t) {
                Toast.makeText(contextForToast, "onFailure : " + t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setTimeData(ServerTimeGson data) {
        String serverTime = data.getServerTime();
        int status = data.getStatus();
        mTextView.setText("Server Time : " + serverTime + " \n " + "Status : " + status);
    }
}
