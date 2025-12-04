package com.sykmm.realestate.api;

import com.sykmm.realestate.models.WpPost;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    // Get posts with embedded featured media
    @GET("wp-json/wp/v2/posts?_embed")
    Call<List<WpPost>> getPosts();

    /*
     Optional: Get limited number of posts
     @GET("wp-json/wp/v2/posts?_embed")
     Call<List<WpPost>> getPosts(
             @Query("per_page") int perPage,
             @Query("orderby") String orderBy
     );
    */
}