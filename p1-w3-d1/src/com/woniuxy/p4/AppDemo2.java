package com.woniuxy.p4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AppDemo2 {
    public static void main(String[] args) {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("盗梦空间", "克里斯托弗·诺兰", 2010));
        movieList.add(new Movie("黑暗骑士", "克里斯托弗·诺兰", 2008));
        movieList.add(new Movie("星际穿越", "克里斯托弗·诺兰", 2014));
        movieList.add(new Movie("侏罗纪公园", "史蒂文·斯皮尔伯格", 1993));
        movieList.add(new Movie("拯救大兵瑞恩", "史蒂文·斯皮尔伯格", 1998));
        movieList.add(new Movie("辛德勒的名单", "史蒂文·斯皮尔伯格", 1993));
        movieList.add(new Movie("唐伯虎点秋香", "李力持", 1993));
        movieList.add(new Movie("无间道", "刘伟强/麦兆辉", 2002));
        movieList.add(new Movie("霸王别姬", "陈凯歌", 1993));
        movieList.add(new Movie("大话西游之大圣娶亲", "刘镇伟", 1995));
        movieList.add(new Movie("让子弹飞", "姜文", 2010));
        movieList.add(new Movie("情书", "岩井俊二", 1995));

        // 查找上映年份最近的电影(最大值)，并输出其片名和上映年份。
        Movie movie = movieList.stream().max(Comparator.comparingInt(Movie::getReleaseYear)).get();
        System.out.println("上映年份最近的电影" + movie + "\n");

        // 计算所有由克里斯托弗·诺兰执导的电影有几部，并且输出电影是哪些。
        long count = movieList.stream().filter(movie1 -> movie1.getDirector().equals("克里斯托弗·诺兰执")).count();
        System.out.println("由克里斯托弗·诺兰执导的电影有" + count + "部");
        movieList.stream().filter(movie1 -> movie1.getDirector().equals("克里斯托弗·诺兰执")).forEach(System.out::println);
        System.out.println();

        // 查找所有上映年份在2000年之前的电影，并输出它们的片名和上映年份。
        movieList.stream().filter(movie1 -> movie1.getReleaseYear() < 2000).forEach(System.out::println);
        System.out.println();

        // 将片名包含"大"的电影的上映年份增加5年。
        movieList.stream().filter(movie1 -> movie1.getTitle().contains("大")).forEach(movie1 -> {
            int year = movie1.getReleaseYear() + 5;
            movie1.setReleaseYear(year);
            System.out.println(movie1);
        });
        System.out.println();

        // 对电影列表按上映年份进行升序排序，并输出排序后的电影片名和上映年份。
        movieList.stream().sorted(Comparator.comparingInt(Movie::getReleaseYear)).forEach(System.out::println);
        System.out.println();

        // 删除上映年份早于2000年的电影。
        movieList.removeIf(movie1 -> movie1.getReleaseYear() < 2000);
        movieList.forEach(System.out::println);
        System.out.println();

        // 查找所有由史蒂文·斯皮尔伯格执导的电影，并输出它们的片名和导演。
        movieList.stream().filter(movie1 -> movie1.getDirector().equals("史蒂文·斯皮尔伯格")).forEach(System.out::println);
        System.out.println();
        // 统计所有除了 史蒂文·斯皮尔伯格 和 克里斯托弗·诺兰 执导的电影之外的电影多少部，并且输出是哪些电影
        movieList.stream().filter(movie1 -> !(movie1.getDirector().equals("史蒂文·斯皮尔伯格") &&
                movie1.getDirector().equals("克里斯托弗·诺兰"))).forEach(System.out::println);

    }
}
