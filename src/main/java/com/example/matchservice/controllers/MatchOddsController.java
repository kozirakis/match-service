package com.example.matchservice.controllers;

import com.example.matchservice.dtos.CreateMatchOddsDto;
import com.example.matchservice.dtos.MatchOddsDto;
import com.example.matchservice.entities.MatchOdds;
import com.example.matchservice.services.MatchOddsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matchodds")
public final class MatchOddsController {
    private final MatchOddsService matchOddsService;

    @Autowired
    public MatchOddsController(MatchOddsService matchOddsService) {
        this.matchOddsService = matchOddsService;
    }

    @PostMapping("/create")
    public ResponseEntity<MatchOdds> createMatchOdds(@RequestBody CreateMatchOddsDto createDto) {
        matchOddsService.createMatchOdds(createDto);
        return new ResponseEntity<>(new MatchOdds(), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<MatchOdds> editMatchOdds(@PathVariable("id") long id,
                                                         @RequestBody MatchOddsDto editDto) {
        matchOddsService.editMatchOdds(id, editDto);
        return new ResponseEntity<>(new MatchOdds(), HttpStatus.OK);
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
    public ResponseEntity<MatchOdds> delete(@PathVariable("id") long id) {
        matchOddsService.delete(id);
        return new ResponseEntity<>(new MatchOdds(), HttpStatus.OK);
    }
}