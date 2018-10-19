package kr.co.uniess.kto.batch.model.csv;

import com.opencsv.bean.CsvBindByName;

public class Image {

    @CsvBindByName
    private String cid;

    @CsvBindByName
    private String title;

    @CsvBindByName
    private String url;

    @CsvBindByName
    private boolean primary;

    public Image(String cid, String title, String url) {
        this(cid, title, url, false);
    }

    public Image(String cid, String title, String url, boolean isPrimary) {
        this.cid = cid;
        this.title = title;
        this.url = url;
        this.primary = isPrimary;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean getPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Image{cid=").append(cid).append(", title=").append(title).append(", url=").append(url)
                .append(", primary=").append(primary).append("}");
        return builder.toString();
    }
}