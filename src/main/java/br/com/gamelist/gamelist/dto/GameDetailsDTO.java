package br.com.gamelist.gamelist.dto;

import br.com.gamelist.gamelist.entity.GameEntity;
import lombok.Getter;

import java.util.Date;

@Getter
public class GameDetailsDTO {
    private Long id;
    private String name;
    private Boolean beated;
    private Date startDate;
    private Date endDate;

    public GameDetailsDTO(GameEntity game) {
        id = game.getId();
        name = game.getName();
        beated = game.getBeated();
        startDate = game.getStartDate();
        endDate = game.getEndDate();
    }
}
