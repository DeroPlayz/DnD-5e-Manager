package com.example.dnd5emanager.DataClasses;

public class Subrace {
    String Name;
    Race ParentRace;
    int BaseArmorClass;

    private int GroundSpeed;
    private int AirSpeed;
    private int ClimbSpeed;
    private int SwimSpeed;
    private int BurrowSpeed;

    int StrengthBonus;
    int DexterityBonus;
    int ConstitutionBonus;
    int IntelligenceBonus;
    int WisdomBonus;
    int CharismaBonus;

    public Subrace(String Name, Race ParentRace, int BaseArmorClass, int GroundSpeed, int AirSpeed,
       int ClimbSpeed, int SwimSpeed, int BurrowSpeed, int StrengthBonus, int DexterityBonus, int ConstitutionBonus, int IntelligenceBonus, int WisdomBonus, int CharismaBonus){
        this.Name = Name;
        this.ParentRace = ParentRace;
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