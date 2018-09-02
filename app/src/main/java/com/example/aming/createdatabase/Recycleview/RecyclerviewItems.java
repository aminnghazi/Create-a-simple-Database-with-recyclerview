package com.example.aming.createdatabase.Recycleview;

public class RecyclerviewItems{
    private String title;
    private String id;
    private String content;
    private String cratedate;

    public RecyclerviewItems(String title, String id, String content, String cratedate) {
        this.title = title;
        this.id = id;
        this.content = content;
        this.cratedate = cratedate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCratedate() {
        return cratedate;
    }

    public void setCratedate(String cratedate) {
        this.cratedate = cratedate;
    }
}
