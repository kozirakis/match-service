package com.example.matchservice.transformer;

import com.example.matchservice.dtos.MatchOddsDto;
import com.example.matchservice.entities.MatchOdds;
import org.springframework.stereotype.Service;

@Service
public class MatchOddsTransformer {

    public MatchOddsDto transform(MatchOdds matchOdds) {

        MatchOddsDto matchOddsDto = new MatchOddsDto();
        matchOddsDto.setOdd(matchOdds.getOdd());
        matchOddsDto.setSpecifier(matchOdds.getSpecifier());

        return matchOddsDto;
    }

}
