package com.daviembrito.dslist.services;

import com.daviembrito.dslist.dto.GameShortDTO;
import com.daviembrito.dslist.entities.Game;
import com.daviembrito.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<GameShortDTO> findAllGameShort() {
        return convertGameToDTO(gameRepository.findAll());
    }

    private List<GameShortDTO> convertGameToDTO(List<Game> games) {
        return games.stream().map(GameShortDTO::new).toList();
    }
}
