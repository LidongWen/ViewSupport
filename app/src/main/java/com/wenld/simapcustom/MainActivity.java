package com.wenld.simapcustom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wenld.commontools.AllUtilConfig;
import com.wenld.simapcustom.svg.SVGActivity;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public RecyclerView rlvAtyFilter;
    CommonAdapter adapter;
    List<ItemClass> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AllUtilConfig.LogSwitch=true;
//        getActionBar().setTitle("自定义View");
        list.add(new ItemClass(" 继承 CustomView ", Simple_ExtendsCustom.class));
        list.add(new ItemClass(" 使用 GestureListerView 分解手势 ", Simple_GestureListener.class));

        list.add(new ItemClass(" 传统处理手势 ", Simple_GestureListener_2.class));
        list.add(new ItemClass(" 渐变效果 歌词 ", Simple_LyricsView.class));
        list.add(new ItemClass(" ViewPage切换效果 ", ViewPageAnimtiorActivity.class));
        list.add(new ItemClass(" matrix setPoly ", Simple_matrixSetPoly.class));
        list.add(new ItemClass(" 不规则图形的触摸 ", Simple_Region.class));
        list.add(new ItemClass(" scroller ", Simple_scrollLayout.class));
        list.add(new ItemClass(" pathmeasure ", PathMeasureActivity.class));
        list.add(new ItemClass(" svg ", SVGActivity.class));
        list.add(new ItemClass(" qq红点拖拽 ", QQActivity.class));
        list.add(new ItemClass(" 多点触控 ", Simple_DragView.class));
       list.add(new ItemClass(" 缩放图片 ", Simple_ZoomImageView.class));
        list.add(new ItemClass(" 巨图加载 ", LargeImageViewActivity.class));

        this.rlvAtyFilter = (RecyclerView) findViewById(R.id.rlv_activity_main);

        adapter = new CommonAdapter<ItemClass>(this, R.layout.list_items, list) {
            @Override
            protected void convert(ViewHolder holder, final ItemClass s, final int position) {
                TextView btn = holder.getView(R.id.btn);
                btn.setText(s.name);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, s.className);
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

    public class ItemClass {
        public String name;
        public Class className;

        public ItemClass(String name, Class className) {
            this.name = name;
            this.className = className;
        }
    }
}
