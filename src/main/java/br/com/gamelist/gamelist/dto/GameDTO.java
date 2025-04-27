package br.com.gamelist.gamelist.dto;

import br.com.gamelist.gamelist.entity.GameEntity;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GameDTO {
    private Long id;
    private String name;
    private Boolean beated;
    private Date startedDate;

    public GameDTO(GameEntity game) {
        id = game.getId();
        name = game.getName();
        beated = game.getBeated();
        startedDate = game.getStartDate();
    }

    public static List<GameDTO> converter(List<GameEntity> games) {
        return games.stream().map(GameDTO::new).collect(Collectors.toList());
    }
}
