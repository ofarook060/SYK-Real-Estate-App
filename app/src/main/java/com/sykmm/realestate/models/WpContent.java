package com.sykmm.realestate.models;

import com.google.gson.annotations.SerializedName;

public class WpContent {

    @SerializedName("rendered")
    private String rendered;

    public String getRendered() {
        return rendered;
    }
}