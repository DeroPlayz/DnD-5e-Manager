package com.example.dnd5emanager.DataClasses;

public class Background {
    private String Name;
        public void setName(String Name) {
            this.Name = Name;
        }
        public String getName() {
            return Name;
        }
//    private final ArrayList<Feature> Features;
    private final int Gold;
//    private final ArrayList<Equipment> Equipment;
//    private final ArrayList<String> Languages;

    public Background(String Name, /*ArrayList<Feature> Features,*/ int Gold/*, ArrayList<Equipment> Equipment, ArrayList<String> Languages*/){
        this.Name = Name;
//        this.Features = Features;
        this.Gold = Gold;
//        this.Equipment = Equipment;
//        this.Languages = Languages;
    }

}
