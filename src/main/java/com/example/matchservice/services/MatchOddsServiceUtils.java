package com.example.matchservice.services;

import com.example.matchservice.dtos.CreateMatchOddsDto;
import com.example.matchservice.dtos.MatchOddsDto;
import com.example.matchservice.entities.MatchOdds;
import com.example.matchservice.repositories.MatchOddsRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchOddsServiceUtils implements MatchOddsService {

    private final Logger logger = LoggerFactory.getLogger(MatchOddsServiceUtils.class);
    private final MatchOddsRepository matchOddsRepository;



    @Autowired
    public MatchOddsServiceUtils(MatchOddsRepository matchOddsRepository) {
        this.matchOddsRepository = matchOddsRepository;
    }

    @Override
    public void createMatchOdds(CreateMatchOddsDto createDto) {
        logger.info("Creating Match Odds");
        try {
            MatchOdds matchOdds = new MatchOdds();

            matchOddsRepository.save(matchOdds);
        } catch (Exception e) {
            logger.info("Exception While Creating Match Odds");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editMatchOdds(long id, MatchOddsDto editDto) {
        logger.info("Editing Match Odds");
        try {
            MatchOdds matchOdds = matchOddsRepository.findById(id).orElseThrow(() ->  new RuntimeException("Entity not found"));

            matchOddsRepository.save(matchOdds);
        } catch (Exception e) {
            logger.info("Exception While Editing Match Odds");
            throw new RuntimeException(e);
        }
    }

    @Override
    public MatchOddsDto findById(long id) {
        logger.info("Fetching Match Odds By Id");
        try {
            MatchOdds matchOdds = matchOddsRepository.findById(id).orElseThrow(() ->  new RuntimeException("Entity not found"));
            return null;
        } catch (Exception e) {
            logger.info("Exception While Fetching Match Odds By Id");
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<MatchOddsDto> findAll() {
        logger.info("Fetching All Match Odds");
        try {
            return null;
        } catch (Exception e) {
            logger.info("Exception While Fetching All Match Odds");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long id) {
        logger.info("Deleting Match Odds");
        try {
            matchOddsRepository.deleteById(id);
        } catch (Exception e) {
            logger.info("Exception While Deleting Match Odds");
            throw new RuntimeException(e);
        }
    }

}
