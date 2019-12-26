package Book.dto;

import lombok.Data;
import javax.persistence.Id;

@Data
public class BookDto {
    @Id
    private int id;
    private String description;
    private String title;

    public BookDto(String description, int id, String title) {
        this.id = id;
        this.description = description;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
