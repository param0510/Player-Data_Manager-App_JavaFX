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
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SquadListViewController implements Initializable {

    @FXML
    private TableColumn<Player, Integer> kitNumberColumn;

    @FXML
    private TableColumn<Player, String> firstNameColumn;

    @FXML
    private TableColumn<Player, String> lastNameColumn;

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

    @FXML
    private Label totalPlayersLabel;

    @FXML
    private Label squadStrengthLabel;

    @FXML
    private Button strongestPlayerButton;

    @FXML
    private Button weakestPlayerButton;

    @FXML
    private VBox tableUpdateButtons;

    private int selectedIndex;
    private Squad squad;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        kitNumberColumn.setCellValueFactory(new PropertyValueFactory<Player, Integer>("kitNumber"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("lastName"));

        Player player1 = new Player("Jordan", "Pickford", "gk", 58, 90, 82, 1);
        Player player2 = new Player("Luke", "Shaw", "lb", 62, 92, 95, 3);
        Player player3 = new Player("Harry", "Maguire", "cb", 68, 86, 77, 6);
        Player player4 = new Player("James", "Maddison", "lm", 78, 86, 83, 7);
        Player player5 = new Player("Harry", "Kane", "st", 91, 56, 83, 9);
        Player player6 = new Player("Raheem", "Sterling", "lw", 88, 56, 81, 10);

        squad = new Squad("England F.C.");
        squad.addPlayer(player1);
        squad.addPlayer(player2);
        squad.addPlayer(player3);
        squad.addPlayer(player4);
        squad.addPlayer(player5);
        squad.addPlayer(player6);

        ObservableList<Player> players = FXCollections.observableArrayList(squad.getSquadList());


//        Both work
//        table.setItems(players);
        table.getItems().addAll(players);

        squadNameLabel.setText(squad.getSquadName());

        totalPlayersLabel.setText(Integer.toString(table.getItems().size()));
        squadStrengthLabel.setText(Integer.toString(squad.getSquadStrength()));

        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // Hiding the add player form, in the starting
        addPlayerGridPane.setVisible(false);

        // hide view player
        viewPlayerGridPane.setVisible(false);

        selectedIndex = -1;

//        Both of these work for listening an item selection in TableView!!

//        table.setOnMousePressed(new EventHandler<MouseEvent>() {
//            public void handle(MouseEvent event) {
//                int selectedIndex = -1;
//                selectedIndex = table.getSelectionModel().getSelectedIndex();
//                if (selectedIndex != -1)
//                {
                        // get selected player for viewing
//                      Player player = table.getSelectionModel().getSelectedItem();
//                      viewPlayer(player);
//                }
//            }
//        } );

        // Another way of listening selection of any TableView item
        table.getSelectionModel().selectedItemProperty().addListener((observable) -> {
            int selectedIndex = -1;
            selectedIndex = table.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1)
            {
                // get selected player for viewing
                Player player = table.getSelectionModel().getSelectedItem();
                viewPlayer(player);
            }
        });


    }

    // Add player function adds a player object to the table
    public void addPlayerButtonPress() {

        viewPlayerGridPane.setVisible(false);

        addPlayerGridPane.setVisible(true);

        tableUpdateButtons.setVisible(false);
        System.out.println("Pressed!!");

        selectedIndex = -1;

        clearAllTextFields();

    }

    //    This is the delete button function which deletes the items based on the selection(s)
    public void deletePlayerButtonPress() {

        viewPlayerGridPane.setVisible(false);

        ObservableList<Player> items = table.getSelectionModel().getSelectedItems();

        table.getItems().removeAll(items);

        updateInfo();
    }

    //    Edit player function edits the selected player
    @FXML
    void editPlayerButtonPress(ActionEvent event) {


        viewPlayerGridPane.setVisible(false);

        try {

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

                tableUpdateButtons.setVisible(false);
            }
        }
        catch (Exception ex)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid choice!");
            alert.setContentText("Please select a player first!");
            alert.showAndWait();
        }

    }

    // Save player button is pressed to save the player in the table
    @FXML
    void savePlayerButtonPress() {

        try {

            viewPlayerGridPane.setVisible(false);

            Player newChangedPlayer = new Player(firstNameTextField.getText(), lastNameTextField.getText(), positionTextField.getText(), Integer.parseInt(attackTextField.getText()), Integer.parseInt(defenseTextField.getText()), Integer.parseInt(speedTextField.getText()), Integer.parseInt(kitNumberTextField.getText()));

            if (selectedIndex != -1) {

                table.getItems().set(selectedIndex, newChangedPlayer);
            } else {
                table.getItems().add(newChangedPlayer);
            }

            // Hide the save changes button and the add player form again..
            addPlayerGridPane.setVisible(false);

            // unhide all the main action buttons
            tableUpdateButtons.setVisible(true);

            clearAllTextFields();

            updateInfo();

        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid input!");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }

    }

    // To cancel any changes to the table
    public void cancelButtonPress() {

        selectedIndex = -1;

        viewPlayerGridPane.setVisible(false);
//        clearing all the data entered
        clearAllTextFields();

        addPlayerGridPane.setVisible(false);

        tableUpdateButtons.setVisible(true);

    }

    // To update the squad information
    public void updateInfo() {
        squad.setSquadList(new ArrayList<>(table.getItems()));

        totalPlayersLabel.setText(Integer.toString(table.getItems().size()));
        squadStrengthLabel.setText(Integer.toString(squad.getSquadStrength()));
    }

    // To view the Strongest player in the squad
    public void viewStrongestPlayer() {
            squad.setSquadList(new ArrayList<>(table.getItems()));
            Player strongestPlayer = squad.getStrongestPlayer();
            if (strongestPlayer != null) {

                viewPlayer(strongestPlayer);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.setContentText("The player list is empty");
                alert.showAndWait();
            }
    }

    // To view the Weakest player in the squad
    public void viewWeakestPlayer() {

        squad.setSquadList(new ArrayList<>(table.getItems()));
        Player weakestPlayer = squad.getWeakestPlayer();
        if (weakestPlayer != null) {
            viewPlayer(weakestPlayer);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("The player list is empty");
            alert.showAndWait();
        }
    }


    // To view the player in the squad
    public void viewPlayer(Player player) {

            viewPlayerGridPane.setVisible(true);

            firstNameDisplay.setText(player.getFirstName());
            lastNameDisplay.setText(player.getLastName());
            positionDisplay.setText(player.getPosition());
            attackDisplay.setText(Integer.toString(player.getAttack()));
            defenseDisplay.setText(Integer.toString(player.getDefense()));
            speedDisplay.setText(Integer.toString(player.getSpeed()));
            kitNumberDisplay.setText(Integer.toString(player.getKitNumber()));

            String playerImageLocaton = player.getImageLocation();
            Image playerImage;
            try {
                playerImage = new Image(getClass().getResource(playerImageLocaton).toExternalForm());
            }
            catch (Exception e) {
                playerImage = new Image(getClass().getResource("img/noImage.jpg").toExternalForm());
            }

            playerImageDisplay.setImage(playerImage);
    }

    // To clear all the text fields  in the add player form
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
