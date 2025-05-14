package com.example.dnd5emanager.DataClasses;

public class Piece {
    private String Name;
    public void setName(String Name){this.Name = Name;}
    public String getName(){return Name;}

    private String Description;
    public void setDescription(String Description){this.Description = Description;}
    public String getDescription(){return Description;}

    public Piece(String Name, String Description){
        this.Name = Name;
        this.Description = Description;
    }

    public Piece(){
        Name = "";
        Description = "";
    }
}
