package com.example.matchservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMatchOddsDto {
    String specifier;
    Double odd;
}
