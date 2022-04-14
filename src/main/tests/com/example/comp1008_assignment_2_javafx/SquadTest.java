package com.example.comp1008_assignment_2_javafx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquadTest {

    private Squad squad;
    private Player player;
    private Player newPlayer;

    @BeforeEach
    void setUp() {
        squad = new Squad("Argentina");
        player = new Player("Sergio", "Aguero", "ST", 89,67, 83, 9);
        squad.addPlayer(player);
        newPlayer = new Player("Lionel", "Messi", "LW", 96,69, 87, 9);
        squad.addPlayer(newPlayer);
    }

    @Test
    void setSquadName() {
        squad.setSquadName("england");
        assertEquals("England", squad.getSquadName());
    }

    @Test
    void setSquadNameWithSpaces() {
        squad.setSquadName("    England     ");
        assertEquals("England", squad.getSquadName());
    }
    @Test
    void setSquadNameBlank() {

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            squad.setSquadName("");
        });
    }
    
    @Test
    void setSquadNameInvalidLength() {

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            squad.setSquadName("E");
        });
    }

    @Test
    void getSquadStrength() {

        int averageSquadStrength = (player.getAttack() + player.getDefense() + player.getSpeed() + newPlayer.getAttack() + newPlayer.getDefense() + newPlayer.getSpeed())/6;
        assertEquals(averageSquadStrength ,squad.getSquadStrength());

    }

    @Test
    void getStrongestPlayer() {
        assertEquals(newPlayer, squad.getStrongestPlayer());
    }

    @Test
    void getWeakestPlayer() {
        assertEquals(player, squad.getWeakestPlayer());
    }
}