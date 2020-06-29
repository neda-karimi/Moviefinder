package com.example.moviefinder;

public class MovieClass {
    String images,summary,name,movietitle;
    public MovieClass(String images,String summary,String name,String movietitle){
        this.images=images;
        this.summary=summary;
        this.name=name;
        this.movietitle=movietitle;
    }
    public  String getImages(){
        return  images;
    }
    public  void  setImages(){
        this.images=images;
    }
    public  String getSummary(){
        return  summary;
    }
    public  void  setSummary(){
        this.summary=summary;
    }
    public  String getName(){
        return name;
    }
    public  void  setName(){
        this.name=name;
    }
    public  String getMovietitle(){
        return  movietitle;
    }
    public  void  setMovietitle(){
        this.movietitle=movietitle;
    }
}
