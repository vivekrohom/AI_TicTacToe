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

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Vivek
 */
public class AI_TicTacToe extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
