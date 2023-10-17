
package com.example.matchservice.repositories;

import com.example.matchservice.entities.MatchOdds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchOddsRepository extends JpaRepository<MatchOdds, Long> {
    // You can add custom query methods here if needed
}
