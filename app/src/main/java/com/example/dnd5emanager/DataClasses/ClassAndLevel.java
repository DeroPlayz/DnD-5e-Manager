package com.example.dnd5emanager.DataClasses;

import java.util.ArrayList;

public class ClassAndLevel {
    CharacterClass Class;
    Subclass Subclass;
    int Level;
        public void setLevel(int Level){this.Level = Level;}
        public int getLevel(){return Level;}
    public ClassAndLevel(CharacterClass Class, int Level){
        this.Class = Class;
        this.Level = Level;
    }
    public ClassAndLevel(CharacterClass Class, Subclass Subclass, int Level){
        this.Class = Class;
        this.Subclass = Subclass;
        this.Level = Level;
    }

//    public findClass(String Class){
//            for(int i = 0; i < this.)
//    }

    public void levelUp(){
        Level++;
    }

    public static int findClass(ArrayList<ClassAndLevel> Classes, CharacterClass Target){
        for(int i = 0; i < Classes.size(); i++){
            if(Classes.get(i).Class.getName().equals(Target.getName())){
                return i;
            }
        }
        return 0;
    }
}
