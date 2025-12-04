package com.sykmm.realestate.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class WpPost {

    @SerializedName("id")
    private int id;

    @SerializedName("date")
    private String date;

    @SerializedName("link")
    private String link;

    @SerializedName("title")
    private WpTitle title;

    @SerializedName("content")
    private WpContent content;

    @SerializedName("_embedded")
    private WpEmbedded embedded;

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getLink() {
        return link;
    }

    public WpTitle getTitle() {
        return title;
    }

    public WpContent getContent() {
        return content;
    }

    public WpEmbedded getEmbedded() {
        return embedded;
    }

    public String getFeaturedImageUrl() {
        if (embedded != null && embedded.getFeaturedMedia() != null && !embedded.getFeaturedMedia().isEmpty()) {
            return embedded.getFeaturedMedia().get(0).getSourceUrl();
        }
        return null;
    }
}