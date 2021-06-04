package com.example.applicationtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WriteActivity extends AppCompatActivity {

    EditText txtTitle,txtContent;
    String uid;

    private static final int RESULT_SEND=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        txtTitle=(EditText)findViewById(R.id.edtitle);
        txtContent=(EditText)findViewById(R.id.edcontent);
    }


    public void ok(View view) {
        String tit=txtTitle.getText().toString();
        String con=txtContent.getText().toString();

        if(tit.equals("")||con.equals("")){//만약 확인 버튼을 눌렀을 때 둘 중에 값이 하나도 없으면 오류 메세지 출력.
            Toast.makeText(this,"제목 혹은 내용을 적어주세요.",Toast.LENGTH_SHORT).show();
        }
        else{//글이 있다면 내용을 보드 엑티비티에 보내고 끝냄.
            Intent i = new Intent(this,BoardActivity.class);
            i.putExtra("id",uid);
            i.putExtra("title",txtTitle.getText().toString());
            i.putExtra("content",txtContent.getText().toString());

            setResult(RESULT_SEND,i);
            finish();
        }
    }

    public void cancel(View view) {
        finish();
    }//취소를 누르면 WriteActivity를 끔

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        uid=data.getStringExtra("id");
        super.onActivityResult(requestCode, resultCode, data);
    }
}