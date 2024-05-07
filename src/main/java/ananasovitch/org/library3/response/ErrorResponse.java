package ananasovitch.org.library3.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse {
    private int errorCode;
    private String errorMessage;
    private String errorDetails;
}
