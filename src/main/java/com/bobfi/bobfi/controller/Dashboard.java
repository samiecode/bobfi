package com.bobfi.bobfi.controller;

import com.bobfi.bobfi.BobfiApp;
import com.bobfi.bobfi.db.DBConnector;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

public class Dashboard implements Initializable {

    @FXML
    private HBox hbox1;
    @FXML
    private HBox hbox2;
    @FXML
    private HBox hbox3;
    @FXML
    private HBox hbox4;
    @FXML
    private HBox hbox5;
    @FXML
    private HBox hbox6;
    @FXML
    private Label greeting;
    @FXML
    private Label user;
    @FXML
    private Label imageSymbol;
    @FXML
    private AnchorPane dashboard;
    @FXML
    private AnchorPane myTasks;
    @FXML
    private AnchorPane myProject;
    @FXML
    private AnchorPane myMessage;
    @FXML
    private AnchorPane myClient;
    @FXML
    private AnchorPane myTeam;
    @FXML
    private Button createProjectBtn;
    private AnchorPane presentPane;
    private AnchorPane previousPane;
    AtomicReference<HBox> notActive;
    //private DBConnector dbConnector = new DBConnector();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        notActive = new AtomicReference<>(hbox1);
        user.setText(BobfiApp.user.getUsername());
        imageSymbol.setText(String.valueOf(BobfiApp.user.getUsername().charAt(0)));

        String firstName = "";

        for (int i = 0; i < user.getText().length(); i++) {
            if (user.getText().charAt(i) == ' ' )
                break;
            else
                firstName += user.getText().charAt(i);
        }

        greeting.setText("Hi " + firstName );
        switchTab();
    }

    @FXML
    protected void onAction() throws IOException {
        setScene("fxml/welcome.fxml");
    }

    public void switchTab(){
        presentPane = dashboard;
        previousPane = dashboard;
        dashboard.setVisible(false);
        previousPane.setVisible(true);
        presentPane.setVisible(true);

        hbox1.setOnMouseClicked(e-> switchPane(dashboard, hbox1));
        hbox2.setOnMouseClicked(e-> switchPane(myTasks, hbox2));
        hbox3.setOnMouseClicked(e-> switchPane(myProject, hbox3));
        hbox4.setOnMouseClicked(e-> switchPane(myMessage, hbox4));
        hbox5.setOnMouseClicked(e-> switchPane(myClient, hbox5));
        hbox6.setOnMouseClicked(e-> switchPane(myTeam, hbox6));
    }

    private void switchPane(AnchorPane anchorPane, HBox tab ){
        previousPane.setVisible(false);
        previousPane = anchorPane;
        presentPane = anchorPane;
        presentPane.setVisible(true);

        notActive.get().getStyleClass().remove(1);
        notActive.set(tab);
        tab.getStyleClass().add("active");
    }
    private void setScene(String fxml) throws IOException {
        BobfiApp.fxmlLoader = new FXMLLoader(BobfiApp.class.getResource(fxml));
        BobfiApp.scene = new Scene(BobfiApp.fxmlLoader.load());
        BobfiApp.primaryStage.setScene(BobfiApp.scene);
        BobfiApp.scene.getWindow().centerOnScreen();
        BobfiApp.primaryStage.setResizable(false);
        //BobfiApp.primaryStage.setMaximized(true);
    }

}
