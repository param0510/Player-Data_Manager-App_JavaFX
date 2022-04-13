package com.example.comp1008_assignment_2_javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

    @FXML
    private Button cancelButton;

    @FXML
    private Label squadNameLabel;

    @FXML
    private Label attackDisplay;

    @FXML
    private Label defenseDisplay;

    @FXML
    private Label firstNameDisplay;

    @FXML
    private Label kitNumberDisplay;

    @FXML
    private Label lastNameDisplay;

    @FXML
    private Label positionDisplay;

    @FXML
    private Label speedDisplay;

    @FXML
    private GridPane viewPlayerGridPane;

    @FXML
    private ImageView playerImageDisplay;

    private int selectedIndex;

//    I think this won't be required
//    private Player selectedPlayer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        table.getItems().


        kitNumber.setCellValueFactory(new PropertyValueFactory<Player, Integer>("kitNumber"));
        playerName.setCellValueFactory(new PropertyValueFactory<Player, String>("firstName"));

        Player player1 = new Player("mamoun", "Paul", "rw", 78, 89, 92, 3);
        Player player2 = new Player("karen", "hartman", "lw", 72, 82, 95, 5);
        Player player3 = new Player("ellora", "roy", "lw", 68, 56, 87, 7);

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

        squadNameLabel.setText(Integer.toString(table.getItems().size()));


        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        // Hiding the add player form, in the starting
        addPlayerGridPane.setVisible(false);

//        Hiding the save player changes button before the application launches
        savePlayerButton.setVisible(false);

        // hide the cancel button
        cancelButton.setVisible(false);

        // hide view player
        viewPlayerGridPane.setVisible(false);

        selectedIndex = -1;


//        Both of these work!!
//        table.setOnMousePressed(new EventHandler<MouseEvent>() {
//            public void handle(MouseEvent event) {
//                int selectedIndex = -1;
//                selectedIndex = table.getSelectionModel().getSelectedIndex();
//
//                if (selectedIndex != -1)
//                {
//                    Player viewPlayer = table.getSelectionModel().getSelectedItem();
//                    viewPlayerGridPane.setVisible(true);
//
//                    firstNameDisplay.setText(viewPlayer.getFirstName());
//                    lastNameDisplay.setText(viewPlayer.getLastName());
//                    positionDisplay.setText(viewPlayer.getPosition());
//                    attackDisplay.setText(Integer.toString(viewPlayer.getAttack()));
//                    defenseDisplay.setText(Integer.toString(viewPlayer.getDefense()));
//                    speedDisplay.setText(Integer.toString(viewPlayer.getSpeed()));
//                    kitNumberDisplay.setText(Integer.toString(viewPlayer.getKitNumber()));
//
////                Image is still left!!!
//                }
//
//            }
//        } );


