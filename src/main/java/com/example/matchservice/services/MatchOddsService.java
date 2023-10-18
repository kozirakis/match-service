package com.example.matchservice.services;

import com.example.matchservice.dtos.CreateMatchOddsDto;
import com.example.matchservice.dtos.MatchOddsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatchOddsService {

    void createMatchOdds(CreateMatchOddsDto createDto);
    void editMatchOdds(long id, MatchOddsDto editDto);
    MatchOddsDto findById(long id);
    List<MatchOddsDto> findAll();
    void delete(long id);
}
