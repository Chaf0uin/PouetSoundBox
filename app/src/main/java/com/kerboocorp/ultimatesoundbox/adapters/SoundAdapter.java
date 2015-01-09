package com.kerboocorp.ultimatesoundbox.adapters;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kerboocorp.ultimatesoundbox.R;
import com.kerboocorp.ultimatesoundbox.managers.SoundManager;
import com.kerboocorp.ultimatesoundbox.model.Sound;
import com.kerboocorp.ultimatesoundbox.observers.StopSoundObserver;
import com.kerboocorp.ultimatesoundbox.observers.UpdateLayoutObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by chris on 2/01/15.
 */
public class SoundAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements MediaPlayer.OnCompletionListener {

    private List<Sound> soundList;
    private int rowLayout;
    private Context context;
    private ActionBarActivity activity;

    private static MediaPlayer player;

    private static List<StopSoundObserver> observerList;

    public SoundAdapter(int rowLayout, Context context, ActionBarActivity activity) {
        this.soundList = new ArrayList<Sound>();
        this.rowLayout = rowLayout;
        this.context = context;
        this.activity = activity;

        observerList = new ArrayList<StopSoundObserver>();

        Sound sound = new Sound();
        sound.setId(1L);
        sound.setName("Pouet");
        sound.setColor(context.getResources().getColor(R.color.red));
        sound.setTextColor(context.getResources().getColor(R.color.white));
        sound.setSoundResource(R.raw.horn);
        soundList.add(sound);

        Sound sound2 = new Sound();
        sound2.setId(2L);
        sound2.setName("Trololo");
        sound2.setColor(context.getResources().getColor(R.color.yellow));
        sound2.setTextColor(context.getResources().getColor(R.color.black));
        sound2.setSoundResource(R.raw.trololo);
        soundList.add(sound2);

        Sound sound3 = new Sound();
        sound3.setId(3L);
        sound3.setName("Je code avec le cul");
        sound3.setColor(context.getResources().getColor(R.color.blue));
        sound3.setTextColor(context.getResources().getColor(R.color.white));
        sound3.setSoundResource(R.raw.jecodeaveclecul);
        soundList.add(sound3);

        Sound sound4 = new Sound();
        sound4.setId(4L);
        sound4.setName("Leeloo Dallas Multipass");
        sound4.setColor(context.getResources().getColor(R.color.red));
        sound4.setTextColor(context.getResources().getColor(R.color.white));
        sound4.setSoundResource(R.raw.leeloo);
        soundList.add(sound4);

        Sound sound5 = new Sound();
        sound5.setId(5L);
        sound5.setName("Legendary");
        sound5.setColor(context.getResources().getColor(R.color.yellow));
        sound5.setTextColor(context.getResources().getColor(R.color.black));
        sound5.setSoundResource(R.raw.legenwaitforitdary);
        soundList.add(sound5);

        Sound sound6 = new Sound();
        sound6.setId(6L);
        sound6.setName("Wait for it");
        sound6.setColor(context.getResources().getColor(R.color.blue));
        sound6.setTextColor(context.getResources().getColor(R.color.white));
        sound6.setSoundResource(R.raw.waitforit);
        soundList.add(sound6);

        Sound sound7 = new Sound();
        sound7.setId(7L);
        sound7.setName("Surprise Motherfucker");
        sound7.setColor(context.getResources().getColor(R.color.red));
        sound7.setTextColor(context.getResources().getColor(R.color.white));
        sound7.setSoundResource(R.raw.surprisemotherfucker);
        soundList.add(sound7);

        Sound sound8 = new Sound();
        sound8.setId(8L);
        sound8.setName("La boule noire");
        sound8.setColor(context.getResources().getColor(R.color.yellow));
        sound8.setTextColor(context.getResources().getColor(R.color.black));
        sound8.setSoundResource(R.raw.motus);
        soundList.add(sound8);

        Sound sound9 = new Sound();
        sound9.setId(9L);
        sound9.setName("Je ne sais pas");
        sound9.setColor(context.getResources().getColor(R.color.blue));
        sound9.setTextColor(context.getResources().getColor(R.color.white));
        sound9.setSoundResource(R.raw.jenesaispas);
        soundList.add(sound9);

        Sound sound10 = new Sound();
        sound10.setId(10L);
        sound10.setName("Tabouret");
        sound10.setColor(context.getResources().getColor(R.color.red));
        sound10.setTextColor(context.getResources().getColor(R.color.white));
        sound10.setSoundResource(R.raw.tabouret);
        soundList.add(sound10);

        Sound sound11 = new Sound();
        sound11.setId(11L);
        sound11.setName("C'est vrai");
        sound11.setColor(context.getResources().getColor(R.color.yellow));
        sound11.setTextColor(context.getResources().getColor(R.color.black));
        sound11.setSoundResource(R.raw.cestvrai);
        soundList.add(sound11);

        Sound sound12 = new Sound();
        sound12.setId(12L);
        sound12.setName("Et patati");
        sound12.setColor(context.getResources().getColor(R.color.blue));
        sound12.setTextColor(context.getResources().getColor(R.color.white));
        sound12.setSoundResource(R.raw.etpatati);
        soundList.add(sound12);

        Sound sound13 = new Sound();
        sound13.setId(13L);
        sound13.setName("Even later");
        sound13.setColor(context.getResources().getColor(R.color.red));
        sound13.setTextColor(context.getResources().getColor(R.color.white));
        sound13.setSoundResource(R.raw.evenlater);
        soundList.add(sound13);

        Sound sound14 = new Sound();
        sound14.setId(14L);
        sound14.setName("Hodor");
        sound14.setColor(context.getResources().getColor(R.color.yellow));
        sound14.setTextColor(context.getResources().getColor(R.color.black));
        sound14.setSoundResource(R.raw.hodor);
        soundList.add(sound14);

        Sound sound15 = new Sound();
        sound15.setId(15L);
        sound15.setName("Ik heb geen idee");
        sound15.setColor(context.getResources().getColor(R.color.blue));
        sound15.setTextColor(context.getResources().getColor(R.color.white));
        sound15.setSoundResource(R.raw.ikhebgeenidee);
        soundList.add(sound15);

        Sound sound16 = new Sound();
        sound16.setId(16L);
        sound16.setName("Loituma");
        sound16.setColor(context.getResources().getColor(R.color.red));
        sound16.setTextColor(context.getResources().getColor(R.color.white));
        sound16.setSoundResource(R.raw.loituma);
        soundList.add(sound16);

        Sound sound17 = new Sound();
        sound17.setId(17L);
        sound17.setName("C'est la mer noire");
        sound17.setColor(context.getResources().getColor(R.color.yellow));
        sound17.setTextColor(context.getResources().getColor(R.color.black));
        sound17.setSoundResource(R.raw.mernoire);
        soundList.add(sound17);

        Sound sound18 = new Sound();
        sound18.setId(18L);
        sound18.setName("You're in my spot");
        sound18.setColor(context.getResources().getColor(R.color.blue));
        sound18.setTextColor(context.getResources().getColor(R.color.white));
        sound18.setSoundResource(R.raw.myspot);
        soundList.add(sound18);

        Sound sound19 = new Sound();
        sound19.setId(19L);
        sound19.setName("Neogotisch");
        sound19.setColor(context.getResources().getColor(R.color.red));
        sound19.setTextColor(context.getResources().getColor(R.color.white));
        sound19.setSoundResource(R.raw.neogotisch);
        soundList.add(sound19);

        Sound sound20 = new Sound();
        sound20.setId(20L);
        sound20.setName("On était bien remis d'accord");
        sound20.setColor(context.getResources().getColor(R.color.yellow));
        sound20.setTextColor(context.getResources().getColor(R.color.black));
        sound20.setSoundResource(R.raw.onestbienremisdaccord);
        soundList.add(sound20);

        Sound sound21 = new Sound();
        sound21.setId(21L);
        sound21.setName("So fluffy I'm gonna die");
        sound21.setColor(context.getResources().getColor(R.color.blue));
        sound21.setTextColor(context.getResources().getColor(R.color.white));
        sound21.setSoundResource(R.raw.sofluffyimgonnadie);
        soundList.add(sound21);

        Sound sound22 = new Sound();
        sound22.setId(22L);
        sound22.setName("So fluffay");
        sound22.setColor(context.getResources().getColor(R.color.red));
        sound22.setTextColor(context.getResources().getColor(R.color.white));
        sound22.setSoundResource(R.raw.sofluffay);
        soundList.add(sound22);

        Sound sound23 = new Sound();
        sound23.setId(23L);
        sound23.setName("This is Sparta");
        sound23.setColor(context.getResources().getColor(R.color.yellow));
        sound23.setTextColor(context.getResources().getColor(R.color.black));
        sound23.setSoundResource(R.raw.sparta);
        soundList.add(sound23);

        Sound sound24 = new Sound();
        sound24.setId(24L);
        sound24.setName("Ta kette");
        sound24.setColor(context.getResources().getColor(R.color.blue));
        sound24.setTextColor(context.getResources().getColor(R.color.white));
        sound24.setSoundResource(R.raw.takette);
        soundList.add(sound24);

        Sound sound25 = new Sound();
        sound25.setId(25L);
        sound25.setName("I know exactly what happened");
        sound25.setColor(context.getResources().getColor(R.color.red));
        sound25.setTextColor(context.getResources().getColor(R.color.white));
        sound25.setSoundResource(R.raw.whathappened);
        soundList.add(sound25);

        Sound sound26 = new Sound();
        sound26.setId(26L);
        sound26.setName("Weeeee we we weeeeee");
        sound26.setColor(context.getResources().getColor(R.color.yellow));
        sound26.setTextColor(context.getResources().getColor(R.color.black));
        sound26.setSoundResource(R.raw.wipiggy);
        soundList.add(sound26);

        Sound sound27 = new Sound();
        sound27.setId(27L);
        sound27.setName("Même que des fois ze vomis");
        sound27.setColor(context.getResources().getColor(R.color.blue));
        sound27.setTextColor(context.getResources().getColor(R.color.white));
        sound27.setSoundResource(R.raw.zevomi);
        soundList.add(sound27);

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


    public class SoundViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, StopSoundObserver, UpdateLayoutObserver {
        public TextView name;
        public RelativeLayout soundLayout;
        public LinearLayout progressLayout;
        public LinearLayout remainingProgressLayout;
        public Sound sound;
        public Context context;
        public ImageView musicImageView;
        Timer timer;

        public SoundViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.nameTextView);
            soundLayout = (RelativeLayout) itemView.findViewById(R.id.soundLayout);
            progressLayout = (LinearLayout) itemView.findViewById(R.id.progressLayout);
            remainingProgressLayout = (LinearLayout) itemView.findViewById(R.id.remainingProgressLayout);
            musicImageView = (ImageView) itemView.findViewById(R.id.musicImageView);

            itemView.setOnClickListener(this);
            observerList.add(this);

        }

