package com.psm2901.t22_style;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView selectedTextView, workingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedTextView = (TextView) findViewById(R.id.selectedTextView);
        workingTextView = (TextView) findViewById(R.id.workingTextView);

//        Button zeroButton = (Button) findViewById(R.id.zeroButton);
//        Button oneButton = (Button) findViewById(R.id.oneButton);
//        Button enterButton = (Button) findViewById(R.id.enterButton);
//
        View.OnClickListener numberListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) v;
                String working = workingTextView.getText().toString();
                String text = btn.getText().toString();
                if(working.equals("0")){
                    workingTextView.setText(text);
                }else{
                    workingTextView.setText(working+text);
                }

            }
        };

//        zeroButton.setOnClickListener(numberListner);
//        oneButton.setOnClickListener(numberListner);
//
//
//
//        enterButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String working = workingTextView.getText().toString();
//                selectedTextView.setText(working);
//                workingTextView.setText("0");
//            }
//        });


        TableLayout tableLayout = (TableLayout)findViewById(R.id.tableLayout);

        int number = 1;
        for(int i=2;i<tableLayout.getChildCount()-1;i++){
            TableRow row = (TableRow)tableLayout.getChildAt(i);
            for(int k=0;k<row.getChildCount();k++){
                Button btn = (Button)row.getChildAt(k);
                btn.setText(""+number);
                number++;
                btn.setOnClickListener(numberListner);
            }
        }

        TableRow bottonRow = (TableRow)tableLayout.getChildAt(tableLayout.getChildCount()-1);
        Button zeroButton = (Button) bottonRow.getChildAt(1);
        zeroButton.setText("0");
        zeroButton.setOnClickListener(numberListner);

        Button enterButton =(Button)bottonRow.getChildAt(2);
        enterButton.setText("enter");
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String working = workingTextView.getText().toString();
                selectedTextView.setText(working);
                workingTextView.setText("0");
            }
        });

        Button deleteButton = (Button)bottonRow.getChildAt(0);
        deleteButton.setText("delete");
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workingTextView.setText("0");
            }
        });
    }
}
