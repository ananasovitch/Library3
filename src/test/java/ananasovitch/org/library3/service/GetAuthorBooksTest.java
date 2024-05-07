package ananasovitch.org.library3.service;

import ananasovitch.org.library3.model.Book;
import ananasovitch.org.library3.service.Endpoints;
import ananasovitch.org.library3.service.LibraryServiceClient;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Library Service Tests")
public class GetAuthorBooksTest {
    private static LibraryServiceClient client;

    @BeforeAll
    public static void setup() {
        client = new LibraryServiceClient(Endpoints.BASE_URI + Endpoints.BASE_PATH);
    }

    @Test
    @Story("Get Author's Books")
    @DisplayName("Get all books of an author")
    public void testGetAuthorBooks() {
        Long authorId = 1L; // Замените на существующий ID автора
        List<Book> books = client.getAuthorBooks(authorId);
        assertNotNull(books);
        assertFalse(books.isEmpty());
    }
}