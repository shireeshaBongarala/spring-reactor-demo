package com.example.demo.clients;

import com.example.demo.domain.Author;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AuthorWebClient {

  private final WebClient webClient;


  public AuthorWebClient(@Value("${target.author.host}")
                             String targetHost) {
    this.webClient = WebClient.create(targetHost);
  }

  public Mono<Author> getAuthorForBook(String uuid) {
    return webClient.get().uri("/fetchByBook/{id}", uuid).retrieve().bodyToMono(Author.class);
  }


}
