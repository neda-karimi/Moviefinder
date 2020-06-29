package com.example.moviefinder;

public class MovieClass {
    String poster_path,overview,title;
    public MovieClass(String poster_path,String overview,String title){
        this.poster_path=poster_path;
        this.overview=overview;
        this.title=title;

    }


    public  String getPoster_path(){
        return  poster_path;
    }
    public  void  setPoster_path(String poster_path){
        this.poster_path=poster_path;
    }
    public  String getOverview(){
        return overview;
    }
    public  void  setOverview(String overview){
        this.overview=overview;
    }
    public  String getTitle(){
        return title;
    }
    public  void  setTitle(){
        this.title=title;
    }

}
