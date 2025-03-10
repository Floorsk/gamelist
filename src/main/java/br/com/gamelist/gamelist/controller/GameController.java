package br.com.gamelist.gamelist.controller;

import br.com.gamelist.gamelist.dto.GameDTO;
import br.com.gamelist.gamelist.dto.GameDetailsDTO;
import br.com.gamelist.gamelist.dto.GameFormDTO;
import br.com.gamelist.gamelist.dto.GameUpdateDTO;
import br.com.gamelist.gamelist.entity.GameEntity;
import br.com.gamelist.gamelist.repository.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

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
    @GetMapping("/gameById")
    public Object getById (@RequestParam Long id) {
        final Optional<GameEntity> game = GameRepository.findById(id);

        if (game.isPresent()) {
            return GameRepository.findById(id);
        }

        return new ResponseEntity("The game aint in the database", HttpStatus.OK);
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
    @PutMapping("/{id}")
    public GameDetailsDTO update (@PathVariable Long id,  @RequestBody GameUpdateDTO form) {
        final Optional<GameEntity> optGame = GameRepository.findById(id);

        if (optGame.isPresent()) {
            GameEntity game = optGame.get();
            form.update(game);
            GameRepository.save(game);
            return new GameDetailsDTO(game);
        }

        return null;
    }

    // Delete Game
    @Transactional
    @DeleteMapping
    public Object delete (@RequestParam long id) {
        final Optional<GameEntity> optGame = GameRepository.findById(id);

        if (optGame.isPresent()) {
            GameRepository.deleteById(id);
        }

        return new ResponseEntity("The game was not found at the database", HttpStatus.OK);
    }
}