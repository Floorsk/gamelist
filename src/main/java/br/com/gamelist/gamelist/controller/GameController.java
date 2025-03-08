package br.com.gamelist.gamelist.controller;

import br.com.gamelist.gamelist.entity.GameEntity;
import br.com.gamelist.gamelist.repository.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GameRepository GameRepository;

    // Get all games
    @RequestMapping("/game")
    public List<GameEntity> games() {
        return GameRepository.findAll();
    }

    // Get game by id
    @ResponseBody
    @RequestMapping("/gameById")
    public Object getById (@RequestParam long id) {
        return GameRepository.findById(id);
    }

    // Create game
    @Transactional
    @RequestMapping(path = "game", method = RequestMethod.POST)
    public void create (@RequestBody GameEntity Game) {
        GameRepository.save(Game);
    }

    // Update game
    @Transactional
    @PutMapping("/game")
    public void update (@RequestBody GameEntity Game) {
        create(Game);
    }

    // Delete Game
    @Transactional
    @DeleteMapping("/game")
    public void delete (@RequestParam long id) {
        GameRepository.deleteById(id);
    }
}
