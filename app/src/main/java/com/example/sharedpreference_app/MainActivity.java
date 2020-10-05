package com.example.sharedpreference_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextName, editTextPhone, editTextEmail;
    Button buttonSave;

    public static final String MYPREFERENCES = "ThePrefs";
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";

    SharedPreferences mypreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intialize Views
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);

        buttonSave =(Button) findViewById(R.id.buttonSave);

        //Introduce Shared Prefference
        mypreferences = getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = editTextName.getText().toString();
                String ph = editTextPhone.getText().toString();
                String e = editTextEmail.getText().toString();

                SharedPreferences.Editor Meditor = mypreferences.edit();
                Meditor.putString(Name,n);
                Meditor.putString(Phone,ph);
                Meditor.putString(Email,e);
                Meditor.commit();
                Toast.makeText(MainActivity.this, "Done!!!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}