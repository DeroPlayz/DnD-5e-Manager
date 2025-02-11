package com.example.dnd5emanager.DataClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Feature {
    String Name;
    String Description;
    boolean Required;

    Feature(String Name) {
        this.Name = Name;
        Description = "";
        Required = true;
    }

    Feature(String Name, boolean Required) {
        this.Name = Name;
        Description = "";
        this.Required = Required;
    }

    Feature(String Name, String Description) {
        this.Name = Name;
        this.Description = Description;
        Required = true;
    }

    Feature(String Name, String Description, boolean Required) {
        this.Name = Name;
        this.Description = Description;
        this.Required = Required;
    }

    Feature Spellcasting;
    Feature Cantrips;
    Feature SpellcastingAbility;
    Feature PreparingAndCastingSpells;
    Feature RitualCasting;

    //Artificer
       final static Feature MagicalTinkering = new Feature("Magical Tinkering", "\"At 1st level, you've learned how to invest a spark of magic into mundane objects. To use this ability, you must have thieves' tools or artisan's tools in hand. You then touch a Tiny nonmagical object as an action and give it one of the following magical properties of your choice:\n" + "    - The object sheds bright light in a 5-foot radius and dim light for an additional 5 feet.\n" +
            "    - Whenever tapped by a creature, the object emits a recorded message that can be heard up to 10 feet away. You utter the message when you bestow this property on the object, and the recording can be no more than 6 seconds long.\n" +
            "    - The object continuously emits your choice of an odor or a nonverbal sound (wind, waves, chirping, or the like). The chosen phenomenon is perceivable up to 10 feet away.\n" +
            "    - A static visual effect appears on one of the object's surfaces. This effect can be a picture, up to 25 words of text, lines and shapes, or a mixture of these elements, as you like.\n" +
            "The chosen property lasts indefinitely. As an action, you can touch the object and end the property early.\n" +
            "You can bestow magic on multiple objects, touching one object each time you use this feature, though a single object can only bear one property at a time. The maximum number of objects you can affect with this feature at one time is equal to your Intelligence modifier (minimum of one object). If you try to exceed your maximum, the oldest property immediately ends, and then the new property applies.", true);
       final static Feature ToolsRequired = new Feature("Tools Required", "You produce your artificer spell effects through your tools. You must have a spellcasting focus - specifically thieves' tools or some kind of artisan's tool - in hand when you cast any spell with this Spellcasting feature (meaning the spell has an \"\"M\"\" component when you cast it). You must be proficient with the tool to use it in this way. See the equipment chapter in the Player's Handbook for descriptions of these tools.\n" +
            "After you gain the Infuse Item feature at 2nd level, you can also use any item bearing one of your infusions as a spellcasting focus.");
       final static Feature InfuseItem = new Feature("Infuse Item", "At 2nd level, you've gained the ability to imbue mundane items with certain magical infusions, turning those objects into magic items.");
       final static Feature InfusionsKnown = new Feature("Infusions Known", "\"When you gain this feature, pick four artificer infusions to learn. You learn additional infusions of your choice when you reach certain levels in this class, as shown in the Infusions Known column of the Artificer table.\n" +
            "Whenever you gain a level in this class, you can replace one of the artificer infusions you learned with a new one.");
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