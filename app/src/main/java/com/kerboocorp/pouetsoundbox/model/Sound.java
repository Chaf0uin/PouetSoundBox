package com.kerboocorp.pouetsoundbox.model;

/**
 * Created by chris on 2/01/15.
 */
public class Sound {

    private String name;
    private String color;
    private String textColor;
    private int soundResource;
    private long duration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
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
