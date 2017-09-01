package Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingblocks.newsfeed.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import Interfaces.OnItemClickListener;
import Models.Article;
import Models.News;


/**
 * Created by buck on 8/14/2017.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>{
    public static final String TAG="TAG";
     Context context;
  public List<Article> articles;
    private OnItemClickListener onItemClickListener;

    public ArticleAdapter(Context context, ArrayList<Article> articles) {
        this.context = context;
        this.articles = articles;
        Log.d(TAG, "ArticleAdapter:+this ");
    }

    public void updateArticles( ArrayList<Article>news){
        this.articles=news;
        notifyDataSetChanged();

    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");

        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView=li.inflate(R.layout.list_articles,parent,false);

        return new ArticleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        final Article thisArticle=articles.get(position);
        Picasso.with(context).load(thisArticle.getUrlToImage()).into(holder.img);
        holder.tvTitle.setText(thisArticle.getTitle());
        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener!=null){
                    onItemClickListener.OnItemClick(thisArticle);

                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView tvTitle;
        View thisView;

        public ArticleViewHolder(View itemView) {

            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.imageView);
            tvTitle=(TextView)itemView.findViewById(R.id.tvfirstTitle);
            thisView=itemView;
        }
    }
}
