package com.example.nemo1.ifixit.Entity;

public class Results {
    private String dataType;
    private int wikiid;
    private String title;
    private String display_title;
    private String namespace;
    private String summary;
    private String url;
    private String text;
    private Image image;
    private int modified_date;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getWikiid() {
        return wikiid;
    }

    public void setWikiid(int wikiid) {
        this.wikiid = wikiid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDisplay_title() {
        return display_title;
    }

    public void setDisplay_title(String display_title) {
        this.display_title = display_title;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getModified_date() {
        return modified_date;
    }

    public void setModified_date(int modified_date) {
        this.modified_date = modified_date;
    }
}
