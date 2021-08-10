/*
 * ===================================================================
 * Copyright © 2018 - All Rights Reserved
 * 
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * 
 * Proprietary and Solely
 * Written by Vivek Rohom <rohomv1@udayton.edu>
 * ===================================================================
 */
package AI_TicTacToe;

import AI_TicTacToe.MiniMax.Move;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import static AI_TicTacToe.MiniMax.findOptimalMove;

public class FXMLDocumentController implements Initializable {

    private String[][] result = new String[3][3];
    private Boolean computerPlayer;
    private String player;
    private int checkWinCounter;
    private int xWins;
    private int oWins;
    private int draws;
    private boolean resultCheck;
    private String PlayerWon;
    private boolean flag;

    @FXML
    private Group wholeBoard;
    @FXML
    private Label lblresult;
    @FXML
    private Label lblTitle;
    @FXML
    private TextField txtXWins;
    @FXML
    private TextField txtOWins;
    @FXML
    private TextField txtDraws;
    @FXML
    private CheckBox chkbxOpponent;
    @FXML
    private Button btnPos00;
    @FXML
    private Button btnPos01;
    @FXML
    private Button btnPos02;
    @FXML
    private Button btnPos10;
    @FXML
    private Button btnPos11;
    @FXML
    private Button btnPos12;
    @FXML
    private Button btnPos20;
    @FXML
    private Button btnPos21;
    @FXML
    private Button btnPos22;

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getCheckWinCounter() {
        return checkWinCounter;
    }

    public void setCheckWinCounter(int checkWinCounter) {
        this.checkWinCounter = checkWinCounter;
    }

    public int getxWins() {
        return xWins;
    }

    public void setxWins(int xWins) {
        this.xWins = xWins;
    }

    public int getoWins() {
        return oWins;
    }

    public void setoWins(int oWins) {
        this.oWins = oWins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public boolean isResultCheck() {
        return resultCheck;
    }

    public void setResultCheck(boolean resultCheck) {
        this.resultCheck = resultCheck;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Boolean getComputerPlayer() {
        return computerPlayer;
    }

    public void setComputerPlayer(Boolean computerPlayer) {
        this.computerPlayer = computerPlayer;
    }

    public String getPlayerWon() {
        return PlayerWon;
    }

    public void setPlayerWon(String PlayerWon) {
        this.PlayerWon = PlayerWon;
    }

    public FXMLDocumentController() {
        this.xWins = 0;
        this.oWins = 0;
        this.draws = 0;
        this.PlayerWon = "";
        this.computerPlayer = false;
        this.checkWinCounter = 0;
        this.player = "X";
        this.flag = true;
        this.resultCheck = true;
    }

    @FXML
    private void handleButtonQuitAction(ActionEvent event
    ) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quit");
        alert.setHeaderText("Are you sure you want to quit the game?");
        if (alert.showAndWait().filter(t -> t == ButtonType.OK).isPresent()) {
            Platform.exit();
        }
    }

    @FXML
    private void handleButtonResetAction(ActionEvent event
    ) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Reset");
        alert.setHeaderText("Are you sure you want to reset the game?");
        if (alert.showAndWait().filter(t -> t == ButtonType.OK).isPresent()) {
            resetBoard();
            setxWins(0);
            setoWins(0);
            setDraws(0);
            txtDraws.setText("Draws : ");
            txtOWins.setText("O wins : ");
            txtXWins.setText("X wins : ");
        }
    }

