package Models;

import java.util.List;

/**
 * Created by buck on 8/12/2017.
 */

public class News {
    public String status ;
    public String source ;
    public String sortBy ;
    public List<Article> articles ;

    public String getStatus() {
        return status;
    }

    public String getSource() {
        return source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public News(String status, String source, String sortBy, List<Article> articles) {
        this.status = status;
        this.source = source;
        this.sortBy = sortBy;
        this.articles = articles;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
