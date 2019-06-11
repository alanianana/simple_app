package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.service.AutServ;

import java.sql.*;

public class Controller {
    public Button btn_log;
    public TextField login;
    public PasswordField password;

    public  void click_log (ActionEvent actionEvent) throws SQLException {
        System.out.println("მომხმაებილის სახელი" + login.getText());
        System.out.println("პაროლი" + password.getText());


        try{
            if (AutServ.Authorisation(login.getText(),password.getText())) {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../register.fxml"));
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1, 400, 400));
                stage.setTitle("Student Registration Form");
                stage.setResizable(false);
                stage.show();
                ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
            }else {
                System.out.println("araswori paroli an logini");
            }
        }catch (Exception E){
            System.out.println(E);

        }
    }



}
