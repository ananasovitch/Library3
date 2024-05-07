package ananasovitch.org.library3.Request;

import ananasovitch.org.library3.model.Author;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookRequest {
    private String bookTitle;
    private Long authorId;
}