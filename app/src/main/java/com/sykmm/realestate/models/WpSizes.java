package com.sykmm.realestate.models;

import com.google.gson.annotations.SerializedName;

public class WpSizes {

    @SerializedName("full")
    private WpSize full;

    @SerializedName("medium")
    private WpSize medium;

    @SerializedName("thumbnail")
    private WpSize thumbnail;

    public WpSize getFull() {
        return full;
    }

    public WpSize getMedium() {
        return medium;
    }

    public WpSize getThumbnail() {
        return thumbnail;
    }
}