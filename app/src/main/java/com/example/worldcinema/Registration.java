package com.example.worldcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);



    }


    public void toStartMenu(View view) {
        Intent intent = new Intent(this, StartMenu.class);
        startActivity(intent);
        finish();
    }


    public void toMenu(View view){
        String firstname = ((TextView)findViewById(R.id.editTextTextEmailAddress4)).getText().toString();
        String lastname = ((TextView)findViewById(R.id.editTextTextEmailAddress3)).getText().toString();
        String email = ((TextView)findViewById(R.id.editTextTextEmailAddress)).getText().toString();
        String passwordFirst = ((TextView)findViewById(R.id.editTextTextPassword2)).getText().toString();
        String passwordSecond = ((TextView)findViewById(R.id.editTextTextPassword3)).getText().toString();

        if (email.isEmpty() || passwordFirst.isEmpty() || passwordSecond.isEmpty() || firstname.isEmpty() || lastname.isEmpty()){
            Toast.makeText(this,"Не все поля заполнены",Toast.LENGTH_LONG).show();
            return;
        }

        if(!email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(.[A-Za-z]{2,})$"))
        {
            Toast.makeText(this,"Некорректный адрес электронной почты",Toast.LENGTH_LONG).show();
            return;
        }

        if(!passwordFirst.equals(passwordSecond)){
            Toast.makeText(this,"Введенные пароли не совпадают",Toast.LENGTH_LONG).show();
            return;
        }

        String url = "http://cinema.areas.su/auth/register";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Registration.this, response.toString(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Registration.this, StartMenu.class);
                        startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                       Toast.makeText(Registration.this,"Регистрация не удалась",Toast.LENGTH_LONG).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("email", email);
                params.put("password", passwordFirst);
                params.put("firstName", firstname);
                params.put("lastName", lastname);

                return params;
            }
        };


        requestQueue.add(request);

    }
}