package com.kerboocorp.ultimatesoundbox.managers.interfaces;

import retrofit.http.PUT;
import retrofit.http.Path;

/**
 * Created by cgo on 8/01/2015.
 */
public interface SoundInterface {

    @PUT("/sound/{id}")
    void updateSound(@Path("id") Long id);

}
