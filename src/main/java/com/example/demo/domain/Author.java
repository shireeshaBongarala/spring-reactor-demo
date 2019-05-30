package com.example.demo.domain;

import java.util.UUID;

import lombok.Value;

@Value
public class Author {
  UUID uuid;
  String name;
}
