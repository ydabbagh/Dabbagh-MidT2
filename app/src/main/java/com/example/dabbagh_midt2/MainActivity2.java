package com.example.dabbagh_midt2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText searchQuery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final DatabaseHelper database = new DatabaseHelper(this);
        Button screen2to1 = (Button) findViewById(R.id.screen2to1);
        Button search = (Button) findViewById(R.id.buttonSEARCH);
        searchQuery = (EditText)findViewById(R.id.editTextSearch);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(searchQuery.getText().toString())) {
                    Toast.makeText(MainActivity2.this, "Enter a value to search ", Toast.LENGTH_LONG).show();
                } else {
                    String name_val = searchQuery.getText().toString();
                    Cursor cursor = database.findStudent(name_val);
                    try {
                        String id_find = cursor.getString(0);
                        String name_find = cursor.getString(1);
                        String phone_find = cursor.getString(2);
                        String email_find = cursor.getString(3);

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                        builder.setCancelable(true);
                        builder.setTitle("Student " + name_find + " " + " Info: ");
                        builder.setMessage("ID: " + id_find + " \n" +
                                "Name: " + name_find + " \n" +
                                "Phone: " + phone_find + " \n" +
                                "Email: " + email_find + " \n");
                        builder.show();
                        Log.d("Yasmeen", "Find Success");
                    } catch (Exception e) {
                        Log.d("Yasmeen", "Find FAIL");
                    }
                }
            }
        });

        screen2to1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
            }
        });
    }
}