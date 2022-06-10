package com.example.lorem2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {
      EditText name ;
      Button btn_add,btn_show;
      ListView list_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDatabase db= new MyDatabase(this,"scole",null,1);
        name=findViewById(R.id.txt_name);
        btn_add=findViewById(R.id.btn_add);
        btn_show=findViewById(R.id.btn_show);
        list_view=findViewById(R.id.list_view_stude);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     db.add(name.getText().toString());
            }
        });
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> list_stude=db.get_table();
                ArrayAdapter<String> adap=new ArrayAdapter<String>(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list_stude);
                list_view.setAdapter(adap);
            }
        });
    }
}