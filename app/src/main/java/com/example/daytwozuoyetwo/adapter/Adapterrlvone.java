package com.example.daytwozuoyetwo.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.BaseApp;
import com.example.daytwozuoyetwo.R;
import com.example.daytwozuoyetwo.bean.DatasBean;
import com.example.xts.greendaodemo.db.DatasBeanDao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Adapterrlvone extends RecyclerView.Adapter<Adapterrlvone.Holderone> {
    private ArrayList<DatasBean> list;
    private Context context;
    private String guan;
    private SharedPreferences mima;
    private SharedPreferences.Editor edit;
    private Set<String> position;
    private HashSet<String> hashSet = new HashSet<>();

    public Adapterrlvone(ArrayList<DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holderone onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_one, viewGroup, false);
        mima = context.getSharedPreferences("mima", context.MODE_PRIVATE);
        edit = mima.edit();
        position = mima.getStringSet("position", new HashSet<String>());
        hashSet.addAll(position);

        return new Holderone(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holderone holderone, final int i) {
        DatasBean bean = list.get(i);
        holderone.tv_title.setText(bean.getTitle());
        holderone.tv_author.setText(bean.getAuthor());
        Glide.with(context).load(bean.getAvatar()).circleCrop().into(holderone.iv_avatar);
        holderone.bt_anniu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guan = holderone.bt_anniu.getText().toString();
                if (guan.equals("关注")) {
                    holderone.bt_anniu.setText("取消");
                    DatasBeanDao datasBeanDao = BaseApp.getInstance().getDaoSession().getDatasBeanDao();
                    DatasBean datasBean = list.get(i);
                    datasBeanDao.insert(datasBean);

                    hashSet.add(i + "");
                    edit.putStringSet("position", hashSet);
                    edit.commit();
                } else {
                    DatasBeanDao datasBeanDao = BaseApp.getInstance().getDaoSession().getDatasBeanDao();
                    datasBeanDao.delete(list.get(i));
                    holderone.bt_anniu.setText("关注");

                    hashSet.remove(i + "");
                    edit.putStringSet("position", hashSet);
                    edit.commit();

                }
            }
        });
        position = mima.getStringSet("position", new HashSet<String>());
        for (String s : position) {
            if (String.valueOf(i).equals(s)) {

                holderone.bt_anniu.setText("取消");
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holderone extends RecyclerView.ViewHolder {

        private final TextView tv_title;
        private final TextView tv_author;
        private final ImageView iv_avatar;
        private final Button bt_anniu;

        public Holderone(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_author = itemView.findViewById(R.id.tv_author);
            iv_avatar = itemView.findViewById(R.id.iv_avatar);
            bt_anniu = itemView.findViewById(R.id.bt_anniu);
        }
    }
}
