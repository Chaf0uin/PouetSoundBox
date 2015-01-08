package com.kerboocorp.ultimatesoundbox.model;

/**
 * Created by chris on 2/01/15.
 */
public class Sound {

    private Long id;
    private String name;
    private int color;
    private int textColor;
    private int soundResource;
    private long duration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getSoundResource() {
        return soundResource;
    }

    public void setSoundResource(int soundResource) {
        this.soundResource = soundResource;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
