package com.woniuxy.p4;

public class AppDemo4 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.playMusic();
        phone.stopMusic();
        phone.storageMethod();
        phone.call();
    }
}

interface MusicPlayer{
    void playMusic();
    void stopMusic();

}

interface CallDevice{
    void call();
}

abstract class MediaPlayer implements MusicPlayer{

    abstract void storageMethod();

    @Override
    public void playMusic() {
        System.out.println("手机正在播放音乐");
    }

    @Override
    public void stopMusic() {
        System.out.println("手机停止播放音乐");
    }
}

class Phone extends MediaPlayer implements CallDevice{

    @Override
    public void call() {
        System.out.println("手机正在拨打电话");
    }

    @Override
    void storageMethod() {
        System.out.println("音乐存储方式为内置存储");
    }
}