package com.kerboocorp.ultimatesoundbox.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.kerboocorp.ultimatesoundbox.R;
import com.kerboocorp.ultimatesoundbox.adapters.SoundAdapter;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private RecyclerView soundListView;
    private SoundAdapter soundAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

        soundListView = (RecyclerView) findViewById(R.id.soundList);
        linearLayoutManager = new LinearLayoutManager(this);
        soundListView.setLayoutManager(linearLayoutManager);
        soundListView.setItemAnimator(new DefaultItemAnimator());

        soundAdapter = new SoundAdapter(R.layout.sound_item, this, this);
        soundListView.setAdapter(soundAdapter);

    }


}
