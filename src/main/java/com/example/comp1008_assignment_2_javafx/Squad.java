package com.example.comp1008_assignment_2_javafx;

import java.util.ArrayList;

public class Squad {
    private String squadName;
    private ArrayList<Player> squadList;

    public Squad(String squadName) {
        setSquadName(squadName);
        this.squadList = new ArrayList<>();
    }

    public String getSquadName() {
        return squadName;
    }

//    Validation remaining
    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public ArrayList<Player> getSquadList() {
        return squadList;
    }

    public void setSquadList(ArrayList<Player> squad) {
        this.squadList = squad;
    }

    public void addPlayer(Player player) {
       squadList.add(player);
    }

    public Player getPlayer(int index) {
        return (squadList.get(index));
    }

    public void deletePlayer(int index) {
        squadList.remove(index);
    }

    public void editPlayer(int index) {
//        Dont knw, whether this one's required
    }

    public int getNumOfPlayers() {
        return squadList.size();
    }

    public int getSquadStrength() {
        int totalNumOfPlayers = squadList.size();
        int attributeAverage = 0;
        for (Player player : squadList) {
            attributeAverage = attributeAverage + (player.getAttack()+player.getDefense()+player.getSpeed())/3;
        }
        return (attributeAverage/totalNumOfPlayers);
    }

    public Player getStrongestPlayer() {
        // lets do this later
        return null;
    }

    public Player getWeakestPlayer() {
        // lets do this later
        return null;
    }
}
