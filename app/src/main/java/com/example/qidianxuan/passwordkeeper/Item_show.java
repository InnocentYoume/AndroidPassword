package com.example.qidianxuan.passwordkeeper;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Qidianxuan on 2018/2/6.
 */

public class Item_show extends AppCompatActivity {


    public static String show_web = " ";
    public static String show_id = " ";
    public static String show_password = " ";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_show);
        TextView txt_id = (TextView)findViewById(R.id.id_show);
        TextView txt_web = (TextView)findViewById(R.id.web_show);
        TextView txt_password = (TextView)findViewById(R.id.password_show);

        txt_id.setText(show_id);
        txt_password.setText(show_password);
        txt_web.setText(show_web);

    }

    public Item_show(){

    }
    public String getShow_id() {
        return show_id;
    }

    public String getShow_password() {
        return show_password;
    }

    public String getShow_web() {
        return show_web;
    }

    public void setShow_id(String show_id) {
        Item_show.show_id = show_id;
    }

    public  void setShow_password(String show_password) {
        Item_show.show_password = show_password;
    }

    public void setShow_web(String show_web) {
        Item_show.show_web = show_web;
    }
}
