package com.example.comp1008_assignment_2_javafx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Harry", "Kane", "LW", 89,67, 83, 9);
    }

    @Test
    void setFirstName() {
        player.setFirstName("lionel");
        assertEquals("Lionel", player.getFirstName());
    }

    @Test
    void setFirstNameWithSpaces() {
        player.setFirstName("   Lionel   ");
        assertEquals("Lionel", player.getFirstName());
    }

    @Test
    void setFirstNameBlank() {

        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            player.setFirstName("");
        });
    }

    @Test
    void setFirstNameSingleChar() {

        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            player.setFirstName("L");
        });
    }

    @Test
    void setLastName() {
        player.setLastName("messi");
        assertEquals("Messi", player.getLastName());
    }

    @Test
    void setLastNameWithSpaces() {
        player.setLastName("   Messi   ");
        assertEquals("Messi", player.getLastName());
    }

    @Test
    void setLastNameBlank() {

        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            player.setLastName("");
        });
    }

    @Test
    void setLastNameSingleChar() {

        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            player.setLastName("M");
        });
    }

    @Test
    void setPosition() {
        player.setPosition("lw");
        assertEquals("LW", player.getPosition());
    }


    @Test
    void setPositionWithSpaces() {
        player.setPosition("    lw    ");
        assertEquals("LW", player.getPosition());
    }

    
    @Test
    void setPositionBlank() {

        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            player.setPosition("");
        });
    }
    @Test
    void setPositionInvalid1() {

        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            player.setPosition("LE");
        });
    }
    @Test
    void setPositionInvalid2() {

        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            player.setPosition("Strik");
        });
    }
    

    @Test
    void setAttack() {
        player.setAttack(100);
        assertEquals(100, player.getAttack());
    }

    @Test
    void setAttack0() {
        player.setAttack(0);
        assertEquals(0, player.getAttack());
    }

    @Test
    void setAttackInvalid101() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            player.setAttack(101);
        });
    }

    @Test
    void setAttackNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            player.setAttack(-1);
        });
    }

    @Test
    void setDefense() {
        player.setDefense(100);
        assertEquals(100, player.getDefense());
    }

    @Test
    void setDefense0() {
        player.setDefense(0);
        assertEquals(0, player.getDefense());
    }

    @Test
    void setDefenseInvalid101() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            player.setDefense(101);
        });
    }

    @Test
    void setDefenseNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            player.setDefense(-1);
        });
    }

    @Test
    void setSpeed() {
        player.setSpeed(100);
        assertEquals(100, player.getSpeed());
    }

    @Test
    void setSpeed0() {
        player.setSpeed(0);
        assertEquals(0, player.getSpeed());
    }

    @Test
    void setSpeedInvalid101() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            player.setSpeed(101);
        });
    }

    @Test
    void setSpeedNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            player.setSpeed(-1);
        });
    }

    @Test
    void setKitNumber() {
        player.setKitNumber(99);
        assertEquals(99, player.getKitNumber());
    }

    @Test
    void setKitNumber1() {
        player.setKitNumber(1);
        assertEquals(1, player.getKitNumber());
    }

    @Test
    void setKitNumberInvalid100() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            player.setKitNumber(100);
        });
    }

    @Test
    void setKitNumberInvalid0() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            player.setKitNumber(0);
        });
    }

    @Test
    void setImageLocation() {
        player.setKitNumber(10);
        player.setFirstName("Lionel");
        player.setImageLocation(String.format("img/%d_%s.jpg",10,"Lionel"));

        assertEquals("img/10_Lionel.jpg", player.getImageLocation());
    }
    @Test
    void setImageLocationWithSpaces() {
        player.setKitNumber(10);
        player.setFirstName("Lionel");
        String name = "Lionel";
        player.setImageLocation(String.format("     img/%d_%s.jpg      ",10, name));

        assertEquals("img/10_Lionel.jpg", player.getImageLocation());
    }
    @Test
    void setImageLocationOnlyName() {
        player.setKitNumber(10);
        player.setFirstName("Lionel");

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            player.setImageLocation(String.format("%d_%s.jpg",10,"Lionel"));
        });
    }

    @Test
    void setImageLocationInvalidFirstName() {
        player.setKitNumber(10);
        player.setFirstName("Lionel");

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            player.setImageLocation(String.format("img/%d_%s.jpg",10,"leo"));
        });
    }

    @Test
    void setImageLocationBlank() {

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            player.setImageLocation("");
        });
    }
    
    @Test
    void setImageLocationHalfPath() {

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            player.setImageLocation("img/");
        });
    }

    @Test
    void testToString() {
        String playerToString = String.format("[%d]-%s %s",player.getKitNumber(), player.getFirstName(), player.getLastName());
        assertEquals(playerToString, player.toString());
    }
}