package com.example.c.t03_widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTest = (Button) findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"btn click",Toast.LENGTH_LONG).show();
            }
        });


        CheckBox checkBox = (CheckBox) findViewById(R.id.cbTest);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "checkBox :"+isChecked, Toast.LENGTH_SHORT).show();
            }
        });


        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rbTest);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rb = (RadioButton) findViewById(checkedId);
                Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();

//                switch (checkedId){
//                    case R.id.rbTest1:
//                        Toast.makeText(MainActivity.this,"radio1 checked",Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.rbTest2:
//                        Toast.makeText(MainActivity.this, "radio2 checked", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.rbTest3:
//                        Toast.makeText(MainActivity.this, "radio3 checked", Toast.LENGTH_SHORT).show();
//                        break;
//                }
            }
        });


        Button btnOK = (Button)findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText)findViewById(R.id.editTest);
                String str = editText.getText().toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                editText.setText("");
            }
        });


        final EditText editText = (EditText) findViewById(R.id.editTest);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
    }
}
