package com.example.qidianxuan.passwordkeeper;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Qidianxuan on 2018/1/20.
 */

public class Setting extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        final TimeCtrl Tcer = new TimeCtrl();
        setContentView(R.layout.setting);

        Button about = (Button)findViewById(R.id.app_about);
        Button help =(Button)findViewById(R.id.app_help);
        Switch sw = (Switch)findViewById(R.id.SeSwitch);


        sw.setChecked(Tcer.getSwitchState());
        Button changepassword = (Button)findViewById(R.id.password_change);
        about.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }

        });
        changepassword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final EditText ediPass = new EditText(Setting.this);

                new AlertDialog.Builder(Setting.this)
                        .setTitle("更改后的密码为:")
                        .setView(ediPass)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String input = ediPass.getText().toString();
                                if(input.equals("")){
                                    Toast.makeText(getApplicationContext(),"输入不能为空!密码保存失败!",Toast.LENGTH_LONG).show();
                                }
                                else {
                                    Toast.makeText(getApplicationContext(), "保存!密码为"+input, Toast.LENGTH_LONG).show();
                                    Tcer.setPass(input);
                                    Tcer.setSwitchState(true);
                                }
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(),"取消!",Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();
            }

        });
    }

}
