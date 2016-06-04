package com.psm2901.t20_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

    public  void onBtnClick(View view){

        FragmentManager fm = getSupportFragmentManager();
        Fragment fr = fm.findFragmentById(R.id.frame);

        switch (view.getId()){
            case R.id.btnAdd:
                if(fr==null){
                    BlankFragment bf = new BlankFragment();
                    FragmentTransaction tr = fm.beginTransaction();
                    tr.add(R.id.frame,bf,"counter");
                    tr.addToBackStack(null);
                    tr.commit();
                }
                break;
            case R.id.btnRemove:
                if(fr!=null){
                    FragmentTransaction tr = fm.beginTransaction();
                    tr.remove(fr);
                    tr.commit();
                }
                break;
            case R.id.btnReplace:
                if(fr!=null){
                    FragmentTransaction tr = fm.beginTransaction();
                    if(fr.getTag().equals("counter")){
                        TextFragment tf = new TextFragment();
                        tr.replace(R.id.frame,tf,"text");
                    }else if(fr.getTag().equals("text")){
                        BlankFragment bf = new BlankFragment();
                        tr.replace(R.id.frame, bf, "counter");
                    }
                    tr.addToBackStack(null);
                    tr.commit();
                }
                break;
            case R.id.btnhide:
                if(fr!=null){
                    FragmentTransaction tr = fm.beginTransaction();
                    if(fr.isHidden())
                        tr.show(fr);
                    else
                        tr.hide(fr);

                    tr.commit();
                }
                break;
        }

    }

}

