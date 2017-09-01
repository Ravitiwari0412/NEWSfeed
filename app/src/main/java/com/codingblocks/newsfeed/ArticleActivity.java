package com.codingblocks.newsfeed;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import Models.Article;

public class ArticleActivity extends AppCompatActivity {
    TextView title,time,description,URL;
    ImageView img;
    private Article article;
    Context context;
    public static final String TAG=ArticleActivity.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_article);
        //article = getIntent().getExtras().getParcelable(TAG);

        article=getIntent().getExtras().getParcelable(TAG);
      //  Log.d(TAG, article.getTitle());
    //  getIntent().getStringExtra("author");
        title=(TextView)findViewById(R.id.tvfirstTitle);
        time=(TextView)findViewById(R.id.tvTime);
        img=(ImageView)findViewById(R.id.ivphoto);
        description=(TextView)findViewById(R.id.tvdescp);
        URL=(TextView)findViewById(R.id.tvURL);

   //     int position=getIntent().getIntExtra("position",0);
     //   article=getIntent().getExtras().getParcelable(TAG);
        title.setText(article.getTitle());


        time.setText(article.getPublishedAt());
        Picasso.with(context).load(article.getUrlToImage()).into(img);
        description.setText(article.getDescription());
        URL.setText(article.getUrl());

    }
}
