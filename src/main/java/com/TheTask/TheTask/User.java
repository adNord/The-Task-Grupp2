package com.TheTask.TheTask;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    String userName;
    UUID id;
    List<TodoList> userOwnedLists = new ArrayList<>();

    public User(String userName){
        this.userName = userName;
        this.id = UUID.randomUUID();
    }

    public void addList(TodoList todoList){
        userOwnedLists.add(todoList);
        return;
    }

    public String getUserName() {
        return userName;
    }
    
    public UUID getId() {
        return id;
    }

    public List<TodoList> getUserOwnedLists(){
        return userOwnedLists;
    }

    //Metod för att hitta en lista baserat på titel 
    public TodoList getListByTitle(String title) { 
        for (TodoList list : userOwnedLists) {
            if (list.getTitle().equals(title)){ // jämför titeln på TodoList med den sträng vi lefar efter
                return list; // retunerar Rätt TodoList om den matchar
            }
        }
        return null; // om ingen match retunerar null
    }

    // Metod för att hitta en lista baserat på ID
    public TodoList getListById(UUID id) {
        for (TodoList list : userOwnedLists) {
            if (list.getListId().equals(id)) {
                return list;
                
            }
        }
        return null;
    }
}
