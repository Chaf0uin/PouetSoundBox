package com.kerboocorp.ultimatesoundbox.activities;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kerboocorp.ultimatesoundbox.R;
import com.kerboocorp.ultimatesoundbox.adapters.SoundAdapter;
import com.kerboocorp.ultimatesoundbox.model.Sound;
import com.kerboocorp.ultimatesoundbox.observers.StopSoundObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;
    //private RecyclerView soundListView;
    //private SoundAdapter soundAdapter;
    //private LinearLayoutManager linearLayoutManager;

    private LinearLayout soundList;

    private List<StopSoundObserver> observerList;

    private  MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

        observerList = new ArrayList<StopSoundObserver>();

        soundList = (LinearLayout) findViewById(R.id.soundList);
        Sound sound = new Sound(1L, "Pouet", getResources().getColor(R.color.red), getResources().getColor(R.color.white), R.raw.horn);
        soundList.addView(new SoundItem(sound, soundList).getItemView());

        Sound sound2 = new Sound(2L, "Trololo", getResources().getColor(R.color.yellow), getResources().getColor(R.color.black), R.raw.trololo);
        soundList.addView(new SoundItem(sound2, soundList).getItemView());

        Sound sound3 = new Sound(3L, "Je code avec le cul", getResources().getColor(R.color.blue), getResources().getColor(R.color.white), R.raw.jecodeaveclecul);
        soundList.addView(new SoundItem(sound3, soundList).getItemView());

        Sound sound4 = new Sound(4L, "Leeloo Dallas Multipass", getResources().getColor(R.color.red), getResources().getColor(R.color.white), R.raw.leeloo);
        soundList.addView(new SoundItem(sound4, soundList).getItemView());

        Sound sound5 = new Sound(5L, "Legendary", getResources().getColor(R.color.yellow), getResources().getColor(R.color.black), R.raw.legenwaitforitdary);
        soundList.addView(new SoundItem(sound5, soundList).getItemView());

        Sound sound6 = new Sound(6L, "Wait for it", getResources().getColor(R.color.blue), getResources().getColor(R.color.white), R.raw.waitforit);
        soundList.addView(new SoundItem(sound6, soundList).getItemView());

        Sound sound7 = new Sound(7L, "Surprise Motherfucker", getResources().getColor(R.color.red), getResources().getColor(R.color.white), R.raw.surprisemotherfucker);
        soundList.addView(new SoundItem(sound7, soundList).getItemView());

        Sound sound8 = new Sound(8L, "La boule noire", getResources().getColor(R.color.yellow), getResources().getColor(R.color.black), R.raw.motus);
        soundList.addView(new SoundItem(sound8, soundList).getItemView());

        Sound sound9 = new Sound(9L, "Je ne sais pas", getResources().getColor(R.color.blue), getResources().getColor(R.color.white), R.raw.jenesaispas);
        soundList.addView(new SoundItem(sound9, soundList).getItemView());

        Sound sound10 = new Sound(10L, "Tabouret", getResources().getColor(R.color.red), getResources().getColor(R.color.white), R.raw.tabouret);
        soundList.addView(new SoundItem(sound10, soundList).getItemView());

        Sound sound11 = new Sound(11L, "C'est vrai", getResources().getColor(R.color.yellow), getResources().getColor(R.color.black), R.raw.cestvrai);
        soundList.addView(new SoundItem(sound11, soundList).getItemView());

        Sound sound12 = new Sound(12L, "Et patati", getResources().getColor(R.color.blue), getResources().getColor(R.color.white), R.raw.etpatati);
        soundList.addView(new SoundItem(sound12, soundList).getItemView());

        Sound sound13 = new Sound(13L, "Even later", getResources().getColor(R.color.red), getResources().getColor(R.color.white), R.raw.evenlater);
        soundList.addView(new SoundItem(sound13, soundList).getItemView());

        Sound sound14 = new Sound(14L, "Hodor", getResources().getColor(R.color.yellow), getResources().getColor(R.color.black), R.raw.hodor);
        soundList.addView(new SoundItem(sound14, soundList).getItemView());

        Sound sound15 = new Sound(15L, "Ik heb geen idee", getResources().getColor(R.color.blue), getResources().getColor(R.color.white), R.raw.ikhebgeenidee);
        soundList.addView(new SoundItem(sound15, soundList).getItemView());

        Sound sound16 = new Sound(16L, "Loituma", getResources().getColor(R.color.red), getResources().getColor(R.color.white), R.raw.loituma);
        soundList.addView(new SoundItem(sound16, soundList).getItemView());

        Sound sound17 = new Sound(17L, "C'est la mer noire", getResources().getColor(R.color.yellow), getResources().getColor(R.color.black), R.raw.mernoire);
        soundList.addView(new SoundItem(sound17, soundList).getItemView());

        Sound sound18 = new Sound(18L, "You're in my spot", getResources().getColor(R.color.blue), getResources().getColor(R.color.white), R.raw.myspot);
        soundList.addView(new SoundItem(sound18, soundList).getItemView());

        Sound sound19 = new Sound(19L, "Neogotisch", getResources().getColor(R.color.red), getResources().getColor(R.color.white), R.raw.neogotisch);
        soundList.addView(new SoundItem(sound19, soundList).getItemView());

        Sound sound20 = new Sound(20L, "On était bien remis d'accord", getResources().getColor(R.color.yellow), getResources().getColor(R.color.black), R.raw.onestbienremisdaccord);
        soundList.addView(new SoundItem(sound20, soundList).getItemView());

        Sound sound21 = new Sound(21L, "So fluffy I'm gonna die", getResources().getColor(R.color.blue), getResources().getColor(R.color.white), R.raw.sofluffyimgonnadie);
        soundList.addView(new SoundItem(sound21, soundList).getItemView());

        Sound sound22 = new Sound(22L, "So fluffay", getResources().getColor(R.color.red), getResources().getColor(R.color.white), R.raw.sofluffay);
        soundList.addView(new SoundItem(sound22, soundList).getItemView());

        Sound sound23 = new Sound(23L, "This is Sparta", getResources().getColor(R.color.yellow), getResources().getColor(R.color.black), R.raw.sparta);
        soundList.addView(new SoundItem(sound23, soundList).getItemView());

        Sound sound24 = new Sound(24L, "Ta kette", getResources().getColor(R.color.blue), getResources().getColor(R.color.white), R.raw.takette);
        soundList.addView(new SoundItem(sound24, soundList).getItemView());

        Sound sound25 = new Sound(25L, "I know exactly what happened", getResources().getColor(R.color.red), getResources().getColor(R.color.white), R.raw.whathappened);
        soundList.addView(new SoundItem(sound25, soundList).getItemView());

        Sound sound26 = new Sound(26L, "Weeeee we we weeeeee", getResources().getColor(R.color.yellow), getResources().getColor(R.color.black), R.raw.wipiggy);
        soundList.addView(new SoundItem(sound26, soundList).getItemView());

        Sound sound27 = new Sound(27L, "Même que des fois ze vomis", getResources().getColor(R.color.blue), getResources().getColor(R.color.white), R.raw.zevomi);
        soundList.addView(new SoundItem(sound27, soundList).getItemView());

    }


    private class SoundItem implements StopSoundObserver, MediaPlayer.OnCompletionListener {

        private View itemView;
        public TextView name;
        public RelativeLayout soundLayout;
        public LinearLayout progressLayout;
        public LinearLayout remainingProgressLayout;
        public LinearLayout progressContainerLayout;
        public Sound currentSound;
        public ImageView musicImageView;
        public Timer timer;

        public SoundItem(Sound sound, ViewGroup container) {
            itemView = getLayoutInflater().inflate(R.layout.sound_item, container, false);

            currentSound = sound;

            name = (TextView) itemView.findViewById(R.id.nameTextView);
            soundLayout = (RelativeLayout) itemView.findViewById(R.id.soundLayout);
            progressLayout = (LinearLayout) itemView.findViewById(R.id.progressLayout);
            remainingProgressLayout = (LinearLayout) itemView.findViewById(R.id.remainingProgressLayout);
            progressContainerLayout = (LinearLayout) itemView.findViewById(R.id.progressContainerLayout);
            musicImageView = (ImageView) itemView.findViewById(R.id.musicImageView);

            name.setText(sound.getName());
            name.setTextColor(sound.getTextColor());
            soundLayout.setBackgroundColor(sound.getColor());

            if (sound.getTextColor() == getResources().getColor(R.color.white)) {

                musicImageView.setImageResource(R.drawable.dance_white);
            } else {
                musicImageView.setImageResource(R.drawable.dance);
            }

            itemView.setOnClickListener(new View.OnClickListener() {

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
                    player = MediaPlayer.create(MainActivity.this, currentSound.getSoundResource());
                    int duration = player.getDuration();

                    player.setOnCompletionListener(SoundItem.this);
                    player.start();

                    final float step = duration/20;
                    final float stepPercentage = (1/step);

                    progressContainerLayout.setVisibility(View.VISIBLE);
                    updateLayout(0, 1);

                    if (timer != null) {
                        timer.cancel();
                        timer.purge();
                    }

                    timer = new Timer();
                    timer.scheduleAtFixedRate(new TimerTask() {
                        private int stepCounter = 0;
                        private float progressBarPercentage = stepPercentage;
                        private float remainingProgressBarPercentage = 1-stepPercentage;

                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    stepCounter++;
                                    if (stepCounter < step) {
                                        updateLayout(progressBarPercentage, remainingProgressBarPercentage);

                                        progressBarPercentage = progressBarPercentage + stepPercentage;
                                        remainingProgressBarPercentage = remainingProgressBarPercentage - stepPercentage;

                                    } else {
                                        timer.cancel();
                                        updateLayout(0, 1);
                                    }
                                }
                            });
                        }
                    }, 0, 20);


                }
            });

            observerList.add(this);

        }

        public View getItemView() {
            return itemView;
        }

        public void updateLayout(float progressLayoutPercentage, float remainingProgressLayoutPercentage) {
            LinearLayout.LayoutParams progressLayoutParams = (LinearLayout.LayoutParams) progressLayout.getLayoutParams();
            LinearLayout.LayoutParams remainingProgressLayoutParams = (LinearLayout.LayoutParams) remainingProgressLayout.getLayoutParams();
            progressLayoutParams.weight = progressLayoutPercentage;
            remainingProgressLayoutParams.weight = remainingProgressLayoutPercentage;
            progressLayout.setLayoutParams(progressLayoutParams);
            remainingProgressLayout.setLayoutParams(remainingProgressLayoutParams);
        }

        @Override
        public void stopSound() {
            if (timer != null) {
                timer.cancel();
                timer.purge();
            }

            progressContainerLayout.setVisibility(View.GONE);
            name.setVisibility(View.VISIBLE);
            musicImageView.setVisibility(View.GONE);
        }

        @Override
        public void onCompletion(MediaPlayer mp) {
            for (StopSoundObserver observer : observerList) {
                observer.stopSound();
            }
        }
    }


}
