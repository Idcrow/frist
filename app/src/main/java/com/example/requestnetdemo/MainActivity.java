package com.example.requestnetdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.requestnetdemo.bead.User;
import com.squareup.okhttp.Request;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
/*tianshengjie  dsfsd*/
    private Button okhttpButton,okGo,retrofitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          okhttpButton = findViewById(R.id.okhttp_button);
          okGo= findViewById(R.id.ok_go);
          retrofitButton = findViewById(R.id.retrofit_button);
          okhttpButton.setOnClickListener(this);
          okGo.setOnClickListener(this);
          retrofitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.okhttp_button:
              Toast.makeText(this, "okhttp_button", Toast.LENGTH_SHORT).show();
                OkHttpClientManager.getAsyn("http://192.168.56.1:8080/okHttpServer/user!getUser",
                        new OkHttpClientManager.ResultCallback<User>()
                        {
                            @Override
                            public void onError(Request request, Exception e)
                            {
                                e.printStackTrace();
                            }

                            @Override
                            public void onResponse(User user)
                            {
                                //        mTv.setText(u.toString());//UI线程
                            }
                        });

                break;
            case R.id.ok_go:
                Toast.makeText(this, "ok_go", Toast.LENGTH_SHORT).show();
                break;
            case R.id.retrofit_button:
                Toast.makeText(this, "retrofit_button", Toast.LENGTH_SHORT).show();
                break;
        }
    }


}
