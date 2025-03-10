package br.com.gamelist.gamelist.dto;

import br.com.gamelist.gamelist.entity.GameEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GameUpdateDTO {
    private Boolean beated;

    public void update (GameEntity game) {
        game.setBeated(beated);
    }
}
