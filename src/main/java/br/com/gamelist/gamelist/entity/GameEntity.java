package br.com.gamelist.gamelist.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Boolean beated;
    private Date startDate;
    private Date endDate;

    @PrePersist
    protected void onCreate() {
        startDate = new Date();
        beated =  false;
        endDate = null;
    }

    public GameEntity(@NonNull String name) {
        this.name = name;
    }
}