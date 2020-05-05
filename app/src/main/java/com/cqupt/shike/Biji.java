package com.cqupt.shike;

public class Biji {
    private int id;
    private String title;
    private String content;
    public Biji(int id,String title,String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }
}

