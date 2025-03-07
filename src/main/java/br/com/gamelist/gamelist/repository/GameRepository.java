package br.com.gamelist.gamelist.repository;

import br.com.gamelist.gamelist.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, Long> {
        
}