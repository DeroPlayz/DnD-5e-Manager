package com.example.dnd5emanager.DataClasses;

import java.util.Map;

public class Feat {
    private String Name;
        public void setName(String Name){this.Name = Name;}
        public String getName(){return Name;}

    private Map<Integer, String> Description;
    public String getDescription(int Level) {
        return Description.get(Level);
    }

    private int Level;
        public void setLevel(int Level){this.Level = Level;}
        public int getLevel(){return Level;}

    private String Notes;
        public void setNotes(String Notes){this.Notes = Notes;}
        public String getNotes(){return Notes;}

    public Feat(String Name, Map<Integer, String> Description, int Level){
        this.Name = Name;
        this.Description = Description;
        this.Level = Level;
    }
}
