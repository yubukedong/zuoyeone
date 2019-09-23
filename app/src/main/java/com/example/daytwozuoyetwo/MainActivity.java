package com.example.daytwozuoyetwo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.daytwozuoyetwo.adapter.Adapterrlvone;
import com.example.daytwozuoyetwo.bean.Beanone;
import com.example.daytwozuoyetwo.bean.DatasBean;
import com.example.daytwozuoyetwo.model.MainModelceng;
import com.example.daytwozuoyetwo.presenter.MainPresenterceng;
import com.example.daytwozuoyetwo.view.MainView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainView {

    private Toolbar mTb;
    private RecyclerView mRlv;
    private ArrayList<DatasBean> list;
    private Adapterrlvone adapterrlvone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTb = (Toolbar) findViewById(R.id.tb);
        mRlv = (RecyclerView) findViewById(R.id.rlv);

        setSupportActionBar(mTb);
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapterrlvone = new Adapterrlvone(list, this);
        mRlv.setAdapter(adapterrlvone);
        initAdd();

    }

    private void initAdd() {
        MainPresenterceng mainPresenterceng = new MainPresenterceng(new MainModelceng(), this);
        mainPresenterceng.getData();
    }

    @Override
    public void onSeecss(Beanone beanone) {
        list.addAll(beanone.getDatas());
        adapterrlvone.notifyDataSetChanged();
    }

    @Override
    public void onError(String str) {
        Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
    }
}
