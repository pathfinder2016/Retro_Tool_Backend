package com.retro.core.retro.repository;

import com.retro.core.retro.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action, String> {

}
