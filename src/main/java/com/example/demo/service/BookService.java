package com.example.demo.service;


import com.example.demo.clients.AuthorWebClient;
import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BookService {

  private final AuthorWebClient authorWebClient;

  public Mono<Book> fetchBookDetails(String uuid) {
    final Mono<Author> authorForBook = authorWebClient.getAuthorForBook(uuid);
    return authorForBook.map(author -> new Book(author, uuid));
  }

}
