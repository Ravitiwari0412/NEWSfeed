package com.codingblocks.newsfeed;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

import APIs.ArticlesAPI;
import Adapters.ArticleAdapter;
import Interfaces.OnItemClickListener;
import Models.Article;
import Models.News;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvNewsList;
    ArticleAdapter articleAdapter;
    private final static String BASE_URL = "https://newsapi.org/v1/";
    private final static String API_KEY = "94a639407bf948c79364aa4d8ec5b82f";
    public static final String TAG="TAG";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvNewsList=(RecyclerView)findViewById(R.id.rvNews);
        rvNewsList.setLayoutManager(new LinearLayoutManager(this));

        articleAdapter=new ArticleAdapter(this,new ArrayList<Article>());
        rvNewsList.setAdapter(articleAdapter);

//
       articleAdapter.setOnItemClickListener(new OnItemClickListener() {
           @Override
            public Void OnItemClick(Article article) {
                Intent intent=new Intent(MainActivity.this,ArticleActivity.class);
                intent.putExtra(ArticleActivity.TAG,article);
                startActivity(intent);
                return null;
            }});

        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create())
                .build();
        ArticlesAPI articlesAPI=retrofit.create(ArticlesAPI.class);
        articlesAPI.getNews(Sources.GoogleNews.toString(),getApiKey()).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Response<News> response, Retrofit retrofit) {
              //  Log.d(TAG, "onResponse: "+response.body().size());

                articleAdapter.articles=response.body().getArticles();
                articleAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        articlesAPI.getNews(Sources.ABC.toString(),getApiKey()).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Response<News> response, Retrofit retrofit) {
                //  Log.d(TAG, "onResponse: "+response.body().size());

                articleAdapter.articles=response.body().getArticles();
                articleAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
        articlesAPI.getNews(Sources.ArsTechnica.toString(),getApiKey()).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Response<News> response, Retrofit retrofit) {
                //  Log.d(TAG, "onResponse: "+response.body().size());

                articleAdapter.articles=response.body().getArticles();
                articleAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });







    }






    public static String getApiKey(){return API_KEY;};

    public enum SortBy{
        TOP("top"),
        LATEST("latest"),
        POPULAR("popular");

        private String sort;

        private SortBy(final String sort){
            this.sort = sort;
        }

        @Override
        public String toString() {
            return sort;
        }
    }

    public enum Sources{
        ABC("abc-news-au"),
        ArsTechnica("ars-technica"),
        GoogleNews("google-news");
        private String source;

        private Sources(final String source){
            this.source = source;
        }

        @Override
        public String toString() {
            return source;
        }
}


}
