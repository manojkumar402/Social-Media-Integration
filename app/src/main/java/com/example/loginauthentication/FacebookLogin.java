package com.example.loginauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;

public class FacebookLogin extends AppCompatActivity {

    private TextView mName,mEmail,mId;
    ImageView imageView;
    Button button;
    CallbackManager callbackManager;
    FacebookSdk facebookSdk;
    LoginManager loginManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        facebookSdk.sdkInitialize(getApplicationContext());
        mName = findViewById(R.id.textView);
        mEmail = findViewById(R.id.textView2);
        mId = findViewById(R.id.textView3);
        imageView = findViewById(R.id.roundedimage);
        button = findViewById(R.id.button2);
        Intent intent = getIntent();
        String first_name = intent.getStringExtra("FName");
        String last_name = intent.getStringExtra("LName");
        String email = intent.getStringExtra("Email");
        String id = intent.getStringExtra("Id");
        mName.setText(first_name + " "+ last_name);
        mEmail.setText(email);
        mId.setText(id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                Intent intent1 = new Intent(FacebookLogin.this,MainActivity.class);
                startActivity(intent1);
                Toast.makeText(FacebookLogin.this, "you have signed out successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

}