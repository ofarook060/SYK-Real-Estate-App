package com.sykmm.realestate.models;

import com.google.gson.annotations.SerializedName;

public class WpMediaDetails {

    @SerializedName("sizes")
    private WpSizes sizes;

    public WpSizes getSizes() {
        return sizes;
    }
}