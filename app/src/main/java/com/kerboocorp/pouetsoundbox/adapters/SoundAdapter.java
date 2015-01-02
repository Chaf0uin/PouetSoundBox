package com.kerboocorp.pouetsoundbox.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kerboocorp.pouetsoundbox.R;
import com.kerboocorp.pouetsoundbox.model.Sound;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by chris on 2/01/15.
 */
public class SoundAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Sound> soundList;
    private int rowLayout;
    private Context context;

    public SoundAdapter(int rowLayout, Context context) {
        this.soundList = new ArrayList<Sound>();
        this.rowLayout = rowLayout;
        this.context = context;

        Sound sound = new Sound();
        sound.setName("Pouet");
        sound.setColor("#FF0000");
        soundList.add(sound);

        Sound sound2 = new Sound();
        sound2.setName("Trololo");
        sound2.setColor("#FFFF00");
        soundList.add(sound2);

        notifyDataSetChanged();

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new SoundViewHolder(v);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

        if (viewHolder instanceof SoundViewHolder) {

            SoundViewHolder soundViewHolder = (SoundViewHolder) viewHolder;
            Sound sound = soundList.get(i);

            soundViewHolder.name.setText(sound.getName());

            soundViewHolder.soundLayout.setBackgroundColor(Color.parseColor(sound.getColor()));

            soundViewHolder.context = context;
            soundViewHolder.sound = sound;
        }

    }

    @Override
    public int getItemCount() {
        return (soundList == null ? 0 : soundList.size());
    }


    public static class SoundViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public RelativeLayout soundLayout;
        public Sound sound;
        public Context context;

        public SoundViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.nameTextView);
            soundLayout = (RelativeLayout) itemView.findViewById(R.id.soundLayout);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        }

    }

}