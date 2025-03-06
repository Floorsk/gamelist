package br.com.gamelist.gamelist;

import entity.Game;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class GameController {
    @ResponseBody
    @RequestMapping("/Games")
    public List<Game> list() {

            Game  Game = new Game("Persona 5", false);

            return Arrays.asList(Game, Game, Game);

    }
}
