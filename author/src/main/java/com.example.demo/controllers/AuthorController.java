package com.example.demo.controllers;

import com.example.demo.domain.Author;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

  @GetMapping("fetchByBook/{id}")
  public ResponseEntity<Author> fetchBookById(@PathVariable(value = "id") String uuidString) {

    return ResponseEntity.ok().body(new Author("Shireesha"));
  }
}
