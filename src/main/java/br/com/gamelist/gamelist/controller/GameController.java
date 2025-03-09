package br.com.gamelist.gamelist.controller;

import br.com.gamelist.gamelist.dto.GameDTO;
import br.com.gamelist.gamelist.dto.GameFormDTO;
import br.com.gamelist.gamelist.entity.GameEntity;
import br.com.gamelist.gamelist.repository.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameRepository GameRepository;

    // Get all games
    @GetMapping
    public List<GameDTO> games() {
        List<GameEntity> games = GameRepository.findAll();
        return GameDTO.converter(games);
    }

    // Get game by id
    @ResponseBody
    @RequestMapping("/gameById")
    public Object getById (@RequestParam long id) {
        return GameRepository.findById(id);
    }

    // Create game
    @Transactional
    @PostMapping
    public GameDTO create (@RequestBody GameFormDTO form) {
        GameEntity game = form.converter();
        GameRepository.save(game);
        return new GameDTO(game);
    }

    // Update game
    // obs: if the id already exists in the database, the jpa just updates that current object.
    @Transactional
    @PutMapping
    public void update (@RequestBody GameFormDTO form) {
        create(form);
    }

    // Delete GameS
    @Transactional
    @DeleteMapping
    public void delete (@RequestParam long id) {
        GameRepository.deleteById(id);
    }
}
