package br.com.gamelist.gamelist.dto;

import br.com.gamelist.gamelist.entity.GameEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class GameFormDTO {
    private Long id;
    private String name;
    private Boolean beated;
    private Date startDate;
    private Date endDate;

    public GameEntity converter() {
        GameEntity game = new GameEntity();
        game.setId(id);
        game.setName(name);
        game.setBeated(beated);
        game.setStartDate(startDate);
        game.setEndDate(endDate);
        return game;
    }
}
