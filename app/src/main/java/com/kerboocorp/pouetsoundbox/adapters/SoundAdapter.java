package com.kerboocorp.pouetsoundbox.adapters;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kerboocorp.pouetsoundbox.R;
import com.kerboocorp.pouetsoundbox.model.Sound;
import com.kerboocorp.pouetsoundbox.observers.StopSoundObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 2/01/15.
 */
public class SoundAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Sound> soundList;
    private int rowLayout;
    private Context context;

    private static SoundPool soundPool;
    private static int streamId;

    private static Handler handler;
    private static List<StopSoundObserver> observerList;

    public SoundAdapter(int rowLayout, Context context) {
        this.soundList = new ArrayList<Sound>();
        this.rowLayout = rowLayout;
        this.context = context;

        handler = new Handler();
        observerList = new ArrayList<StopSoundObserver>();

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        MediaPlayer player;

        Sound sound = new Sound();
        sound.setName("Pouet");
        sound.setColor("#FF0000");
        sound.setTextColor("#FFFFFF");
        sound.setSoundResource(R.raw.horn);
        player = MediaPlayer.create(context, sound.getSoundResource());
        sound.setDuration(player.getDuration());
        player.release();
        soundList.add(sound);

        Sound sound2 = new Sound();
        sound2.setName("Trololo");
        sound2.setColor("#FFFF00");
        sound2.setTextColor("#000000");
        sound2.setSoundResource(R.raw.horn);
        player = MediaPlayer.create(context, sound2.getSoundResource());
        sound2.setDuration(player.getDuration());
        player.release();
        soundList.add(sound2);

        Sound sound3 = new Sound();
        sound3.setName("Je code avec le cul");
        sound3.setColor("#2200FF");
        sound3.setTextColor("#FFFFFF");
        sound3.setSoundResource(R.raw.jecodeaveclecul);
        player = MediaPlayer.create(context, sound3.getSoundResource());
        sound3.setDuration(player.getDuration());
        player.release();
        soundList.add(sound3);

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
            soundViewHolder.name.setTextColor(Color.parseColor(sound.getTextColor()));

            soundViewHolder.soundLayout.setBackgroundColor(Color.parseColor(sound.getColor()));

            soundViewHolder.context = context;
            soundViewHolder.sound = sound;

            soundViewHolder.soundId = SoundAdapter.soundPool.load(context, sound.getSoundResource(), 1);

            if (sound.getTextColor().equals("#FFFFFF")) {

                soundViewHolder.musicImageView.setImageResource(R.drawable.dance_white);
            } else {
                soundViewHolder.musicImageView.setImageResource(R.drawable.dance);
            }
        }

    }

    @Override
    public int getItemCount() {
        return (soundList == null ? 0 : soundList.size());
    }


    public static class SoundViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, StopSoundObserver {
        public TextView name;
        public RelativeLayout soundLayout;
        public Sound sound;
        public int soundId;
        public Context context;
        public ImageView musicImageView;

        public SoundViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.nameTextView);
            soundLayout = (RelativeLayout) itemView.findViewById(R.id.soundLayout);
            musicImageView = (ImageView) itemView.findViewById(R.id.musicImageView);

            itemView.setOnClickListener(this);
            observerList.add(this);

        }

        @Override
        public void onClick(View v) {
            SoundAdapter.playSound(soundId);
            name.setVisibility(View.GONE);
            musicImageView.setVisibility(View.VISIBLE);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    name.setVisibility(View.VISIBLE);
                    musicImageView.setVisibility(View.GONE);
                }
            }, sound.getDuration());
        }

        @Override
        public void stopSound() {
            name.setVisibility(View.VISIBLE);
            musicImageView.setVisibility(View.GONE);
        }
    }

    private static void playSound(int soundId) {

        for (StopSoundObserver observer : observerList) {
            observer.stopSound();
        }
        streamId = soundPool.play(soundId, 1, 1, 0, 0, 1);

    }

    //private static void stopSound() {
    //    soundPool.stop(streamId);

    //}
}