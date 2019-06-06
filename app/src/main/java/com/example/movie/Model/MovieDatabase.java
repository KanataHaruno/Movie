package com.example.movie.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieDatabase {

    @SerializedName("page")
    private Integer page;

    @SerializedName("total_results")
    private Integer totalResults;

    @SerializedName("total_pages")
    private Integer totalPages;

    @SerializedName("results")
    private List<Movie> results;

    public MovieDatabase(Integer page, Integer totalResults, Integer totalPages, List<Movie> results){
        this.setPage(page);
        this.setTotalResults(totalResults);
        this.setTotalPage(totalPages);
        this.setResults(results);
    }

    public Integer getPage(){ return page; }
    public void setPage(Integer page){ this.page = page; }

    public Integer getTotalResults(){ return totalResults; }
    public void setTotalResults(Integer totalResults){ this.totalResults = totalResults; }

    public Integer getTotalPage(){ return totalPages; }
    public void setTotalPage(Integer totalPage){ this.totalPages = totalPage; }

    public List<Movie> getResults(){ return results; }
    public void setResults(List<Movie> results){ this.results = results; }




}
