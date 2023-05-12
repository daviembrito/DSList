package com.daviembrito.dslist.repositories;

import com.daviembrito.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {}
