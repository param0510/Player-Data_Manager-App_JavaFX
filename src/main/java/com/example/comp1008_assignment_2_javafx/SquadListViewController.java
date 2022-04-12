package com.example.comp1008_assignment_2_javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class SquadListViewController implements Initializable {

    @FXML
    private TableColumn<Player, Integer> kitNumber;

    @FXML
    private TableColumn<Player, String> playerName;

    @FXML
    private TableView<Player> table;

    @FXML
    private Button addPlayerButton;

    @FXML
    private TextField attackTextField;

    @FXML
    private TextField defenseTextField;

    @FXML
    private TextField firstNameTextField;


    @FXML
    private TextField kitNumberTextField;

    @FXML
    private TextField lastNameTextField;


    @FXML
    private TextField positionTextField;

    @FXML
    private TextField speedTextField;

    @FXML
    private Button deletePlayerButton;

    @FXML
    private GridPane addPlayerGridPane;

    @FXML
    private Button editPlayerButton;

    @FXML
    private Button savePlayerButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        table.getItems().
        kitNumber.setCellValueFactory(new PropertyValueFactory<Player, Integer>("kitNumber"));
        playerName.setCellValueFactory(new PropertyValueFactory<Player, String>("firstName"));

        Player player1 = new Player("param", "singh", "rw",78,89,92,3,null);
        Player player2 = new Player("karan", "singh", "lw",72,82,95,5,null);
        Player player3 = new Player("kiran", "roy", "lw",68,56,87,7,null);

        Squad squad = new Squad("Barca");
        squad.addPlayer(player1);
        squad.addPlayer(player2);
        squad.addPlayer(player3);

        ObservableList<Player> players = FXCollections.observableArrayList(squad.getSquadList());

//        players.addAll(squad.getSquadList());
//        players.add(player2);

//        Both work
//        table.setItems(players);
        table.getItems().addAll(players);

        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        // Hiding the add player form, in the starting
        addPlayerGridPane.setVisible(false);

//        Hiding the save player changes button before the application launches
        savePlayerButton.setVisible(false);

    }

    public void addPlayerButtonPress() {



        if (addPlayerGridPane.isVisible()) {

        // Prevent it from throwing exceptions, instead it should display a message in the message box

        Player newPlayer = new Player(firstNameTextField.getText(), lastNameTextField.getText(), positionTextField.getText(), Integer.parseInt(attackTextField.getText()), Integer.parseInt(defenseTextField.getText()), Integer.parseInt(speedTextField.getText()), Integer.parseInt(kitNumberTextField.getText()), null);


        table.getItems().add(newPlayer);
        }
        addPlayerGridPane.setVisible(true);
        System.out.println("Pressed!!");

        clearAllTextFields();

    }

//    This is the delete button function which deletes the items based on the selection(s)
    public void deletePlayerButtonPress() {

//        int index = table.getSelectionModel().getSelectedIndex();
//        Object item = table.getSelectionModel().getSelectedItem();
        ObservableList<Player> items = table.getSelectionModel().getSelectedItems();

        table.getItems().removeAll(items);


//        This did not work!!
//        for (Player item : items) {
//
//            table.getItems().remove(item);
//        }

    }

    //    Edit player function
    @FXML
    void editPlayerButtonPress(ActionEvent event) {
        addPlayerGridPane.setVisible(true);
        Player editPlayer = table.getSelectionModel().getSelectedItem();


        firstNameTextField.setText(editPlayer.getFirstName());
        lastNameTextField.setText(editPlayer.getLastName());
        positionTextField.setText(editPlayer.getPosition());
        attackTextField.setText(Integer.toString(editPlayer.getAttack()));
        defenseTextField.setText(Integer.toString(editPlayer.getDefense()));
        speedTextField.setText(Integer.toString(editPlayer.getSpeed()));
        kitNumberTextField.setText(Integer.toString(editPlayer.getKitNumber()));

        // Unhide the save player changes button
        savePlayerButton.setVisible(true);

        // Disable selection of different player
//        table.setDisable(true);

        // Or you can do this
        table.setVisible(false);

//        Try finding a way to make this work!!!
//        table.setSelectionModel(null);




//      Disable selection change in the table
//        table.setSelectionModel(Sel);

    }

    @FXML
    void savePlayerButtonPress() {

        // Disable selection for table
//        table.setDisable(false);

        // or do this
        table.setVisible(true);

        int selectedIndex = table.getSelectionModel().getSelectedIndex();
        Player savePlayer = table.getSelectionModel().getSelectedItem();
//        Object savePlayer = table.getSelectionModel().getSelectedItem();

//        This does not work
//        savePlayer.setFirstName(firstNameTextField.getText());
//        savePlayer.setLastName(lastNameTextField.getText());
//        savePlayer.setPosition(positionTextField.getText());
//        savePlayer.setAttack(Integer.parseInt(attackTextField.getText()));
//        savePlayer.setDefense(Integer.parseInt(defenseTextField.getText()));
//        savePlayer.setSpeed(Integer.parseInt(speedTextField.getText()));
//        savePlayer.setKitNumber(Integer.parseInt(kitNumberTextField.getText()));
//        Image still remains......

        Player changedPlayer = new Player(firstNameTextField.getText(), lastNameTextField.getText(), positionTextField.getText(), Integer.parseInt(attackTextField.getText()), Integer.parseInt(defenseTextField.getText()), Integer.parseInt(speedTextField.getText()), Integer.parseInt(kitNumberTextField.getText()), null);

        table.getItems().set(selectedIndex, changedPlayer);

//        Hide the save changes button and the add player form again..
        savePlayerButton.setVisible(false);
        addPlayerGridPane.setVisible(false);

        clearAllTextFields();

    }

    public void clearAllTextFields() {
        firstNameTextField.clear();
        lastNameTextField.clear();
        positionTextField.clear();
        attackTextField.clear();
        defenseTextField.clear();
        speedTextField.clear();
        kitNumberTextField.clear();
    }


}
