package com.example.matchservice.services;

import com.example.matchservice.dtos.CreateMatchDto;
import com.example.matchservice.dtos.MatchDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatchService {
    void createMatch(CreateMatchDto createDto);
    void editMatch(long id, MatchDto editDto);
    MatchDto findById(long id);
    List<MatchDto> findAll();
    void delete(long id);
}
