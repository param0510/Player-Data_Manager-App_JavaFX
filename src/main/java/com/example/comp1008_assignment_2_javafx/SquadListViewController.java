package com.example.comp1008_assignment_2_javafx;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class SquadListViewController implements Initializable {

    @FXML
    private TableColumn<Player, Integer> kitNumber;

    @FXML
    private TableColumn<Player, String> playerName;

    @FXML
    private TableView<Player> table;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        table.getItems().
        kitNumber.setCellValueFactory(new PropertyValueFactory<Player, Integer>("kitNumber"));
        playerName.setCellValueFactory(new PropertyValueFactory<Player, String>("firstName"));

        Player player1 = new Player("param", "singh", "rw",78,89,92,3,null);
        Player player2 = new Player("karan", "singh", "lw",72,82,95,5,null);

        ObservableList<Player> players = FXCollections.observableArrayList();

        players.add(player1);
        players.add(player2);

        table.setItems(players);
    }

}
