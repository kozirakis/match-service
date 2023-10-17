package com.example.matchservice.Controllers;

import com.example.matchservice.entities.MatchOdds;
import com.example.matchservice.repositories.MatchOddsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matchodds")
public final class MatchOddsController {
    private final MatchOddsRepository matchOddsRepository;

    @Autowired
    public MatchOddsController(MatchOddsRepository matchOddsRepository) {
        this.matchOddsRepository = matchOddsRepository;
    }

    @GetMapping
    public List<MatchOdds> getAllMatchOdds() {
        return matchOddsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<MatchOdds> getMatchOddsById(@PathVariable Long id) {
        return matchOddsRepository.findById(id);
    }

    @PostMapping
    public MatchOdds addMatchOdds(@RequestBody MatchOdds matchOdds) {
        return matchOddsRepository.save(matchOdds);
    }

    @PutMapping("/{id}")
    public MatchOdds updateMatchOdds(@PathVariable Long id, @RequestBody MatchOdds updatedMatchOdds) {
        if (!id.equals(updatedMatchOdds.getId())) {
            throw new IllegalArgumentException("ID in the path does not match the ID in the request body.");
        }
        return matchOddsRepository.save(updatedMatchOdds);
    }

    @DeleteMapping("/{id}")
    public void deleteMatchOdds(@PathVariable Long id) {
        matchOddsRepository.deleteById(id);
    }
}