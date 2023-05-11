package com.daviembrito.dslist.controllers;

import com.daviembrito.dslist.dto.GameDTO;
import com.daviembrito.dslist.dto.GameShortDTO;
import com.daviembrito.dslist.entities.Game;
import com.daviembrito.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDTO findGameDTO(@PathVariable Long id) {
        return gameService.findGameById(id);
    }

    @GetMapping
    public List<GameShortDTO> findAllGameShortDTO() {
        return gameService.findAllGameShort();
    }
}
