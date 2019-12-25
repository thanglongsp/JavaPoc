package Book.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int book_id;

    private String title;

    private String category;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    public int getId() {
        return book_id;
    }

    public void setId(int id) {
        this.book_id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}