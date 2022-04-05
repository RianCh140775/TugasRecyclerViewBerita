package com.example.recyclerviewberita.model;

import java.util.List;
import javax.annotation.Generated;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")

public class News {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;
    @SerializedName("articles")
    @Expose
    private List<Article> articles = null;
    public final static Creator<News> CREATOR = new Creator<News>() {


        @SuppressWarnings({
                "unchecked"
        })
        public News createFromParcel(android.os.Parcel in) {
            return new News(in);
        }

        public News[] newArray(int size) {
            return (new News[size]);
        }

    }
            ;

    protected News(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.totalResults = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.articles, (com.example.recyclerviewberita.model.Article.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public News() {
    }

    /**
     *
     * @param totalResults
     * @param articles
     * @param status
     */
    public News(String status, Integer totalResults, List<Article> articles) {
        super();
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(News.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("totalResults");
        sb.append('=');
        sb.append(((this.totalResults == null)?"<null>":this.totalResults));
        sb.append(',');
        sb.append("articles");
        sb.append('=');
        sb.append(((this.articles == null)?"<null>":this.articles));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(totalResults);
        dest.writeList(articles);
    }

    public int describeContents() {
        return  0;
    }


}
