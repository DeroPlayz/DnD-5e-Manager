package com.example.dnd5emanager.DataClasses;

public class Subrace {
    private String Name;
        public String getName(){return Name;}
    private int BaseArmorClass;

    private int GroundSpeed;
    private int AirSpeed;
    private int ClimbSpeed;
    private int SwimSpeed;
    private int BurrowSpeed;

    private int StrengthBonus;
    private int DexterityBonus;
    private int ConstitutionBonus;
    private int IntelligenceBonus;
    private int WisdomBonus;
    private int CharismaBonus;

    public Subrace(String Name, int BaseArmorClass, int GroundSpeed, int AirSpeed,
       int ClimbSpeed, int SwimSpeed, int BurrowSpeed, int StrengthBonus, int DexterityBonus, int ConstitutionBonus, int IntelligenceBonus, int WisdomBonus, int CharismaBonus){
        this.Name = Name;
        this.BaseArmorClass = BaseArmorClass;
        this.GroundSpeed = GroundSpeed;
        this.AirSpeed = AirSpeed;
        this.ClimbSpeed = ClimbSpeed;
        this.SwimSpeed = SwimSpeed;
        this.BurrowSpeed = BurrowSpeed;
        this.StrengthBonus = StrengthBonus;
        this.DexterityBonus = DexterityBonus;
        this.ConstitutionBonus = ConstitutionBonus;
        this.IntelligenceBonus = 0;
        this.WisdomBonus = 0;
        this.CharismaBonus = 0;
    }
}