package com.example.jomdobi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText email_login;
    EditText password_login;
    Button login_btn;
    TextView click_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email_login = findViewById(R.id.email_login);
        password_login = findViewById(R.id.password_login);
        login_btn = findViewById(R.id.login_btn);
        click_signup = (TextView) findViewById(R.id.click_signup);

        click_signup.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Signup.class);
                startActivity(intent);
            }
        });
    }

    public void ShowHidePass(View view){

        if(view.getId()==R.id.show_pass){

            if(password_login.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                ((ImageView)(view)).setImageResource(R.drawable.ic_baseline_remove_red_eye_24);

                //Show Password
                password_login.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
            else{
                ((ImageView)(view)).setImageResource(R.drawable.ic_baseline_remove_red_eye_24);

                //Hide Password
                password_login.setTransformationMethod(PasswordTransformationMethod.getInstance());

            }
        }
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (isEmpty(password_login)) {
            Toast t = Toast.makeText(this, "You must enter password to register!", Toast.LENGTH_SHORT);
            t.show();
        }

        if (isEmail(email_login) == false) {
            email_login.setError("Enter email!");
        }



    }
}