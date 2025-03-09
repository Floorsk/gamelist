package br.com.gamelist.gamelist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    }

    public GameEntity(String name, Boolean beated, Date endDate) {
        this.name = name;
        this.beated = beated;
        this.endDate = endDate;
    }
}