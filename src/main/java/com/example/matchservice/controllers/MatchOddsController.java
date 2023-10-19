package com.example.matchservice.controllers;

import com.example.matchservice.dtos.MatchOddsDto;
import com.example.matchservice.services.MatchOddsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matchodds")
public final class MatchOddsController {
    @Autowired
    private final MatchOddsService matchOddsService;

    @Autowired
    public MatchOddsController(MatchOddsService matchOddsService) {
        this.matchOddsService = matchOddsService;
    }

    @PostMapping("/create")
    public ResponseEntity<MatchOddsDto> createMatchOdds(@RequestBody MatchOddsDto createDto) {
        MatchOddsDto matchOddsDto = matchOddsService.createMatchOdds(createDto);
        return new ResponseEntity<>(matchOddsDto, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<MatchOddsDto> editMatchOdds(@PathVariable("id") long id,
                                                   @RequestBody MatchOddsDto editDto) {
        MatchOddsDto matchOddsDto = matchOddsService.editMatchOdds(id, editDto);
        return new ResponseEntity<>(matchOddsDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<MatchOddsDto> findById(@PathVariable("id") long id) {
        return new ResponseEntity<>(matchOddsService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MatchOddsDto>> findAll() {
        return new ResponseEntity<>(matchOddsService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        matchOddsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}