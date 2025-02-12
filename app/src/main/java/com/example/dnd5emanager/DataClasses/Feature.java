package com.example.dnd5emanager.DataClasses;

import java.util.ArrayList;
import java.util.Arrays;

public class Feature {
    private final String Name;
        public String getName(){return Name;}
    private final String Description;
        public String getDescription(){return Description;}
    private final int Level;
        public int getLevel(){return Level;}
    private final boolean Required;
        public boolean isRequired(){return Required;}

    Feature(String Name, int Level) {
        this.Name = Name;
        Description = "";
        this.Level = Level;
        Required = true;
    }

    Feature(String Name, String Description, int Level) {
        this.Name = Name;
        this.Description = Description;
        this.Level = Level;
        Required = true;
    }

    Feature(String Name, String Description, int Level, boolean Required) {
        this.Name = Name;
        this.Description = Description;
        this.Level = Level;
        this.Required = Required;
    }

    private static Feature Spellcasting;
    private static Feature Cantrips;
    private static Feature SpellcastingAbility;
    private static Feature PreparingAndCastingSpells;
    private static Feature RitualCasting;

    //Artificer
        private final static Feature MagicalTinkering = new Feature("Magical Tinkering", "\"At 1st level, you've learned how to invest a spark of magic into mundane objects. To use this ability, you must have thieves' tools or artisan's tools in hand. You then touch a Tiny nonmagical object as an action and give it one of the following magical properties of your choice:\n" + "    - The object sheds bright light in a 5-foot radius and dim light for an additional 5 feet.\n" +
            "    - Whenever tapped by a creature, the object emits a recorded message that can be heard up to 10 feet away. You utter the message when you bestow this property on the object, and the recording can be no more than 6 seconds long.\n" +
            "    - The object continuously emits your choice of an odor or a nonverbal sound (wind, waves, chirping, or the like). The chosen phenomenon is perceivable up to 10 feet away.\n" +
            "    - A static visual effect appears on one of the object's surfaces. This effect can be a picture, up to 25 words of text, lines and shapes, or a mixture of these elements, as you like.\n" +
            "The chosen property lasts indefinitely. As an action, you can touch the object and end the property early.\n" +
            "You can bestow magic on multiple objects, touching one object each time you use this feature, though a single object can only bear one property at a time. The maximum number of objects you can affect with this feature at one time is equal to your Intelligence modifier (minimum of one object). If you try to exceed your maximum, the oldest property immediately ends, and then the new property applies.", 1);
        private final static Feature ToolsRequired = new Feature("Tools Required", "You produce your artificer spell effects through your tools. You must have a spellcasting focus - specifically thieves' tools or some kind of artisan's tool - in hand when you cast any spell with this Spellcasting feature (meaning the spell has an \"\"M\"\" component when you cast it). You must be proficient with the tool to use it in this way. See the equipment chapter in the Player's Handbook for descriptions of these tools.\n" +
            "After you gain the Infuse Item feature at 2nd level, you can also use any item bearing one of your infusions as a spellcasting focus.", 1);
        private final static Feature InfuseItem = new Feature("Infuse Item", "At 2nd level, you've gained the ability to imbue mundane items with certain magical infusions, turning those objects into magic items.", 2);
        private final static Feature InfusionsKnown = new Feature("Infusions Known", "\"When you gain this feature, pick four artificer infusions to learn. You learn additional infusions of your choice when you reach certain levels in this class, as shown in the Infusions Known column of the Artificer table.\n" +
            "Whenever you gain a level in this class, you can replace one of the artificer infusions you learned with a new one.", 2);
        private final static Feature InfusingAnItem = new Feature("Infusing an Item", "Whenever you finish a long rest, you can touch a nonmagical object and imbue it with one of your artificer infusions, turning it into a magic item. An infusion works on only certain kinds of objects, as specified in the infusion's description. If the item requires attunement, you can attune yourself to it the instant you infuse the item. If you decide to attune to the item later, you must do so using the normal process for attunement (see the attunement rules in the Dungeon Master's Guide).\n" +
           "Your infusion remains in an item indefinitely, but when you die, the infusion vanishes after a number of days equal to your Intelligence modifier (minimum of 1 day). The infusion also vanishes if you replace your knowledge of the infusion.\n" +
           "You can infuse more than one nonmagical object at the end of a long rest; the maximum number of objects appears in the Infused Items column of the Artificer table. You must touch each of the objects, and each of your infusions can be in only one object at a time. Moreover, no object can bear more than one of your infusions at a time. If you try to exceed your maximum number of infusions, the oldest infusion ends, and then the new infusion applies.\n" +
           "If an infusion ends on an item that contains other things, like a bag of holding, its contents harmlessly appear in and around its space.", 2);
        private final static Feature FirearmProficiency = new Feature("Firearm Proficiency", "The secrets of gunpowder weapons have been discovered" +
           "in various corners of the D&D multiverse. If your Dungeon Master uses the rules on firearms in the Dungeon Master's Guide and your artificer has been exposed to the operation of such weapons, your artificer is proficient with them.", 1);
        private final static Feature Specialist = new Feature("Specialist", "At 3rd level, you choose the type of specialist you are. Your choice grants you features at 5th level and again at 9th and 15th level.", 3);
        private final static Feature RightToolForTheJob = new Feature("Right Tool for the Job", "At 3rd level, you've learned how to produce exactly the tool you need: with thieves' tools or artisan's tools in hand, you can magically create one set of artisan's tools in an unoccupied space within 5 feet of you. This creation requires 1 hour of uninterrupted work, which can coincide with a short or long rest. Though the product of magic, the tools are nonmagical, and they vanish when you use this feature again.",3);
        //Alchemist Artificer



    public static final ArrayList<Feature> ArtificerFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public static final ArrayList<Feature> BarbarianFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public static final ArrayList<Feature> BardFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public static final ArrayList<Feature> ClericFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public static final ArrayList<Feature> DruidFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public static final ArrayList<Feature> FighterFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public static final ArrayList<Feature> MonkFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public static final ArrayList<Feature> PaladinFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public static final ArrayList<Feature> RangerFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public static final ArrayList<Feature> RogueFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public static final ArrayList<Feature> SorcererFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public static final ArrayList<Feature> WarlockFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public static final ArrayList<Feature> WizardFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
}