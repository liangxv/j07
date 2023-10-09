package com.woniuxy.p4;

public class Movie {
    private String title; //电影名字
    private String director; //导演
    private int releaseYear; //发行年份

    public Movie() {
    }

    public Movie(String title, String director, int releaseYear) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    /**
     * 获取
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return director
     */
    public String getDirector() {
        return director;
    }

    /**
     * 设置
     * @param director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * 获取
     * @return releaseYear
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * 设置
     * @param releaseYear
     */
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String toString() {
        return "Movie{title = " + title + ", director = " + director + ", releaseYear = " + releaseYear + "}";
    }
}