//        try this as well

        table.getSelectionModel().selectedItemProperty().addListener((observable) -> {
            int selectedIndex = -1;
            selectedIndex = table.getSelectionModel().getSelectedIndex();

            if (selectedIndex != -1)
            {
                Player viewPlayer = table.getSelectionModel().getSelectedItem();
                viewPlayerGridPane.setVisible(true);

                firstNameDisplay.setText(viewPlayer.getFirstName());
                lastNameDisplay.setText(viewPlayer.getLastName());
                positionDisplay.setText(viewPlayer.getPosition());
                attackDisplay.setText(Integer.toString(viewPlayer.getAttack()));
                defenseDisplay.setText(Integer.toString(viewPlayer.getDefense()));
                speedDisplay.setText(Integer.toString(viewPlayer.getSpeed()));
                kitNumberDisplay.setText(Integer.toString(viewPlayer.getKitNumber()));

//                Image is still left!!!
                playerImageDisplay.setImage(viewPlayer.getImage());

            }



        });


    }

    public void addPlayerButtonPress() {

        viewPlayerGridPane.setVisible(false);


        addPlayerGridPane.setVisible(true);
        savePlayerButton.setVisible(true);
        cancelButton.setVisible(true);

        deletePlayerButton.setVisible(false);
        editPlayerButton.setVisible(false);
        addPlayerButton.setVisible(false);
        System.out.println("Pressed!!");

        selectedIndex = -1;

        // This also cool try this!!!
//        table.getSelectionModel().setCellSelectionEnabled(false);

        clearAllTextFields();

    }

    //    This is the delete button function which deletes the items based on the selection(s)
    public void deletePlayerButtonPress() {

        viewPlayerGridPane.setVisible(false);

//        int index = table.getSelectionModel().getSelectedIndex();
//        Object item = table.getSelectionModel().getSelectedItem();
        ObservableList<Player> items = table.getSelectionModel().getSelectedItems();

        table.getItems().removeAll(items);


//        This did not work!!
//        for (Player item : items) {
//
//            table.getItems().remove(item);
//        }

        // Update the squad size value being displayed
        squadNameLabel.setText(Integer.toString(table.getItems().size()));

    }

    //    Edit player function
    @FXML
    void editPlayerButtonPress(ActionEvent event) {


        viewPlayerGridPane.setVisible(false);
//        try this once
//        Player editPlayer = null;

        selectedIndex = table.getSelectionModel().getSelectedIndex();
        Player editPlayer = table.getItems().get(selectedIndex);

        if (editPlayer != null) {
            addPlayerGridPane.setVisible(true);
            firstNameTextField.setText(editPlayer.getFirstName());
            lastNameTextField.setText(editPlayer.getLastName());
            positionTextField.setText(editPlayer.getPosition());
            attackTextField.setText(Integer.toString(editPlayer.getAttack()));
            defenseTextField.setText(Integer.toString(editPlayer.getDefense()));
            speedTextField.setText(Integer.toString(editPlayer.getSpeed()));
            kitNumberTextField.setText(Integer.toString(editPlayer.getKitNumber()));

            // Unhide the save player changes button
            savePlayerButton.setVisible(true);
            cancelButton.setVisible(true);


            // hide all the other buttons
            editPlayerButton.setVisible(false);
            deletePlayerButton.setVisible(false);
            addPlayerButton.setVisible(false);

            // Disable selection of different player
//        table.setDisable(true);

            // Or you can do this
//            table.setVisible(false);

            table.setDisable(true);

//        Try finding a way to make this work!!!
//        table.setSelectionModel(null);
        }


    }

    @FXML
    void savePlayerButtonPress() {

//        table.getSelectionModel().select(-1);
        try {

            viewPlayerGridPane.setVisible(false);
            // Disable selection for table
            //        table.setDisable(false);


            // try this once...



            //        Player savePlayer = table.getSelectionModel().getSelectedItem();
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

            Player changedPlayer = new Player(firstNameTextField.getText(), lastNameTextField.getText(), positionTextField.getText(), Integer.parseInt(attackTextField.getText()), Integer.parseInt(defenseTextField.getText()), Integer.parseInt(speedTextField.getText()), Integer.parseInt(kitNumberTextField.getText()));

            if (selectedIndex != -1) {

                table.getItems().set(selectedIndex, changedPlayer);
            } else {
                table.getItems().add(changedPlayer);
            }

            //        Hide the save changes button and the add player form again..
            savePlayerButton.setVisible(false);
            cancelButton.setVisible(false);

            // unhide all the main action buttons
            editPlayerButton.setVisible(true);
            deletePlayerButton.setVisible(true);
            addPlayerButton.setVisible(true);


            addPlayerGridPane.setVisible(false);

            // or do this
            //        table.setVisible(true);

            table.setDisable(false);

            clearAllTextFields();

            // Update the squad size value being displayed
            squadNameLabel.setText(Integer.toString(table.getItems().size()));

        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid input!");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }

    }

    public void cancelButtonPress() {

        selectedIndex = -1;

        viewPlayerGridPane.setVisible(false);
//        clearing all the data entered
        clearAllTextFields();


//        table.setVisible(true);
        table.setDisable(false);

        addPlayerGridPane.setVisible(false);

        savePlayerButton.setVisible(false);
        cancelButton.setVisible(false);

        editPlayerButton.setVisible(true);
        deletePlayerButton.setVisible(true);
        addPlayerButton.setVisible(true);
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
