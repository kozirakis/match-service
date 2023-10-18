package com.example.matchservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MatchOddsDto {

    private String specifier;

    private double odd;
}
