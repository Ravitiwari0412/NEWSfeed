package APIs;

import java.util.ArrayList;

import Models.Article;
import Models.News;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by buck on 8/14/2017.
 */

public interface ArticlesAPI {
    @GET("articles")
    Call<News>getNews(
            @Query("source") String source,
            @Query("apiKey") String apiKey

    );

    @GET("articles")
    Call<ArrayList<Article>>getNews(
            @Query("source") String source,
            @Query("apiKey") String apiKey,
            @Path("sortBy") String sortBy


    );
}
