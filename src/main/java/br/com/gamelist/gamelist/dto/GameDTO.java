package br.com.gamelist.gamelist.dto;

import br.com.gamelist.gamelist.entity.GameEntity;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GameDTO {
    private String name;
    private Boolean beated;

    public GameDTO(GameEntity game) {
        name = game.getName();
        beated = game.getBeated();
    }

    public static List<GameDTO> converter(List<GameEntity> games) {
        return games.stream().map(GameDTO::new).collect(Collectors.toList());
    }
}
