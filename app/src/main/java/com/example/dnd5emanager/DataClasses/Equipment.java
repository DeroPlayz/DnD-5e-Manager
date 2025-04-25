package com.example.dnd5emanager.DataClasses;

public class Equipment {
    private String Name;
        public void setName(String name) {
            Name = name;
        }
        public String getName() {
            return Name;
        }
    private String Notes;
        public void setNotes(String notes) {
            Notes = notes;
        }
        public String getNotes() {
            return Notes;
        }

    public Equipment(String name, String notes) {
        Name = name;
        Notes = notes;
    }
}
