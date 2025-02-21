package com.example.dnd5emanager.DataClasses;

import java.util.ArrayList;

public class ClassAndLevel {
    public CharacterClass CharClass;
        public void setCharClass(CharacterClass Class){this.CharClass = Class;}
        public CharacterClass getCharClass(){return CharClass;}

    public Subclass Subclass;
        public void setSubclass(Subclass Subclass){this.Subclass = Subclass;}
        public Subclass getSubclass(){
            if(Subclass != null){
                return Subclass;
            }
            return Constants.findSub(CharClass.getName());
        }

    int Level;
        public void setLevel(int Level){this.Level = Level;}
        public int getLevel(){return Level;}
    public ClassAndLevel(CharacterClass CharClass, int Level){
        this.CharClass = CharClass;
        this.Level = Level;
    }
    public ClassAndLevel(CharacterClass CharClass, Subclass Subclass, int Level){
        this.CharClass = CharClass;
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
            if(Classes.get(i).CharClass.getName().equals(Target.getName())){
                return i;
            }
        }
        return 0;
    }
}