        @Override
        public void onClick(View v) {

            SoundManager.getInstance().updateSound(sound.getId());
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

            player = MediaPlayer.create(context, sound.getSoundResource());
            player.setOnCompletionListener(SoundAdapter.this);
            int duration = player.getDuration();
            final float  step = duration/20;
            final float stepPercentage = (1/step);

            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                private int stepCounter = 0;
                private float progressBarPercentage = stepPercentage;
                private float remainingProgressBarPercentage = 1-stepPercentage;

                @Override
                public void run() {
                    activity.runOnUiThread(new Runnable() {
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

        @Override
        public void stopSound() {
            name.setVisibility(View.VISIBLE);
            musicImageView.setVisibility(View.GONE);
        }

        @Override
        public void updateLayout(float progressLayoutPercentage, float remainingProgressLayoutPercentage) {
            LinearLayout.LayoutParams progressLayoutParams = (LinearLayout.LayoutParams) progressLayout.getLayoutParams();
            LinearLayout.LayoutParams remainingProgressLayoutParams = (LinearLayout.LayoutParams) remainingProgressLayout.getLayoutParams();
            progressLayoutParams.weight = progressLayoutPercentage;
            remainingProgressLayoutParams.weight = remainingProgressLayoutPercentage;
            progressLayout.setLayoutParams(progressLayoutParams);
            remainingProgressLayout.setLayoutParams(remainingProgressLayoutParams);
        }
    }

    private void playSound(int soundResource) {

        player = MediaPlayer.create(context, soundResource);
        player.setOnCompletionListener(this);
        player.start();


    }

}