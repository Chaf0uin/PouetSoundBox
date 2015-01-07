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
public class SoundAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements MediaPlayer.OnCompletionListener {

    private List<Sound> soundList;
    private int rowLayout;
    private Context context;

    private static MediaPlayer player;

    private static List<StopSoundObserver> observerList;

    public SoundAdapter(int rowLayout, Context context) {
        this.soundList = new ArrayList<Sound>();
        this.rowLayout = rowLayout;
        this.context = context;

        observerList = new ArrayList<StopSoundObserver>();

        Sound sound = new Sound();
        sound.setName("Pouet");
        sound.setColor(context.getResources().getColor(R.color.red));
        sound.setTextColor(context.getResources().getColor(R.color.white));
        sound.setSoundResource(R.raw.horn);
        soundList.add(sound);

        Sound sound2 = new Sound();
        sound2.setName("Trololo");
        sound2.setColor(context.getResources().getColor(R.color.yellow));
        sound2.setTextColor(context.getResources().getColor(R.color.black));
        sound2.setSoundResource(R.raw.trololo);
        soundList.add(sound2);

        Sound sound3 = new Sound();
        sound3.setName("Je code avec le cul");
        sound3.setColor(context.getResources().getColor(R.color.blue));
        sound3.setTextColor(context.getResources().getColor(R.color.white));
        sound3.setSoundResource(R.raw.jecodeaveclecul);
        soundList.add(sound3);

        Sound sound4 = new Sound();
        sound4.setName("Leeloo Dallas Multipass");
        sound4.setColor(context.getResources().getColor(R.color.red));
        sound4.setTextColor(context.getResources().getColor(R.color.white));
        sound4.setSoundResource(R.raw.leeloodallasmultipass);
        soundList.add(sound4);

        Sound sound5 = new Sound();
        sound5.setName("Legendary");
        sound5.setColor(context.getResources().getColor(R.color.yellow));
        sound5.setTextColor(context.getResources().getColor(R.color.black));
        sound5.setSoundResource(R.raw.legenwaitforitdary);
        soundList.add(sound5);

        Sound sound6 = new Sound();
        sound6.setName("Wait for it");
        sound6.setColor(context.getResources().getColor(R.color.blue));
        sound6.setTextColor(context.getResources().getColor(R.color.white));
        sound6.setSoundResource(R.raw.waitforit);
        soundList.add(sound6);

        Sound sound7 = new Sound();
        sound7.setName("Surprise Motherfucker");
        sound7.setColor(context.getResources().getColor(R.color.red));
        sound7.setTextColor(context.getResources().getColor(R.color.white));
        sound7.setSoundResource(R.raw.surprisemotherfucker);
        soundList.add(sound7);

        Sound sound8 = new Sound();
        sound8.setName("La boule noire");
        sound8.setColor(context.getResources().getColor(R.color.yellow));
        sound8.setTextColor(context.getResources().getColor(R.color.black));
        sound8.setSoundResource(R.raw.motus);
        soundList.add(sound8);

        Sound sound9 = new Sound();
        sound9.setName("Je ne sais pas");
        sound9.setColor(context.getResources().getColor(R.color.blue));
        sound9.setTextColor(context.getResources().getColor(R.color.white));
        sound9.setSoundResource(R.raw.jenesaispas);
        soundList.add(sound9);

        Sound sound10 = new Sound();
        sound10.setName("Tabouret");
        sound10.setColor(context.getResources().getColor(R.color.red));
        sound10.setTextColor(context.getResources().getColor(R.color.white));
        sound10.setSoundResource(R.raw.tabouret);
        soundList.add(sound10);

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
            soundViewHolder.name.setTextColor(sound.getTextColor());

            soundViewHolder.soundLayout.setBackgroundColor(sound.getColor());

            soundViewHolder.context = context;
            soundViewHolder.sound = sound;

            if (sound.getTextColor() == context.getResources().getColor(R.color.white)) {

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

    @Override
    public void onCompletion(MediaPlayer mp) {
        for (StopSoundObserver observer : observerList) {
            observer.stopSound();
        }
    }


    public class SoundViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, StopSoundObserver {
        public TextView name;
        public RelativeLayout soundLayout;
        public Sound sound;
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

            if (player != null) {
                player.stop();
                player.release();
            }

            for (StopSoundObserver observer : observerList) {
                observer.stopSound();
            }
            name.setVisibility(View.GONE);
            musicImageView.setVisibility(View.VISIBLE);
            playSound(sound.getSoundResource());

        }

        @Override
        public void stopSound() {
            name.setVisibility(View.VISIBLE);
            musicImageView.setVisibility(View.GONE);
        }
    }

    private void playSound(int soundResource) {

        player = MediaPlayer.create(context, soundResource);
        player.setOnCompletionListener(this);
        player.start();


    }

}