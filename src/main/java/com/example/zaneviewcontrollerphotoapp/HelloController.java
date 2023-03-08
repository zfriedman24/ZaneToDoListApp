package com.example.zaneviewcontrollerphotoapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class HelloController {
    @FXML
    public Label ToDoList;
    public Button ViewText1;
    public Button ViewText2;
    public TextField textField;
    public ListView ThingsToDo;
    @FXML
    public void addTaskToList() {
        ThingsToDo.getItems().add(textField.getText());
    }
    ArrayList<String> allTasksArrayList;


    public void RemoveTaskFromList() {
        Object selectedTask = ThingsToDo.getSelectionModel().getSelectedItems().get(0);
        System.out.println(selectedTask);
        ThingsToDo.getItems().remove(selectedTask);
    }
    public void saveData() throws Exception {
        FileOutputStream fileOut = new FileOutputStream("SavedToDoList");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        ArrayList<String> temporaryList = new ArrayList<>(ThingsToDo.getItems());
        out.writeObject(temporaryList);
        out.close();
        fileOut.close();
    }

    public void restoreData() throws Exception {
        FileInputStream fileIn = new FileInputStream("SavedToDoList");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        allTasksArrayList = (ArrayList<String>) in.readObject();
        for (String eachTask: allTasksArrayList) {
            ThingsToDo.getItems().add(eachTask);
        }
        in.close();
        fileIn.close();
    }
}