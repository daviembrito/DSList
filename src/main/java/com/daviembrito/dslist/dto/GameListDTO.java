package com.daviembrito.dslist.dto;

import com.daviembrito.dslist.entities.GameList;

public class GameListDTO {
    private Long id;
    private String name;

    public GameListDTO() {}

    public GameListDTO(GameList gamelist) {
        id = gamelist.getId();
        name = gamelist.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
