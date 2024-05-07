package ananasovitch.org.library3.service;

import ananasovitch.org.library3.Request.BookRequest;
import ananasovitch.org.library3.response.BookResponse;
import ananasovitch.org.library3.service.Endpoints;
import ananasovitch.org.library3.service.LibraryServiceClient;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Library Service Tests")
public class SaveBookTest {
    private static LibraryServiceClient client;

    @BeforeAll
    public static void setup() {
        client = new LibraryServiceClient(Endpoints.BASE_URI + Endpoints.BASE_PATH);
    }

    @Test
    @Story("Save Book")
    @DisplayName("Save a new book")
    public void testSaveBook() {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setBookTitle("Test Book");
        bookRequest.setAuthorId(1L); // Замените на существующий ID автора

        BookResponse bookResponse = client.saveBook(bookRequest);
        assertNotNull(bookResponse);
        assertNull(bookResponse.getErrorCode());
        assertNull(bookResponse.getErrorMessage());
        assertNull(bookResponse.getErrorDetails());
        assertNotNull(bookResponse.getBookId());
    }
}
