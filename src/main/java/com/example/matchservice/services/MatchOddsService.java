package com.example.matchservice.services;

import com.example.matchservice.dtos.MatchOddsDto;
import com.example.matchservice.entities.MatchOdds;
import com.example.matchservice.repositories.MatchOddsRepository;
import com.example.matchservice.transformer.MatchOddsTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchOddsService {

    private final MatchOddsRepository matchOddsRepository;
    private final MatchOddsTransformer matchOddsTransformer;


    @Autowired
    public MatchOddsService(MatchOddsRepository matchOddsRepository, MatchOddsTransformer matchOddsTransformer) {
        this.matchOddsRepository = matchOddsRepository;
        this.matchOddsTransformer = matchOddsTransformer;
    }

    public MatchOddsDto createMatchOdds(MatchOddsDto createDto) {

        MatchOdds matchOdds = new MatchOdds();
        matchOdds.setSpecifier(createDto.getSpecifier());
        matchOdds.setOdd(createDto.getOdd());


        matchOdds = matchOddsRepository.save(matchOdds);

        return matchOddsTransformer.transform(matchOdds);
    }


    public MatchOddsDto editMatchOdds(long id, MatchOddsDto editDto) {

        MatchOdds matchOdds = matchOddsRepository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));

        matchOdds.setSpecifier(editDto.getSpecifier());
        matchOdds.setOdd(editDto.getOdd());

        matchOddsRepository.save(matchOdds);
        return matchOddsTransformer.transform(matchOdds);

    }

    public MatchOddsDto findById(long id) {

            MatchOdds matchOdds = matchOddsRepository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));
            return matchOddsTransformer.transform(matchOdds);
    }

    public List<MatchOddsDto> findAll() {
        return matchOddsRepository.findAll().stream().map(matchOddsTransformer::transform).toList();
    }

    public void delete(long id) {
        matchOddsRepository.deleteById(id);
    }

}
