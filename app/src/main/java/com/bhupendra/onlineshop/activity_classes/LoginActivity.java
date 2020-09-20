package com.bhupendra.onlineshop.activity_classes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bhupendra.onlineshop.R;
import com.bhupendra.onlineshop.required_classes.LoginBll;
import com.bhupendra.onlineshop.required_classes.StrictModeClass;

public class LoginActivity extends AppCompatActivity {

    TextView txtCreate,tvLogin;
    EditText editText_email, editText_password;
    Button btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        txtCreate = findViewById(R.id.create);
        txtCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
        btn_login = findViewById(R.id.btnLogin);
        editText_email = findViewById(R.id.etEmail);
        editText_password = findViewById(R.id.etPassword);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

    }

    private void login() {
        String email = editText_email.getText().toString();
        String password = editText_password.getText().toString();
        LoginBll loginBLL = new LoginBll();
        StrictModeClass.StrictMode();
        if (loginBLL.checkuser(email, password)) {
            // Intent intent = new Intent(LoginActivity.this, MainPageActivity.class);
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
            editText_email.requestFocus();
        }


    }

}
