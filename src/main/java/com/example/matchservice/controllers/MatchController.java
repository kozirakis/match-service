package com.example.matchservice.controllers;

import com.example.matchservice.dtos.CreateMatchDto;
import com.example.matchservice.dtos.MatchDto;
import com.example.matchservice.entities.Match;
import com.example.matchservice.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping("/create")
    public ResponseEntity<Match> createMatch(@RequestBody CreateMatchDto createDto) {
        matchService.createMatch(createDto);
        return new ResponseEntity<>(new Match(), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Match> editMatch(@PathVariable("id") long id,
                                                     @RequestBody MatchDto editDto) {
        matchService.editMatch(id, editDto);
        return new ResponseEntity<>(new Match(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<MatchDto> findById(@PathVariable("id") long id) {
        return new ResponseEntity<>(matchService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MatchDto>> findAll() {
        return new ResponseEntity<>(matchService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Match> delete(@PathVariable("id") long id) {
        matchService.delete(id);
        return new ResponseEntity<>(new Match(), HttpStatus.OK);
    }
}
