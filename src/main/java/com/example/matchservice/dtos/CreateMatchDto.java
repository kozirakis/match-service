package com.example.matchservice.dtos;

import com.example.matchservice.Sport;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class CreateMatchDto {
    String description;
    LocalDate date;
    LocalTime time;
    String teamA;
    String teamB;
    Sport sport;
    List<CreateMatchOddsDto> matchOdds;
}
