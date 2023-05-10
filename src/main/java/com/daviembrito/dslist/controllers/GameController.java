package com.daviembrito.dslist.controllers;

import com.daviembrito.dslist.dto.GameShortDTO;
import com.daviembrito.dslist.entities.Game;
import com.daviembrito.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameShortDTO> findAllShort() {
        return gameService.findAllGameShort();
    }
}
