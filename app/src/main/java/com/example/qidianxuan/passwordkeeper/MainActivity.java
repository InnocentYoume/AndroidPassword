package com.example.qidianxuan.passwordkeeper;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Process;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static ListView list;

    private List<Activity> activities = new ArrayList<Activity>();

    public static ArrayList<String> mShow = new ArrayList<String>();

    Password_item password_item = new Password_item();

    Input_password input_password = new Input_password();

    TimeCtrl Tcer = new TimeCtrl();

    Item_show item_show = new Item_show();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tcer.setTc(Tcer.getTc()+1);
        String Fshow = "Time: "+Tcer.getTc();
        //Toast.makeText(getApplicationContext(),Fshow,Toast.LENGTH_LONG).show();

        Init();
        InitList();
    }

    private void Init(){

        //Tcer.setFlag(Tcer.getFlag()+1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        setSupportActionBar(toolbar);



        if(Tcer.getLockTc() == 0){
            final EditText ediPass = new EditText(this);

                 new AlertDialog.Builder(this)
                        .setTitle("为保护您的隐私,请输入一个仅含有数字的密码:")
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
            Tcer.setLockTc(1);
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.fab:
                        Intent intent = new Intent(MainActivity.this,Input_password.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
    private static int delete;

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    private void InitList(){
        if(Tcer.getTc() != 1 ) {
            mShow.add(input_password.mData.get(Tcer.getTc() - 1).getWeb());
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1/*_single_choice*/,mShow );
        final ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int get = list.getPositionForView(view);
                Toast.makeText(getApplicationContext(), "You clicked No." + get, Toast.LENGTH_LONG).show();

                item_show.setShow_id(input_password.mData.get(get).getId());
                item_show.setShow_password(input_password.mData.get(get).getPword());
                item_show.setShow_web(input_password.mData.get(get).getWeb());
                Intent intent = new Intent(MainActivity.this,Item_show.class);
                startActivity(intent);
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int get = list.getPositionForView(view);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("删除?")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                input_password.mData.remove(get);
                                mShow.remove(get);
                                Tcer.setTc(Tcer.getTc()-1);

                               adapter.notifyDataSetChanged();

                            }
                        })
                        .setNegativeButton("取消",null)
                        .show();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        super.onOptionsItemSelected(item);
        //noinspection SimplifiableIfStatement
        if(id == R.id.searcher){

        }
        if(id == R.id.Esc){
            //TODO:完全退出该app
            System.exit(0);
        }
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this,Setting.class);
            startActivity(intent);
            return true;
        }
        if(id == R.id.action_select){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("确定删除所有数据?")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            mShow.clear();
                            if (mShow.isEmpty() == true) {

                                Tcer.setTc(0);
                                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        }
                    })
                    .setNegativeButton("取消",null)
                    .show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int KeyCode , KeyEvent event){
        if(KeyCode == KeyEvent.KEYCODE_BACK){
            moveTaskToBack(false);
            return true;
        }
        return super.onKeyDown(KeyCode,event);
    }

}
