package com.daviembrito.dslist.controllers;

import com.daviembrito.dslist.dto.GameListDTO;
import com.daviembrito.dslist.dto.GameShortDTO;
import com.daviembrito.dslist.dto.ReplacementDTO;
import com.daviembrito.dslist.services.GameListService;
import com.daviembrito.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAllGameListDTO() {
        return gameListService.findAllGameList();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameShortDTO> findGamesByList(@PathVariable Long listId) {
        return gameService.findGamesByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void replaceGame(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.replaceGameOnList(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
