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

public class MainActivity3 extends AppCompatActivity {
    EditText searchanddelete;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final DatabaseHelper database = new DatabaseHelper(this);
        Button screen3to1 = (Button) findViewById(R.id.screen3to1);
        Button delete = (Button) findViewById(R.id.buttonDELETE);
        Button view = (Button) findViewById(R.id.buttonVIEW);
        searchanddelete = (EditText) findViewById(R.id.editTextDelete);
        count=0;

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = database.viewStudents();
                StringBuffer buffer = new StringBuffer();
                while(cursor.moveToNext()){
                    buffer.append("ID: " + cursor.getString(0) + " \n");
                    buffer.append("Name: " + cursor.getString(1) + " \n");
                    buffer.append("Phone: " + cursor.getString(2) + " \n");
                    buffer.append("Email: " + cursor.getString(3) + " \n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
                builder.setCancelable(true);
                builder.setTitle("All Students");
                builder.setMessage(buffer.toString());
                builder.show();
                Log.d("Yasmeen", "View Success");
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dlt = searchanddelete.getText().toString();
                if (TextUtils.isEmpty(searchanddelete.getText().toString())) {
                    Toast.makeText(MainActivity3.this, "Enter a value", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        database.deleteStudents(dlt);
                        count++;
                        Toast.makeText(getBaseContext(), count + " records deleted.", Toast.LENGTH_SHORT).show();
                        Log.d("Yasmeen", "Delete Success");
                    } catch (Exception e) {
                        Log.d("Yasmeen", "Delete FAIL");
                    }
                }
            }
        });

        screen3to1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity3.this, MainActivity.class));
            }
        });
    }
}