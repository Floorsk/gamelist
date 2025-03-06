package br.com.gamelist.gamelist.controller;

import br.com.gamelist.gamelist.entity.GameEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class GameController {
    @ResponseBody
    @RequestMapping("/game")
    public List<GameEntity> list() {

            GameEntity Game = new GameEntity("Persona 5", false);
            return Arrays.asList(Game, Game, Game);

    }

    @ResponseBody
    @RequestMapping(path = "game", method = RequestMethod.POST)
    public void create (@RequestBody GameEntity Game) {

    }
}
