package com.example.demo.controllers;

import com.example.demo.domain.Book;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @GetMapping("/{id}")
  public Mono<ResponseEntity<Book>> fetchBookById(@PathVariable(value = "id") String uuidString) {

    return bookService.fetchBookDetails(uuidString)
        .map(book -> ResponseEntity.ok().body(book))
        .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }

}
