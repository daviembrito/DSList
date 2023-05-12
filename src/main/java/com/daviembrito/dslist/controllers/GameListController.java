package com.daviembrito.dslist.controllers;

import com.daviembrito.dslist.dto.GameListDTO;
import com.daviembrito.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAllGameListDTO() {
        return gameListService.findAllGameList();
    }
}
