package com.example.matchservice.services;

import com.example.matchservice.dtos.MatchDto;
import com.example.matchservice.dtos.MatchOddsDto;
import com.example.matchservice.entities.Match;
import com.example.matchservice.entities.MatchOdds;
import com.example.matchservice.repositories.MatchOddsRepository;
import com.example.matchservice.repositories.MatchRepository;
import com.example.matchservice.transformer.MatchTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    private final MatchRepository matchRepository;

    private final MatchTransformer matchTransformer;

    @Autowired
    public MatchService(MatchRepository matchRepository, MatchOddsRepository matchOddsRepository, MatchTransformer matchTransformer) {
        this.matchRepository = matchRepository;
        this.matchTransformer = matchTransformer;
    }

    public MatchDto createMatch(MatchDto createDto) {

        Match match = new Match();
        match.setDescription(createDto.getDescription());
        match.setMatchDate(createDto.getMatchDate());
        match.setMatchTime(createDto.getMatchTime());
        match.setSport(createDto.getSport());
        match.setTeamA(createDto.getTeamA());
        match.setTeamB(createDto.getTeamB());

        for (MatchOddsDto matchOddsDto : createDto.getMatchOdds()) {
            MatchOdds matchOdds = new MatchOdds();
            matchOdds.setOdd(matchOddsDto.getOdd());
            matchOdds.setSpecifier(matchOddsDto.getSpecifier());
            matchOdds.setMatch(match);
            match.getMatchOdds().add(matchOdds);
        }

        match = matchRepository.save(match);

        return matchTransformer.transform(match);
    }


    public MatchDto editMatch(long id, MatchDto editDto) {

        Match match = matchRepository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));

        match.setDescription(editDto.getDescription());
        match.setMatchDate(editDto.getMatchDate());
        match.setMatchTime(editDto.getMatchTime());
        match.setSport(editDto.getSport());
        match.setTeamA(editDto.getTeamA());
        match.setTeamB(editDto.getTeamB());
        match.getMatchOdds().clear();
        for (MatchOddsDto matchOddsDto : editDto.getMatchOdds()) {
            MatchOdds matchOdds = new MatchOdds();
            matchOdds.setOdd(matchOddsDto.getOdd());
            matchOdds.setSpecifier(matchOddsDto.getSpecifier());
            matchOdds.setMatch(match);
            match.getMatchOdds().add(matchOdds);
        }
        match = matchRepository.save(match);
        return matchTransformer.transform(match);
    }


    public MatchDto findById(long id) {

        Match match = matchRepository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));
        return matchTransformer.transform(match);
    }


    public List<MatchDto> findAll() {

        return matchRepository.findAll().stream().map(matchTransformer::transform).toList();

    }

    public void delete(long id) {
        matchRepository.deleteById(id);
    }
}
