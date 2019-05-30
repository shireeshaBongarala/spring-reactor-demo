package com.example.demo.domain;

import lombok.Data;
import lombok.Value;

@Value
public class Book {

  Author author;
  String uuid;
}
