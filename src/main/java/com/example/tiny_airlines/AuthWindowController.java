package com.example.tiny_airlines;

import com.example.tiny_airlines.database.DBHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class AuthWindowController {

    @FXML
    private Button authBtn;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField loginTF;

    @FXML
    private PasswordField passPF;

    private DBHandler handler = new DBHandler();

    @FXML
    void initialize(){
        authBtn.setOnAction(Event ->{

            String login = loginTF.getText().trim();
            String password = passPF.getText().trim();

            if (!login.equals("") && !password.equals("")){
                try {
                    if (handler.authorize(login, password)) {
                        authBtn.getScene().getWindow().hide();
                        setScene("MainWindow");
                    } else errorLabel.setText("Такого пользователя нет в базе данных");
                } catch (SQLException | ClassNotFoundException e) {
                    errorLabel.setText("Ошибка базы данных...");
                    throw new RuntimeException(e);
                }
            } else {
                errorLabel.setText("Вы не ввели все необходимые данные");
            }
        });
    }

        public static void setScene(String window){

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AuthWindowController.class.getResource(window + ".fxml"));

        try {
            loader.load();
        } catch (IOException exception) {
            System.out.println("Ошибка loader!");
            exception.printStackTrace();
        }

        Parent Root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(Root));
        stage.setTitle("TinyAirlines");
        stage.show();
    }
}
