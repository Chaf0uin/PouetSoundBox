package com.kerboocorp.ultimatesoundbox.managers;

import com.kerboocorp.ultimatesoundbox.managers.interfaces.SoundInterface;

import retrofit.RestAdapter;

/**
 * Created by cgo on 8/01/2015.
 */
public class SoundManager {

    private static SoundManager instance = new SoundManager();
    private SoundInterface service;

    private SoundManager() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://www.bananacorp.net")
                .build();

        service = restAdapter.create(SoundInterface.class);
    }

    public static SoundManager getInstance() {
        return instance;
    }


    public void updateSound(Long id) {
        //service.updateSound(id, Callback);
    }
}
