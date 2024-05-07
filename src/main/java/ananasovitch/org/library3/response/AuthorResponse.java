package ananasovitch.org.library3.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorResponse {
    private Long authorId;
    private String errorCode;
    private String errorMessage;
    private String errorDetails;
}