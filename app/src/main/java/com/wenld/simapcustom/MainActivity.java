package com.wenld.simapcustom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public RecyclerView rlvAtyFilter;
    CommonAdapter adapter;
    List<String> list = new ArrayList<>();
    String items[] = {" 继承 CustomView ", " 传统处理手势","使用 GestureListerView 分解手势"," 渐变效果"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getActionBar().setTitle("自定义View");

        list = Arrays.asList(items);
        this.rlvAtyFilter = (RecyclerView) findViewById(R.id.rlv_activity_main);

        adapter = new CommonAdapter<String>(this, R.layout.list_items, list) {
            @Override
            protected void convert(ViewHolder holder, String s, final int position) {
                TextView btn = holder.getView(R.id.btn);
                btn.setText(s);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = null;
                        switch (position) {
                            case 0:
                                intent = new Intent(MainActivity.this, Simple_ExtendsCustom.class);
                                break;
                            case 1:
                                intent = new Intent(MainActivity.this, Simple_GestureListener.class);
                                break;
                            case 2:
                                intent = new Intent(MainActivity.this, Simple_GestureListener_2.class);
                                break;
                            case 3:
                                intent = new Intent(MainActivity.this, Simple_LyricsView.class);
                                break;
                            default:
//                        showTip("在IsvDemo中哦，为了代码简洁，就不放在一起啦，^_^");
                                break;
                        }

                        if (intent != null) {
                            startActivity(intent);
                        }
                    }
                });
            }
        };
        rlvAtyFilter.setLayoutManager(new LinearLayoutManager(this));
        rlvAtyFilter.setAdapter(adapter);
        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener<String>() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, String o, int position) {

            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, String o, int position) {
                return false;
            }
        });
    }
}
