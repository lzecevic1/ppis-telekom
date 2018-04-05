package ba.unsa.etf.ppis.telekom.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contentText;
    private String imageUrl;
    private String title;
    private Timestamp publishedTimestamp;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    public News() { }

    public News(String contentText, String imageUrl, String title, Timestamp publishedTimestamp, Service service) {
        this.contentText = contentText;
        this.imageUrl = imageUrl;
        this.title = title;
        this.publishedTimestamp = publishedTimestamp;
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getPublishedTimestamp() {
        return publishedTimestamp;
    }

    public void setPublishedTimestamp(Timestamp publishedTimestamp) {
        this.publishedTimestamp = publishedTimestamp;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

}
