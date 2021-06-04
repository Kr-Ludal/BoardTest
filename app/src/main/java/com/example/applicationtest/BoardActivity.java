package com.example.applicationtest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BoardActivity extends AppCompatActivity {

    ListView list;

    private  static final int REQUEST_START=1;

    private static final int RESULT_SEND=1;

    private static final int REQUEST_WRITE=3;

    private static final int MENU_WRITE=2;

    String uid;// MainActivity에서 받아올 id 저장
    int bid=0;// 게시판에 적을 게시물의 id를 생성하기 위한 변수
    ArrayList<BoardData> Geshi =new ArrayList<>();
    listAdapter arrdp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        list=(ListView)findViewById(R.id.list);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(menu.NONE,MENU_WRITE, Menu.NONE,"글쓰기");

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//글쓰기 엑티비티로 넘어갈 때 메인에서 넘긴 id를 같이 넘겨줌(하지만 넘어오지 않음)

        if(item.getItemId()==MENU_WRITE){
            Intent boardintent = new Intent(this, WriteActivity.class);
            boardintent.putExtra("id",uid);
            startActivityForResult(boardintent,REQUEST_WRITE);

        }

        return super.onOptionsItemSelected(item);
    }

    class listAdapter extends BaseAdapter{//커스텀 리스트에 데이터를 전달
        List<BoardData> lists;

        public listAdapter(ArrayList<BoardData> geshi) {
            this.lists=geshi;
        }

        @Override
        public int getCount() {
            return lists.size();
        }

        @Override
        public Object getItem(int position) {
            return lists.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v=convertView;
            if(v==null){
                LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v=inflater.inflate(R.layout.list_view_3,null);

            }

            TextView clTitle=v.findViewById(R.id.texttitle);
            TextView clContent=v.findViewById(R.id.textcontent);
            TextView clUid=v.findViewById(R.id.textuid);

            BoardData data=lists.get(position);

            clTitle.setText(data.getTitle());
            clContent.setText(data.getContent());
            clUid.setText(data.getUid());

            return v;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        uid=data.getStringExtra("id");
        //메인에서 보드에 넘어올 때만 값을 받고싶었는데 requestCode로 받아지질 않았습니다. 그래서 그냥 엑티비티를 넘어갈 때마다 받는거로 해두긴 했는데 안되네요ㅠㅠ


        if(resultCode==RESULT_SEND){
            uid=data.getStringExtra("id");
            String ti=data.getStringExtra("title");
            String con=data.getStringExtra("content");

            Geshi.add(new BoardData(uid,ti,con,++bid));

            arrdp=new listAdapter(Geshi);
            arrdp.notifyDataSetChanged();
            list.setAdapter(arrdp);

        }

        super.onActivityResult(requestCode, resultCode, data);

    }
}