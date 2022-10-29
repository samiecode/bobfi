package com.bobfi.bobfi;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class BobfiApp extends Application {

    public static Stage primaryStage = null;
    public static FXMLLoader fxmlLoader;
    public static Scene scene;
    public static User user;

    @Override
    public void start(Stage stage) throws IOException {
        BobfiApp.primaryStage = stage;
        fxmlLoader = new FXMLLoader(BobfiApp.class.getResource("fxml/welcome.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.getIcons().add(new Image(BobfiApp.class.getResourceAsStream("images/bobfi-icon/bobfilogo.png")));
        stage.setResizable(false);
        stage.show();
        scene.getWindow().centerOnScreen();
    }
//
    public static void main(String[] args) {
        launch(args);
    }

}