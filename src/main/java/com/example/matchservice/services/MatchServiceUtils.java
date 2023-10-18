package com.example.matchservice.services;

import com.example.matchservice.dtos.CreateMatchDto;
import com.example.matchservice.dtos.MatchDto;
import com.example.matchservice.entities.Match;
import com.example.matchservice.repositories.MatchRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MatchServiceUtils implements MatchService{
    private final Logger logger = LoggerFactory.getLogger(MatchServiceUtils.class);
    private final MatchRepository matchRepository;
    private ModelMapper strictModelMapper;

    @Autowired
    public MatchServiceUtils(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public void createMatch(CreateMatchDto createDto) {
        logger.info("Creating Match");
        try {
            Match match = new Match();
            strictModelMapper.map(createDto, match);
            matchRepository.save(match);
        } catch (Exception e) {
            logger.info("Exception While Creating Match");
            throw new RuntimeException(e);
        }

    }

    @Override
    public void editMatch(long id, MatchDto editDto) {
        logger.info("Editing Match");
        try {
            Match match = matchRepository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));
            strictModelMapper.map(editDto, match);
            matchRepository.save(match);
        } catch (Exception e) {
            logger.info("Exception While Editing Match");
            throw new RuntimeException(e);
        }
    }

    @Override
    public MatchDto findById(long id) {
        logger.info("Fetching Match By Id");
        try {
            Match match = matchRepository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));
            return strictModelMapper.map(match, MatchDto.class);
        } catch (Exception e) {
            logger.info("Exception While Fetching Match By Id");
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<MatchDto> findAll() {
        logger.info("Fetching All Matches");
        try {
            return matchRepository.findAll().stream().map(match -> strictModelMapper.map(match, MatchDto.class)).toList();
        } catch (Exception e) {
            logger.info("Exception While Fetching all Matches");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long id) {
        logger.info("Deleting Match");
        try {
            matchRepository.deleteById(id);
        } catch (Exception e) {
            logger.info("Exception While Deleting Match");
            throw new RuntimeException(e);
        }
    }
}
