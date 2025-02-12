package com.example.dnd5emanager.DataClasses;

public class ClassAndLevel {
    CharacterClass Class;
    int Level;
        public void setLevel(int Level){this.Level = Level;}
        public int getLevel(){return Level;}
    public ClassAndLevel(CharacterClass Class, int Level){
        this.Class = Class;
        this.Level = Level;
    }

    public void levelUp(){
        Level++;
    }


}
