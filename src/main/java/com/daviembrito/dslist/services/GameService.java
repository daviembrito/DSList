package com.daviembrito.dslist.services;

import com.daviembrito.dslist.dto.GameDTO;
import com.daviembrito.dslist.dto.GameShortDTO;
import com.daviembrito.dslist.entities.Game;
import com.daviembrito.dslist.projections.GameShortProjection;
import com.daviembrito.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameShortDTO> findGamesByList(Long listId) {
        return convertProjectionsToGameShortDTO(gameRepository.searchByList(listId));
    }

    @Transactional(readOnly = true)
    public GameDTO findGameById(Long gameId) {
        Game result = gameRepository.findById(gameId).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameShortDTO> findAllGameShort() {
        return convertGamesToGameShortDTO(gameRepository.findAll());
    }

    private List<GameShortDTO> convertGamesToGameShortDTO(List<Game> games) {
        return games.stream().map(GameShortDTO::new).toList();
    }

    private List<GameShortDTO> convertProjectionsToGameShortDTO(List<GameShortProjection> gameProjections) {
        return gameProjections.stream().map(GameShortDTO::new).toList();
    }
}
