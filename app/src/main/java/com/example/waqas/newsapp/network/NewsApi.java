package com.example.waqas.newsapp.network;

import com.example.waqas.newsapp.BuildConfig;
import com.example.waqas.newsapp.models.ArticleResponseWrapper;
import com.example.waqas.newsapp.models.SourceResponseWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * An Api interface to send network requests
 * Includes Category enum that provides category names for requests
 */
public interface NewsApi {
    String API_KEY = BuildConfig.NewsApiKey;

    @Headers("X-Api-Key:" + API_KEY)
    @GET("/v2/top-headlines")
    Call<ArticleResponseWrapper> getHeadlines(
            @Query("category") String category,
            @Query("country") String country
    );

    @Headers("X-Api-Key:" + API_KEY)
    @GET("/v2/top-headlines")
    Call<ArticleResponseWrapper> getHeadlinesBySource(
            @Query("sources") String source
    );

    @Headers("X-Api-Key:" + API_KEY)
    @GET("/v2/sources")
    Call<SourceResponseWrapper> getSources(
            @Query("category") String category,
            @Query("country") String country,
            @Query("language") String language
    );

    enum Category {
        business("Business"),
        entertainment("Entertainment"),
        general("General"),
        health("Health"),
        science("Science"),
        sports("Sports"),
        technology("Technology");

        public final String title;

        Category(String title) {
            this.title = title;
        }
    }
}