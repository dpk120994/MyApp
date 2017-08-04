package com.example.sourcekode1.myapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    EditText editText1,editText2,editText3;
    TextView textView;
    String f_name,l_name;
    DbOperations operations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1= (EditText) findViewById(R.id.edt1);
        editText2= (EditText) findViewById(R.id.edt2);
        editText3= (EditText) findViewById(R.id.edt3);
        textView= (TextView) findViewById(R.id.textview1);
        operations=new DbOperations(this);

    }
    public void add(View view)
    {
        f_name=editText1.getText().toString();
        l_name=editText2.getText().toString();

        if(operations.addInfo(f_name,l_name))
            Toast.makeText(MainActivity.this, "RECORD ADDED", Toast.LENGTH_SHORT).show();

    }
    public void get(View view)
    {

        Cursor cursor=operations.getInfo();
        String  f_name,l_name;

        while(cursor.moveToNext())
        {
            f_name=cursor.getString(0);
            l_name=cursor.getString(1);
            Toast.makeText(this, ""+f_name+" "+l_name, Toast.LENGTH_SHORT).show();
        }



    }
    public void getparticular(View view)
    {
        String a=editText3.getText().toString();
        Cursor cursor=operations.getInfoParticular(a);
        String  f_name,l_name;

        while(cursor.moveToNext())
        {

            l_name=cursor.getString(1);
            Toast.makeText(this,  ""+l_name, Toast.LENGTH_SHORT).show();
        }

    }


}
