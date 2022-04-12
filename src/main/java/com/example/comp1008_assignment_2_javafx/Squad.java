package com.example.comp1008_assignment_2_javafx;

import java.util.ArrayList;

public class Squad {
    private String squadName;
    private ArrayList<Player> squad;

    public Squad(String squadName) {
        setSquadName(squadName);
        this.squad = new ArrayList<>();
    }

    public String getSquadName() {
        return squadName;
    }

//    Validation remaining
    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public ArrayList<Player> getSquad() {
        return squad;
    }

    public void setSquad(ArrayList<Player> squad) {
        this.squad = squad;
    }

    public void addPlayer(Player player) {
        squad.add(player);
    }

    public Player getPlayer(int index) {
        return (squad.get(index));
    }

    public void deletePlayer(int index) {
        squad.remove(index);
    }

    public void editPlayer(int index) {
//        Dont knw, whether this one's required
    }

    public int getNumOfPlayers() {
        return squad.size();
    }

    public int getSquadStrength() {
        int totalNumOfPlayers = squad.size();
        int attributeAverage = 0;
        for (Player player : squad) {
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
