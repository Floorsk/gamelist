package br.com.gamelist.gamelist.controller;

import br.com.gamelist.gamelist.entity.GameEntity;
import br.com.gamelist.gamelist.repository.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class GameController {

    @Autowired
    private GameRepository GameRepository;

    @ResponseBody
    @RequestMapping("/game")
    public List<GameEntity> list() {

        return GameRepository.findAll();

    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "game", method = RequestMethod.POST)
    public void create (@RequestBody GameEntity Game) {

        GameRepository.save(Game);

    }


}
