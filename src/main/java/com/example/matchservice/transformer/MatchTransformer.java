package com.example.matchservice.transformer;

import com.example.matchservice.dtos.MatchDto;
import com.example.matchservice.dtos.MatchOddsDto;
import com.example.matchservice.entities.Match;
import com.example.matchservice.entities.MatchOdds;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MatchTransformer {

    public MatchDto transform(Match match) {

        MatchDto matchDto = new MatchDto();
        matchDto.setDescription(match.getDescription());
        matchDto.setMatchDate(match.getMatchDate());
        matchDto.setMatchTime(match.getMatchTime());
        matchDto.setSport(match.getSport());
        matchDto.setTeamA(match.getTeamA());
        matchDto.setTeamB(match.getTeamB());
        matchDto.setMatchOdds(new ArrayList<>());
        for(MatchOdds matchOdds: match.getMatchOdds()) {
            MatchOddsDto matchOddsDto = new MatchOddsDto();
            matchOddsDto.setOdd(matchOdds.getOdd());
            matchOddsDto.setSpecifier(matchOdds.getSpecifier());
            matchDto.getMatchOdds().add(matchOddsDto);
        }
        return matchDto;
    }
}
