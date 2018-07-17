package com.retro.core.retro.repository;

import com.retro.core.retro.model.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * https://projects.spring.io/spring-data/#quick-start
 */
@Repository
public interface CardRepository extends CrudRepository<Card, Long> {

    @Query(value = "DELETE FROM Card c where c.type = ?1")
    void removeCardsByType(String type);

    @Query(value = "SELECT * from CARD where type = ?1", nativeQuery = true)
    List<Card> findAllByType(String type);
}
