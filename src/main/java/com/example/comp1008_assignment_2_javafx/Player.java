package com.example.comp1008_assignment_2_javafx;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is the Player model class which is used to store the attributes of a soccer player.
 */
public class Player {
    private String firstName, lastName, position;
    private int attack, defense, speed, kitNumber;
    private Image image;

    /**
     * This is the Player class constructor which uses various set methods to populate the instance variables after necessary validation
     * @param firstName - this stores the first name
     * @param lastName - this stores the last name
     * @param position - this stores the position at which the player plays
     * @param attack - this stores the player's attacking ability
     * @param defense - this stores the player's defensive ability
     * @param speed - this stores the speed of each player
     * @param kitNumber - this stores the kit number assigned to each player
     * @param image - this stores the image of each player
     */
    public Player(String firstName, String lastName, String position, int attack, int defense, int speed, int kitNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setPosition(position);
        setAttack(attack);
        setDefense(defense);
        setSpeed(speed);
        setKitNumber(kitNumber);
        String fileName = String.format("img/%s.jpg",getFirstName());
        try {

            image = new Image(getClass().getResource(fileName).toExternalForm());
        }
        catch (Exception e) {
            image = new Image(getClass().getResource("img/noImage.jpg").toExternalForm());
        }

//        setImage(image);

    }

    /**
     * This is the getter for firstName instance variable
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * this sets the firstName instance variable after performing the necessary validation
     * @param firstName
     */
    public void setFirstName(String firstName) {
        firstName = firstName.trim();
        if (firstName.length() >= 2)
        {
            firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase();
            this.firstName = firstName;
        }
        else
        {
            throw new IllegalArgumentException("Please enter a valid first name only! A valid first name contains at least 2 characters.");
        }
    }

    /**
     * Getter for lastName
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for lastName, sets it after performing necessary validation
     * @param lastName
     */
    public void setLastName(String lastName) {
        lastName = lastName.trim();
        if (lastName.length() >= 2)
        {
            lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase();
            this.lastName = lastName;
        }
        else
        {
            throw new IllegalArgumentException("Please enter a valid last name only! A valid last name contains at least 2 characters.");
        }
    }

    /**
     * getter for position instance variable
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     * setter for position, sets it after validating it using a list of predefined positions in an ArrayList
     * @param position
     */
    public void setPosition(String position) {
        ArrayList<String> positions = new ArrayList<>(Arrays.asList("CF", "ST", "LW", "RW", "CM", "LM", "RM", "CB", "LB", "RB", "GK"));
        position = position.toUpperCase();
        if(positions.contains(position)) {
            this.position = position;
        }
        else
        {
            throw new IllegalArgumentException("Please enter a valid position from the list of available positions : " + positions);
        }
    }

    /**
     * Getter for attack
     * @return
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Setter for attack, sets it after performing validation for the limit of 0-100
     * @param attack
     */
    public void setAttack(int attack) {
        if (attack >= 0 && attack <= 100) {
            this.attack = attack;
        }
        else {
            throw new IllegalArgumentException("Please enter the attack value in the limit of 0-100");
        }
    }

    /**
     * Getter for defense
     * @return defense
     */
    public int getDefense() {
        return defense;
    }

    /**
     * setter for defense, sets it after validating it for the limit of 0-100
     * @param defense
     */
    public void setDefense(int defense) {
        if (defense >= 0 && defense <= 100) {
            this.defense = defense;
        }
        else {
            throw new IllegalArgumentException("Please enter the defense value in the limit of 0-100");
        }
    }

    /**
     * Getter for speed
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Setter for speed, sets it within the limit of 0-100
     * @param speed
     */
    public void setSpeed(int speed) {
        if (speed >= 0 && speed <= 100) {
            this.speed = speed;
        }
        else {
            throw new IllegalArgumentException("Please enter the speed value in the limit of 0-100");
        }
    }

    /**
     * Getter for the kit number
     * @return kitNumber
     */
    public int getKitNumber() {
        return kitNumber;
    }

    /**
     * Setter for kitNumber, sets it within the limit of 1-99
     * @param kitNumber
     */
    public void setKitNumber(int kitNumber) {
        if (kitNumber > 0 && kitNumber < 100) {

            this.kitNumber = kitNumber;
        }
        else {
            throw new IllegalArgumentException("Please enter a kit number between the range 1-99 only!");
        }
    }

    /**
     * Getter for image of the player
     * @return image
     */
    public Image getImage() {
        return image;
    }

    /**
     * Setter for image of the player
     * @param image
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Overriden toString method
     * @return Player object in String representation
     */
    @Override
    public String toString() {
        return String.format("%d \t %s %s",kitNumber,lastName, firstName);

    }
}
