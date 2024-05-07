package ananasovitch.org.library3.service;

import ananasovitch.org.library3.Request.AuthorRequest;
import ananasovitch.org.library3.Request.BookRequest;
import ananasovitch.org.library3.model.Book;
import ananasovitch.org.library3.response.AuthorResponse;
import ananasovitch.org.library3.response.BookResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

public class LibraryServiceClient {
    private final RequestSpecification requestSpecification;

    public LibraryServiceClient(String baseUrl) {
        RestAssured.baseURI = baseUrl;
        requestSpecification = RestAssured.given().contentType(ContentType.JSON);
    }

    public AuthorResponse saveAuthor(AuthorRequest authorRequest) {
        Response response = requestSpecification.body(authorRequest).post(Endpoints.AUTHORS_SAVE);
        return response.as(AuthorResponse.class);
    }

    public BookResponse saveBook(BookRequest bookRequest) {
        Response response = requestSpecification.body(bookRequest).post(Endpoints.BOOKS_SAVE);
        return response.as(BookResponse.class);
    }

    public List<Book> getAuthorBooks(Long authorId) {
        Response response = requestSpecification.get(Endpoints.AUTHORS_BOOKS.replace("{id}", authorId.toString()));
        return response.jsonPath().getList(".", Book.class);
    }
}