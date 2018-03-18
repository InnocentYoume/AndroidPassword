package com.example.qidianxuan.passwordkeeper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Qidianxuan on 2018/1/20.
 */

public class Input_password extends AppCompatActivity{

    public static String Web = " ";
    public static String ID = " ";
    public static String Pword = " ";
    public static String result= " ";

    public static ArrayList<Password_item> mData = new ArrayList<Password_item>();


    TimeCtrl Tcer = new TimeCtrl();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password);
        FloatingActionButton ok = (FloatingActionButton)findViewById(R.id.editOk);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Password_item password_item = new Password_item();

                EditText InputWeb = (EditText)findViewById(R.id.editWeb);
                EditText InputId = (EditText)findViewById(R.id.editid);
                EditText InputPw = (EditText)findViewById(R.id.editpassword);

                Web = InputWeb.getText().toString();
                ID = InputId.getText().toString();
                Pword = InputId.getText().toString();
                if(Web.isEmpty() == true){
                    Toast.makeText(getApplicationContext(),"Web不能为空!",Toast.LENGTH_LONG).show();
                }
                else {
                    password_item = new Password_item();
                    password_item.setId(ID);
                    password_item.setWeb(Web);
                    password_item.setPword(Pword);

                    mData.add(password_item);

                    Password_item tem = new Password_item();
                    tem = mData.get(mData.size() - 1);
                    result = "ID:" + tem.getId() + " Web:" + tem.getWeb() + " Size:" + mData.size();

                    mData.add(password_item);

                    Tcer.setTc(1);
                    //Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(Input_password.this, MainActivity.class);
                    startActivity(intent);
                }


            }
        });
    }
    public boolean isEmpty(String str){
        if(str.equals("")){
            return true;
        }
        return false;
    }
}