    @FXML
    public void handleButtonResetBoardAction() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Reset");
        alert.setHeaderText("Are you sure you want to reset the board ?");
        if (alert.showAndWait().filter(t -> t == ButtonType.OK).isPresent()) {
            resetBoard();
        }
    }

    @FXML
    private void chkbxOpponentAction(ActionEvent event) {
        setComputerPlayer(chkbxOpponent.isSelected());
    }

    @FXML
    private void pos00ButtonAction(ActionEvent Event
    ) {
        result[0][0] = player;
        btnPos00.setText(player);
        if (player.equals("X")) {
            btnPos00.setStyle("-fx-text-fill: red");
        } else {
            btnPos00.setStyle("-fx-text-fill: blue");
        }
        btnPos00.setDisable(true);
        checkWinCounter();
        nextPlayer();
    }

    @FXML
    private void pos01ButtonAction(ActionEvent event
    ) {
        result[0][1] = player;
        btnPos01.setText(player);
        if (player.equals("X")) {
            btnPos01.setStyle("-fx-text-fill: red");
        } else {
            btnPos01.setStyle("-fx-text-fill: blue");
        }
        btnPos01.setDisable(true);
        checkWinCounter();
        nextPlayer();
    }

    @FXML
    private void pos02ButtonAction(ActionEvent event
    ) {
        result[0][2] = player;
        btnPos02.setText(player);
        if (player.equals("X")) {
            btnPos02.setStyle("-fx-text-fill: red");
        } else {
            btnPos02.setStyle("-fx-text-fill: blue");
        }
        btnPos02.setDisable(true);
        checkWinCounter();
        nextPlayer();
    }

    @FXML
    private void pos10ButtonAction(ActionEvent event
    ) {
        result[1][0] = player;
        btnPos10.setText(player);
        if (player.equals("X")) {
            btnPos10.setStyle("-fx-text-fill: red");
        } else {
            btnPos10.setStyle("-fx-text-fill: blue");
        }
        btnPos10.setDisable(true);
        checkWinCounter();
        nextPlayer();
    }

    @FXML
    private void pos11ButtonAction(ActionEvent event
    ) {
        result[1][1] = player;
        btnPos11.setText(player);
        if (player.equals("X")) {
            btnPos11.setStyle("-fx-text-fill: red");
        } else {
            btnPos11.setStyle("-fx-text-fill: blue");
        }
        btnPos11.setDisable(true);
        checkWinCounter();
        nextPlayer();
    }

    @FXML
    private void pos12ButtonAction(ActionEvent event
    ) {
        result[1][2] = player;
        btnPos12.setText(player);
        if (player.equals("X")) {
            btnPos12.setStyle("-fx-text-fill: red");
        } else {
            btnPos12.setStyle("-fx-text-fill: blue");
        }
        btnPos12.setDisable(true);
        checkWinCounter();
        nextPlayer();
    }

    @FXML
    private void pos20ButtonAction(ActionEvent event
    ) {
        result[2][0] = player;
        btnPos20.setText(player);
        if (player.equals("X")) {
            btnPos20.setStyle("-fx-text-fill: red");
        } else {
            btnPos20.setStyle("-fx-text-fill: blue");
        }
        btnPos20.setDisable(true);
        checkWinCounter();
        nextPlayer();
    }

    @FXML
    private void pos21ButtonAction(ActionEvent event
    ) {
        result[2][1] = player;
        btnPos21.setText(player);
        if (player.equals("X")) {
            btnPos21.setStyle("-fx-text-fill: red");
        } else {
            btnPos21.setStyle("-fx-text-fill: blue");
        }
        btnPos21.setDisable(true);
        checkWinCounter();
        nextPlayer();
    }

    @FXML
    private void pos22ButtonAction(ActionEvent event
    ) {
        result[2][2] = player;
        btnPos22.setText(player);
        if (player.equals("X")) {
            btnPos22.setStyle("-fx-text-fill: red");
        } else {
            btnPos22.setStyle("-fx-text-fill: blue");
        }
        btnPos22.setDisable(true);
        checkWinCounter();
        nextPlayer();
    }

    private void printBoard(String[][] board) {
        System.out.println("\nCurrent Board is: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
    }

    private void resetBoard() {
        for (String[] array : result) {
            Arrays.fill(array, "   ");
        }
        setFlag(true);
        setCheckWinCounter(0);
        setPlayer("X");
        setResultCheck(true);
        setPlayerWon("");
        setComputerPlayer(false);
        chkbxOpponent.setSelected(false);
        wholeBoard.setDisable(false);
        btnPos00.setDisable(false);
        btnPos01.setDisable(false);
        btnPos02.setDisable(false);
        btnPos10.setDisable(false);
        btnPos11.setDisable(false);
        btnPos12.setDisable(false);
        btnPos20.setDisable(false);
        btnPos21.setDisable(false);
        btnPos22.setDisable(false);
        btnPos00.setText(" ");
        btnPos01.setText(" ");
        btnPos02.setText(" ");
        btnPos10.setText(" ");
        btnPos11.setText(" ");
        btnPos12.setText(" ");
        btnPos20.setText(" ");
        btnPos21.setText(" ");
        btnPos22.setText(" ");
    }

    private void nextPlayer() {
        lblTitle.requestFocus();
        printBoard(result);
        if (getCheckWinCounter() == 0) {
            return;
        }

        if (getPlayer().equals("X")) {
            setPlayer("O");
            if (getComputerPlayer()) {
                computerPlay();
            }
        } else if (getPlayer().equals("O")) {
            setPlayer("X");
            setFlag(true);
        }
    }

    private void computerPlay() {
        if (isFlag()) {
            setFlag(false);
            Move nextMove = findOptimalMove(result);

            if (nextMove.row != -1) {
                try {
                    Button btn = (Button) FXMLDocumentController.class.getDeclaredField("btnPos" + nextMove.row + nextMove.col).get(this);
                    btn.fire();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void checkWinCounter() {
        checkWinCounter++;
        if (getCheckWinCounter() > 4 && isResultCheck()) {
            checkWin();
        }
        if (getCheckWinCounter() == 9 && isResultCheck()) {
            draws++;
            txtDraws.setText("Draws : " + String.valueOf(draws));
            showResult();
        }
    }

    private void checkWin() {
        if (checkColumns() || checkRows() || checkDiagonal()) {
            if (getPlayerWon().equals("X")) {
                xWins++;
                txtXWins.setText("X wins : " + String.valueOf(xWins));
                setResultCheck(false);
                System.out.println("Player " + getPlayerWon() + " won the game!!");
                showResult();
            } else if (getPlayerWon().equals("O")) {
                oWins++;
                txtOWins.setText("O wins : " + String.valueOf(oWins));
                setResultCheck(false);
                System.out.println("Player " + getPlayerWon() + " won the game!!");
                showResult();
            } else {
                setResultCheck(true);
            }
        }
    }

    private void showResult() {
        if (getPlayerWon().equals("X") || getPlayerWon().equals("O")) {
            lblresult.setText("Congratulations\nPlayer " + getPlayerWon() + " won the game !!!");
        } else {
            lblresult.setText("Opps!!  It's a draw !!!");
            setPlayerWon("Draw");
        }
        PauseTransition delay = new PauseTransition(Duration.seconds(5));
        delay.setOnFinished(event -> lblresult.setText(""));
        delay.play();
        lblresult.focusedProperty();
        wholeBoard.setDisable(true);
    }

    private boolean checkDiagonal() {
        if (result[0][0].equals(result[1][1]) && result[1][1].equals(result[2][2])) {
            setPlayerWon(result[1][1]);
            return true;
        } else if (result[0][2].equals(result[1][1]) && result[1][1].equals(result[2][0])) {
            setPlayerWon(result[1][1]);
            return true;
        }
        return false;
    }

    private boolean checkRows() {
        for (int itr1 = 0; itr1 < 3; itr1++) {
            if (result[itr1][0].equals(result[itr1][1]) && result[itr1][1].equals(result[itr1][2])) {
                if (!result[itr1][1].equals("   ")) {
                    setPlayerWon(result[itr1][1]);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int itr1 = 0; itr1 < 3; itr1++) {
            if (result[0][itr1].equals(result[1][itr1]) && result[1][itr1].equals(result[2][itr1])) {
                if (!result[1][itr1].equals("   ")) {
                    setPlayerWon(result[1][itr1]);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (String[] array : result) {
            Arrays.fill(array, "   ");
        }
        lblTitle.requestFocus();
        txtDraws.setEditable(false);
        txtXWins.setEditable(false);
        txtOWins.setEditable(false);
    }
}
