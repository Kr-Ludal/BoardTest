package com.example.applicationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private  static final int REQUEST_START=1;
    EditText userid,userpw;

    HashMap<String,String> info=new HashMap<String, String>();// 아이디와 비밀번호를 저장할 맵
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        userid=findViewById(R.id.userId);
        userpw=findViewById(R.id.userPassword);


    }

    public void login(View view) {

        info.put("u","u");


        String id=userid.getText().toString();
        String pw=userpw.getText().toString();


        String input= info.get(id);

            if(id.equals("")||pw.equals("")){
                Toast.makeText(this,"아이디 혹은 비밀번호를 입력해주세요.",Toast.LENGTH_SHORT).show();
            }
            else if(info.get(id).equals(pw)){
                Intent intent= new Intent(this,BoardActivity.class);
                intent.putExtra("id",id);
                Toast.makeText(this,id,Toast.LENGTH_SHORT).show();
                startActivityForResult(intent,RESULT_OK);
            }else{
                Toast.makeText(this,"아이디 혹은 비밀번호가 틀렸습니다.",Toast.LENGTH_SHORT).show();
            }

        }


}