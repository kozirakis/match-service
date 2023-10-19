package com.example.matchservice.controllers;

import com.example.matchservice.dtos.MatchDto;
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
    public ResponseEntity<MatchDto> createMatch(@RequestBody MatchDto createDto) {
        MatchDto matchDto = matchService.createMatch(createDto);
        return new ResponseEntity<>(matchDto, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<MatchDto> editMatch(@PathVariable("id") long id,
                                              @RequestBody MatchDto editDto) {
        MatchDto matchDto = matchService.editMatch(id, editDto);
        return new ResponseEntity<>(matchDto, HttpStatus.OK);
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
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        matchService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
