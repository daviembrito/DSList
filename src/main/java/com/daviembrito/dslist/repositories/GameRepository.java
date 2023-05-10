package com.daviembrito.dslist.repositories;

import com.daviembrito.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
