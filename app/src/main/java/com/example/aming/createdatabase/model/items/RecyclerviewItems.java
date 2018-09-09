package com.example.aming.createdatabase.model.items;

public class RecyclerviewItems{
    private String title;
    private Long id;
    private String content;
    private String cratedate;

    public RecyclerviewItems( Long id,String title, String content, String cratedate) {
        this.title = title;
        this.id = id;
        this.content = content;
        this.cratedate = cratedate;
    }
    public RecyclerviewItems(){}
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

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
