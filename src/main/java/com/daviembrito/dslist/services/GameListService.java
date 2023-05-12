package com.daviembrito.dslist.services;

import com.daviembrito.dslist.dto.GameListDTO;
import com.daviembrito.dslist.entities.GameList;
import com.daviembrito.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAllGameList() {
        return convertGameListToDTO(gameListRepository.findAll());
    }

    private List<GameListDTO> convertGameListToDTO(List<GameList> gameLists) {
        return gameLists.stream().map(GameListDTO::new).toList();
    }
}
