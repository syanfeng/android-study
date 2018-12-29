package com.ispring.gameplane;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements Button.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button)findViewById(R.id.btn_rejist);
        btn.setOnClickListener(onClick);
        Button btn1=(Button)findViewById(R.id.btn_login);
//        注册
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,RegistActivity.class);

                startActivity(intent);
            }

        });
//        登录
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                System.out.print("login click");
                Intent intent=new Intent(MainActivity.this,GameActivity.class);
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("请先进行注册")
                        .setPositiveButton("确定", null)
                        .show();
                // startActivity(intent);
            }

        });

    }
    private  View.OnClickListener onClick;

    {
        onClick = new View.OnClickListener() {
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("请先进行注册")
                        .setPositiveButton("确定", null)
                        .show();
            }
        };
    }




    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.btnGame) {
            startGame();
        }
    }

    public void startGame() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}

