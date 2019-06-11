package sample.controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import sample.service.BookServ;


import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;



public class Register implements Initializable {
    public Button btn_add;
    public TextField bk_name;
    public TextField aut_name;
    public TextField aut_surname;
    public ComboBox genre;
    public DatePicker year;

    public  void click_add(ActionEvent actionEvent) {

        try {
            if (BookServ.addBook(bk_name.getText(), aut_name.getText(), aut_surname.getText(), genre.getSelectionModel().getSelectedItem().toString(), Date.valueOf(year.getValue()))){
                System.out.println("მონაცემები წარმატებით დაემატა");
                System.out.println(bk_name.getText());
                System.out.println(aut_name.getText());
                System.out.println( aut_surname.getText());
                System.out.println(  genre.getSelectionModel().getSelectedItem().toString());
                System.out.println(  Date.valueOf(year.getValue()));
            }else{
                System.out.println("შეცდომა");
            }

        }catch(Exception E){
                System.out.println(E);

            }
    }

            @Override
            public void initialize (URL location, ResourceBundle resources){
                ObservableList<String> genree = FXCollections.observableArrayList(" - ", "სათავგადასავლო", "ფენტეზი", "დეტექტივი", "შემეცნებითი", "მედიცინა");
                genre.setItems(genree);

        }

    }

