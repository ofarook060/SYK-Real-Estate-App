package com.sykmm.realestate.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WpEmbedded {

    @SerializedName("wp:featuredMedia")
    private List<WpFeaturedMedia> featuredMedia;

    public List<WpFeaturedMedia> getFeaturedMedia() {
        return featuredMedia;
    }
}