package com.example.comp1008_assignment_2_javafx;

import java.util.ArrayList;

public class Squad {
    private String squadName;
    private ArrayList<Player> squadList;

    /**
     * This is squad Class constructor which initializes the squadList and sets the squadName
     * @param squadName - holds the name of the team/squad
     */
    public Squad(String squadName) {
        setSquadName(squadName);
        this.squadList = new ArrayList<>();
    }

    /**
     * getter for squadName
     * @return  squadName
     */
    public String getSquadName() {
        return squadName;
    }

    /**
     * setter for squadName, this sets the squadName after carrying out necessary validation
     * @param squadName - name of the squad passed in
     */
    public void setSquadName(String squadName)
    {
        squadName = squadName.trim();
        if (squadName.length() >= 2)
        {
            this.squadName = squadName;
        }
        else
        {
            throw new IllegalArgumentException("Please enter a valid squad name only! A valid squad name contains at least 2 characters.");
        }
    }

    /**
     * getter for the ArrayList instance variable squadList which holds a list of player objects
     * @return
     */
    public ArrayList<Player> getSquadList() {
        return squadList;
    }

    /**
     * setter for squadList, this sets the squadList instance variable using the ArrayList of Player objects recieved
     * @param squadList - ArrayList of Player objects passed in
     */
    public void setSquadList(ArrayList<Player> squadList) {
        this.squadList = squadList;
    }

    /**
     * this is used to add the Player object to the SquadList instance variable
     * @param player - Player object recieved
     */
    public void addPlayer(Player player) {
       squadList.add(player);
    }

    /**
     * This function calculates the average strength of the team according to the attributes (attack, defense, speed) of each player
     * @return - int
     */
    public int getSquadStrength() {
        int totalNumOfPlayers = squadList.size();
        if (totalNumOfPlayers != 0) {
            int attributeAverage = 0;
            for (Player player : squadList) {
                attributeAverage = attributeAverage + (player.getAttack()+player.getDefense()+player.getSpeed())/3;
            }
            return (attributeAverage/totalNumOfPlayers);
        }
        else {
            return 0;
        }
    }

    /**
     * This returns the Player object having the highest attribute average of attack, defense and speed
     * @return Player
     */
    public Player getStrongestPlayer() {
        Player strongestPlayer = null;
        int avgAttributeMax = 0;
        for (Player player : squadList) {
            int avgAttribute = (player.getAttack()+player.getDefense()+player.getSpeed())/3;
            if (avgAttribute > avgAttributeMax) {
                strongestPlayer = player;
                avgAttributeMax = avgAttribute;
            }
        }
        return strongestPlayer;
    }

    /**
     * This returns the Player object having the lowest attribute average of attack, defense and speed
     * @return Player
     */
    public Player getWeakestPlayer() {
        Player weakestPlayer = null;
        int avgAttributeMin = 100;
        for (Player player : squadList) {
            int avgAttribute = (player.getAttack()+player.getDefense()+player.getSpeed())/3;
            if (avgAttribute < avgAttributeMin) {
                weakestPlayer = player;
                avgAttributeMin = avgAttribute;
            }
        }
        return weakestPlayer;
    }
}
