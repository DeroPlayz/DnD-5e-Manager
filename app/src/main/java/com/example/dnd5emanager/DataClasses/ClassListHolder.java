package com.example.dnd5emanager.DataClasses;

public class ClassListHolder{
    CharacterClass Class;
    int Level;
        public void setLevel(int Level){this.Level = Level;}
        public int getLevel(){return Level;}
    int XP;
        public void setXP(int XP){this.XP = XP;}
        public void addXP(int XPDiff){XP += XPDiff;}
        public void removeXP(int XPDiff){XP -= XPDiff;}
        public int getXP(){return XP;}
}
