package com.example.myfirstgame;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    char x = 'x';
    private char[][] gameMap = new char[3][3];
    private boolean isGame = true;
    @FXML
    void buttonClick(ActionEvent event) throws IOException {
        if(!isGame){
            return;
        }
        Button button = (Button) event.getSource();

        int rowIndex = GridPane.getRowIndex(button) == null ? 0 : GridPane.getRowIndex(button);
        int columnIndex = GridPane.getColumnIndex(button) == null ? 0 : GridPane.getColumnIndex(button);

        gameMap[rowIndex][columnIndex] = x;

        button.setText(String.valueOf(x));

        if(gameMap[0][0] == gameMap[0][1] && gameMap[0][0] == gameMap[0][2] && (gameMap[0][0] == 'x' || gameMap[0][0] == 'o')){
            showWinner(button);
            newGame(button);
            isGame = false;
        }
        if(gameMap[0][0] == gameMap[1][0] && gameMap[0][0] == gameMap[2][0] && (gameMap[0][0] == 'x' || gameMap[0][0] == 'o')){
            showWinner(button);
            newGame(button);
            isGame = false;
        }
        if(gameMap[0][2] == gameMap[1][2] && gameMap[0][2] == gameMap[2][2] && (gameMap[0][2] == 'x' || gameMap[0][2] == 'o')){
            showWinner(button);
            newGame(button);
            isGame = false;
        }
        if(gameMap[2][0] == gameMap[2][1] && gameMap[2][0] == gameMap[2][2] && (gameMap[2][0] == 'x' || gameMap[2][0] == 'o')){
            showWinner(button);
            newGame(button);
            isGame = false;
        }
        if(gameMap[0][0] == gameMap[1][1] && gameMap[0][0] == gameMap[2][2] && (gameMap[0][0] == 'x' || gameMap[0][0] == 'o')){
            showWinner(button);
            newGame(button);
            isGame = false;
        }
        if(gameMap[0][2] == gameMap[1][1] && gameMap[0][2] == gameMap[2][0] && (gameMap[0][2] == 'x' || gameMap[0][2] == 'o')){
            showWinner(button);
            newGame(button);
            isGame = false;
        }
        if(gameMap[1][0] == gameMap[1][1] && gameMap[1][0] == gameMap[1][2] && (gameMap[1][0] == 'x' || gameMap[1][0] == 'o')){
            showWinner(button);
            newGame(button);
            isGame = false;
        }
        if(gameMap[0][1] == gameMap[1][1] && gameMap[0][1] == gameMap[2][1] && (gameMap[0][1] == 'x' || gameMap[0][1] == 'o')){
            showWinner(button);
            newGame(button);
            isGame = false;
        }


       button.setText(String.valueOf(x));
        x = x == 'x'? 'o' : 'x';
    }
    @FXML
    void initialize() {

    }
    public void newGame(Button button) throws IOException {
        button.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MyFirstGame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 480);
        Stage stage = new Stage();
        stage.setTitle("tic tac toe");
        stage.setScene(scene);
        stage.show();
    }
    public void showWinner(Button button){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Winner is << " + button.getText() + " >>", ButtonType.OK);
        alert.showAndWait();
    }
}
