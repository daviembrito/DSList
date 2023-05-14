package com.daviembrito.dslist.services;

import com.daviembrito.dslist.dto.GameListDTO;
import com.daviembrito.dslist.entities.GameList;
import com.daviembrito.dslist.projections.GameShortProjection;
import com.daviembrito.dslist.repositories.GameListRepository;
import com.daviembrito.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAllGameList() {
        return convertGameListToDTO(gameListRepository.findAll());
    }

    @Transactional
    public void replaceGameOnList(Long listId, int sourcePosition, int destinationPosition) {
        List<GameShortProjection> gamesList = gameRepository.searchByList(listId);

        validatePositions(sourcePosition, destinationPosition, gamesList.size());

        GameShortProjection game = gamesList.remove(sourcePosition);
        gamesList.add(destinationPosition, game);

        int maxPosition = Math.max(sourcePosition, destinationPosition);
        int minPosition = Math.min(sourcePosition, destinationPosition);

        for (int i = minPosition; i <= maxPosition; i++) {
            Long gameId = gamesList.get(i).getId();

            gameListRepository.updateBelongingPosition(listId, gameId, i);
        }
    }

    private List<GameListDTO> convertGameListToDTO(List<GameList> gameLists) {
        return gameLists.stream().map(GameListDTO::new).toList();
    }

    private void validatePositions(int sourcePosition, int destinationPosition, int listSize) {
        if (sourcePosition < 0 || sourcePosition >= listSize)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid source index");

        if (destinationPosition < 0 || destinationPosition >= listSize)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid destination index");
    }
}
