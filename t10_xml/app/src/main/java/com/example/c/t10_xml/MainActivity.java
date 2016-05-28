package com.example.c.t10_xml;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        try {
//            URL url = new URL("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1153054000");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }


        textView= (TextView) findViewById(R.id.textView);

        //MyDomParserTask task=new MyDomParserTask(textView);
        MyPullParser task = new MyPullParser(textView);
        task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1159068000");

    }
}
