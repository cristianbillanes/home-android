package com.example.hometohome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class Log_In extends AppCompatActivity {
    private EditText email, password;
    private Button btn_login;
    private ProgressBar loading;
    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String EMAIL = "EMAIL";
    SharedPreferences_Class SharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        SharedPreferences = new SharedPreferences_Class(this);

        loading = findViewById(R.id.login_progressbar);
        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        btn_login = findViewById(R.id.login_button);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_email = email.getText().toString();
                String s_password = password.getText().toString();
                if(s_email.isEmpty()||s_password.isEmpty()){
                    email.setError("Please insert email");
                    password.setError("Please insert password");
                }else {
                    Loin_in(s_email,s_password);
                }
            }});
    }
    private void Loin_in(String s_email,String s_password){
        loading.setVisibility(View.VISIBLE);
        btn_login.setVisibility(View.GONE);
        final String email = s_email;
        final String password = s_password;
        //temporary and sample login
        String v_name ="", v_email="",v_id="";
        //temporary ans sample action
        Home(v_name,v_email,v_id);
        loading.setVisibility(View.GONE);
        btn_login.setVisibility(View.VISIBLE);
        //
    }
    private void Home(String v_name, String v_email, String id_value){
        SharedPreferences.createsession(v_name,v_email,id_value);
        Intent intent = new Intent(this, Home.class);
        intent.putExtra(ID, id_value);
        intent.putExtra(NAME, v_name);
        intent.putExtra(EMAIL, v_email);
        startActivity(intent);
    }
}