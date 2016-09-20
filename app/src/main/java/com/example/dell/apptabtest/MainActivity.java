package com.example.dell.apptabtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        bt1= (Button) findViewById(R.id.bt_method1);
        bt2= (Button) findViewById(R.id.bt_method2);
        bt3= (Button) findViewById(R.id.bt_method3);
        bt4= (Button) findViewById(R.id.bt_method4);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_method1:
                Intent intent1=new Intent(MainActivity.this,TestActivity1.class);
                startActivity(intent1);
                break;
            case R.id.bt_method2:
                Intent intent2=new Intent(MainActivity.this,TestActivity2.class);
                startActivity(intent2);
                break;
            case R.id.bt_method3:
                Intent intent3=new Intent(MainActivity.this,TestActivity3.class);
                startActivity(intent3);
                break;

            case R.id.bt_method4:
                Intent intent4=new Intent(MainActivity.this,TestActivity4.class);
                startActivity(intent4);
                break;
        }
    }
}
