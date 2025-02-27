package com.example.dnd5emanager.DataClasses;

import java.util.ArrayList;
import java.util.Arrays;

public class Feature {
    private String Name;
        public String getName(){return Name;}
    private String Description;
        public String getDescription(){return Description;}
    private int Level;
        public int getLevel(){return Level;}

    Feature(String Name, String Description) {
        this.Name = Name;
        this.Description = Description;
        this.Level = 0;
    }
    Feature(String Name, String Description, int Level) {
        this.Name = Name;
        this.Description = Description;
        this.Level = Level;
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
        private final static Feature RightToolForTheJob = new Feature("Right Tool for the Job", "At 3rd level, you've learned how to produce exactly the tool you need: with thieves' tools or artisan's tools in hand, you can magically create one set of artisan's tools in an unoccupied space within 5 feet of you. This creation requires 1 hour of uninterrupted work, which can coincide with a short or long rest. Though the product of magic, the tools are nonmagical, and they vanish when you use this feature again.",3);

        private final static Feature Specialist = new Feature("Specialist", "At 3rd level, you choose the type of specialist you are. Your choice grants you features at 5th level and again at 9th and 15th level.", 3);
        //Alchemist Artificer
            private final static Feature AlchemistToolProficiency = new Feature("Tool Proficiency", "When you adopt this specialization at 3rd level, you gain proficiency with alchemist's supplies. If you already have this proficiency, you gain proficiency with one other type of artisan's tools of your choice.", 3);
            private final static Feature AlchemistSpells = new Feature("Alchemist Spells", "Starting at 3rd level, you always have certain spells prepared after you reach particular levels in this class, as shown in the Alchemist Spells table. These spells count as artificer spells for you, but they don’t count against the number of artificer spells you prepare.\n" +
                    "- Level 3: Healing Word, Ray of Sickness\n" +
                    "- Level 5: Flaming Sphere, Melf's Acid Arrow\n" +
                    "- Level 9: Gaseous Form, Mass Healing Word\n" +
                    "- Level 13: Blight, Death Ward\n" +
                    "- Level 17: Cloudkill, Raise Dead", 3);
            private final static Feature ExperimentalElixir = new Feature("Experimental Elixir", "Beginning at 3rd level, whenever you finish a long rest, you can magically produce an experimental elixir in an empty flask you touch. Roll on the Experimental Elixir table for the elixir's effect, which is triggered when someone drinks the elixir. As an action, a creature can drink the elixir or administer it to an incapacitated creature.\n" +
                    "You can create additional experimental elixirs by expending a spell slot of 1st level or higher for each one. When you do so, you use your action to create the elixir in an empty flask you touch, and you choose the elixir's effect from the Experimental Elixir table.\n" +
                    "Creating an experimental elixir requires you to have alchemist supplies on your person, and any elixir you create with this feature lasts until it is drunk or until the end of your next long rest.\n" +
                    "When you reach certain levels in this class, you can make more elixirs at the end of a long rest: two at 6th level and three at 15th level. Roll for each elixir's effect separately. Each elixir requires its own flask.\n" +
                    "1 - Healing: The drinker regains a number of hit points equal to 2d4 + your Intelligence Modifier\n" +
                    "2 - Swiftness: The drinker's walking speed increases by 10 feet for 1 hour.\n" +
                    "3 - Resilience: The drinker gains a +1 bonus to AC for 10 minutes.\n" +
                    "4 - Boldness: The drinker can roll a d4 and add the number rolled to every attack roll and saving throw they make for the next minute.\n" +
                    "5 - Flight: The drinker gains a flying speed of 10 feet for 10 minutes.\n" +
                    "6 - Transformation: The drinker's body is transformed as if by the Alter Self spell. The drinker determines the transformation caused by the spell, the effects of which last for 10 minutes.", 3);
            private final static Feature AlchemicalSavant = new Feature("Alchemical Savant", "At 5th level, you've developed masterful command of magical chemicals, enhancing the healing and damage you create through them. Whenever you cast a spell using your alchemist's supplies as the spellcasting focus, you gain a bonus to one roll of the spell. That roll must restore hit points or be a damage roll that deals acid, fire, necrotic, or poison damage, and the bonus equals your Intelligence modifier (minimum of +1).", 5);
            private final static Feature RestorativeReagents = new Feature("Restorative Reagents", "Starting at 9th level, you can incorporate restorative reagents into some of your works:\n" +
                    "- Whenever a creature drinks an experimental elixir you created, the creature gains temporary hit points equal to 2d6 + your Intelligence modifier (minimum of 1 temporary hit point).\n" +
                    "- You can cast Lesser Restoration without expending a spell slot and without preparing the spell, provided you use alchemist's supplies as the spellcasting focus. You can do so a number of times equal to your Intelligence modifier (minimum of once), and you regain all expended uses when you finish a long rest.", 9);
            private final static Feature ChemicalMastery = new Feature("Chemical Mastery", "By 15th level, you have been exposed to so many chemicals that they pose little risk to you, and you can use them to quickly end certain ailments:\n" +
                    "- You gain resistance to acid damage and poison damage, and you are now immune to the poisoned condition.\n" +
                    "- You can cast Greater Restoration and Heal without expending a spell slot, without preparing the spell, and without providing the material component, provided you use alchemist’s supplies as the spellcasting focus. Once you cast either spell with this feature, you can't cast that spell with it again until you finish a long rest.", 15);
        //Armorer Artificer
            private final static Feature ToolsOfTheTrade = new Feature("Tools of the Trade", "When you adopt this specialization at 3rd level, you gain proficiency with heavy armor. You also gain proficiency with smith's tools. If you already have this tool proficiency, you gain proficiency with one other type of artisan's tools of your choice.", 3);
            private final static Feature ArmorerSpells = new Feature("Armorer Spells", "Starting at 3rd level, you always have certain spells prepared after you reach particular levels in this class, as shown in the Armorer Spells table. These spells count as artificer spells for you, but they don't count against the number of artificer spells you prepare.\n" +
                    "Level 3 - Magic Missile, Thunderwave\n" +
                    "Level 5 - Mirror Image, Shatter\n" +
                    "Level 9 - Hypnotic Pattern, Lightning Bolt\n" +
                    "Level 13 - Fire Shield, Greater Invisibility\n" +
                    "Level 17 - Passwall, Wall of Force", 3);
            private final static Feature ArcaneArmor = new Feature("Arcane Armor", "Beginning at 3rd level, your metallurgical pursuits have led to you making armor a conduit for your magic. As an action, you can turn a suit of armor you are wearing into Arcane Armor, provided you have smith's tools in hand.\n" +
                    "You gain the following benefits while wearing this armor:\n" +
                    "- If the armor normally has a Strength requirement, the arcane armor lacks this requirement for you.\n" +
                    "- You can use the arcane armor as a spellcasting focus for your artificer spells.\n" +
                    "- The armor attaches to you and can’t be removed against your will. It also expands to cover your entire body, although you can retract or deploy the helmet as a bonus action. The armor replaces any missing limbs, functioning identically to a body part it is replacing.\n" +
                    "- You can doff or don the armor as an action.\n" +
                    "The armor continues to be Arcane Armor until you don another suit of armor or you die.", 3);
            private final static Feature ArmorModel = new Feature("Armor Model", "Beginning at 3rd level, you can customize your Arcane Armor. When you do so, choose one of the following armor models: Guardian or Infiltrator. The model you choose gives you special benefits while you wear it.\n" +
                    "Each model includes a special weapon. When you attack with that weapon, you can add your Intelligence modifier, instead of Strength or Dexterity, to the attack and damage rolls.\n" +
                    "You can change the armor's model whenever you finish a short or long rest, provided you have smith's tools in hand.\n" +
                    "- Guardian. You design your armor to be in the front line of conflict. It has the following features:\n" +
                    "    - Thunder Gauntlets. Each of the armor's gauntlets counts as a simple melee weapon while you aren't holding anything in it, and it deals 1d8 thunder damage on a hit. A creature hit by the gauntlet has disadvantage on attack rolls against targets other than you until the start of your next turn, as the armor magically emits a distracting pulse when the creature attacks someone else.\n" +
                    "    - Defensive Field. As a bonus action, you can gain temporary hit points equal to your level in this class, replacing any temporary hit points you already have. You lose these temporary hit points if you doff the armor. You can use this bonus action a number of times equal to your proficiency bonus, and you regain all expended uses when you finish a long rest.\n" +
                    "- Infiltrator. You customize your armor for subtle undertakings. It has the following features:\n" +
                    "    - Lightning Launcher. A gemlike node appears on one of your armored fists or on the chest (your choice). It counts as a simple ranged weapon, with a normal range of 90 feet and a long range of 300 feet, and it deals 1d6 lightning damage on a hit. Once on each of your turns when you hit a creature with it, you can deal an extra 1d6 lightning damage to that target.\n" +
                    "    - Powered Steps. Your walking speed increases by 5 feet.\n" +
                    "    - Dampening Field. You have advantage on Dexterity (Stealth) checks. If the armor normally imposes disadvantage on such checks, the advantage and disadvantage cancel each other, as normal.", 3);
            private final static Feature ArmorerExtraAttack = new Feature("Extra Attack", "Starting at 5th level, you can attack twice, rather than once, whenever you take the Attack action on your turn.", 5);
            private final static Feature ArmorMods = new Feature("Armor Modifications", "At 9th level, you learn how to use your artificer infusions to specially modify your Arcane Armor. That armor now counts as separate items for the purposes of your Infuse Items feature: armor (the chest piece), boots, helmet, and the armor's special weapon. Each of those items can bear one of your infusions, and the infusions transfer over if you change your armor's model with the Armor Model feature. In addition, the maximum number of items you can infuse at once increases by 2, but those extra items must be part of your Arcane Armor.", 9);
            private final static Feature PerfectedArmor = new Feature("Perfected Armor", "At 15th level, your Arcane Armor gains additional benefits based on its model, as shown below.\n" +
                    "- Guardian. When a Huge or smaller creature you can see ends its turn within 30 feet of you, you can use your reaction to magically force it to make a Strength saving throw against your spell save DC. On a failed save, you pull the creature up to 25 feet directly to an unoccupied space. If you pull the target to a space within 5 feet of you, you can make a melee weapon attack against it as part of this reaction.\n" +
                    "   - You can use this reaction a number of times equal to your proficiency bonus, and you regain all expended uses of it when you finish a long rest.\n" +
                    "- Infiltrator. Any creature that takes lightning damage from your Lightning Launcher glimmers with magical light until the start of your next turn. The glimmering creature sheds dim light in a 5-foot radius, and it has disadvantage on attack rolls against you, as the light jolts it if it attacks you. In addition, the next attack roll against it has advantage, and if that attack hits, the target takes an extra 1d6 lightning damage.", 15);
        //Artillerist Artificer
            private final static Feature ArtilleristToolProficiency = new Feature("Tool Proficiency", "When you adopt this specialization at 3rd level, you gain proficiency with woodcarver's tools. If you already have this proficiency, you gain proficiency with one other type of artisan's tools of your choice.", 3);
            private final static Feature ArtilleristSpells = new Feature("Artillerist Spells", "Starting at 3rd level, you always have certain spells prepared after you reach particular levels in this class, as shown in the Artillerist Spells table. These spells count as artificer spells for you, but they don’t count against the number of artificer spells you prepare.\n" +
                    "Level 3 - Shield, Thunderwave\n" +
                    "Level 5 - Scorching Ray, Shatter\n" +
                    "Level 9 - Fireball, Wind Wall\n" +
                    "Level 13 - Ice Storm, Wall of Fire\n" +
                    "Level 17 - Cone of Cold, Wall of Force", 3);
            private final static Feature EldritchCannon= new Feature("EldritchCannon", "Also at 3rd level, you've learned how to create a magical cannon. Using woodcarver's tools or smith's tools, you can take an action to magically create a Small or Tiny eldritch cannon in an unoccupied space on a horizontal surface within 5 feet of you. A Small eldritch cannon occupies its space, and a Tiny one can be held in one hand. Once you create a cannon, you can't do so again until you finish a long rest or until you expend a spell slot to create one. You can have only one cannon at a time and can't create one while your cannon is present.\n" +
                    "The cannon is a magical object. Regardless of size, the cannon has an AC of 18 and a number of hit points equal to five times your artificer level. It is immune to poison damage and psychic damage. If it is forced to make an ability check or a saving throw, treat all its ability scores as 10 (+0). If the mending spell is cast on it, it regains 2d6 hit points. It disappears if it is reduced to 0 hit points or after 1 hour. You can dismiss it early as an action.\n" +
                    "When you create the cannon, you determine its appearance and whether it has legs. You also decide which type it is, choosing from the options on the Eldritch Cannons table. On each of your turns, you can take a bonus action to cause the cannon to activate if you are within 60 feet of it. As part of the same bonus action, you can direct the cannon to walk or climb up to 15 feet to an unoccupied space, provided it has legs.\n" +
                    "- Flamethrower: The cannon exhales fire in an adjacent 15-foot cone that you designate. Each creature in that area must make a Dexterity saving throw against your spell save DC, taking 2d8 fire damage on a failed save or half as much damage on a successful one. The fire ignites any flammable objects in the area that aren't being worn or carried.\n" +
                    "- Force Ballista: Make a ranged spell attack, originating from the cannon, at one creature or object within 120 feet of it. On a hit, the target takes 2d8 force damage, and if the target is a creature, it is pushed up to 5 feet away from the cannon.\n" +
                    "- Protector: The cannon emits a burst of positive energy that grants itself and each creature of your choice within 10 feet of it a number of temporary hit points equal to 1d8 + your Intelligence modifier (minimum of +1).", 3);
            private final static Feature ArcaneFirearm = new Feature("Arcane Firearm", "At 5th level, You know how to turn a wand, staff, or rod into an arcane firearm, a conduit for your destructive spells. When you finish a long rest, you can use woodcarver's tools to carve special sigils into a wand, staff, or rod and thereby turn it into your arcane firearm. The sigils disappear from the object if you later carve them on a different item. The sigils otherwise last indefinitely.\n" +
                    "You can use your arcane firearm as a spellcasting focus for your artificer spells. When you cast an artificer spell through the firearm, roll a d8, and you gain a bonus to one of the spell's damage rolls equal to the number rolled.",5);
            private final static Feature ExplosiveCannon = new Feature("Explosive Cannon", "Starting at 9th level, every eldritch cannon you create is more destructive:\n" +
                    "- The cannon's damage rolls all increase by 1d8.\n" +
                    "- As an action, you can command the cannon to detonate if you are within 60 feet of it. Doing so destroys the cannon and forces each creature within 20 feet of it to make a Dexterity saving throw against your spell save DC, taking 3d8 force damage on a failed save or half as much damage on a successful one.\n", 9);
            private final static Feature FortifiedPosition = new Feature("Fortified Position", "By 15th level, you’re a master at forming well-defended emplacements using Eldritch Cannon:\n" +
                    "- You and your allies have half cover while within 10 feet of a cannon you create with Eldritch Cannon, as a result of a shimmering field of magical protection that the cannon emits.\n" +
                    "- You can now have two cannons at the same time. You can create two with the same action (but not the same spell slot), and you can activate both of them with the same bonus action. You determine whether the cannons are identical to each other or different. You can't create a third cannon while you have two.", 15);
        //Battle Smith
            private final static Feature BattleSmithToolProficiency = new Feature("Battle Smith Tool Proficiency", "When you adopt this specialization at 3rd level, you gain proficiency with smith's tools. If you already have this proficiency, you gain proficiency with one other type of artisan's tools of your choice.", 3);
            private final static Feature BattleSmithSpells = new Feature("Battle Smith", "Starting at 3rd level, you always have certain spells prepared after you reach particular levels in this class, as shown in the Battle Smith Spells table. These spells count as artificer spells for you, but they don’t count against the number of artificer spells you prepare.\n" +
                    "Level 3 - Heroism, Shield\n" +
                    "Level 5 - Branding Smite, Warding Bond\n" +
                    "Level 9 - Aura of Vitality, Conjure Barrage\n" +
                    "Level 13 - Aura of Purity, Fire Shield\n" +
                    "Level 17 - Banishing Smite, Mass Cure Wounds", 3);
            private final static Feature BattleReady = new Feature("Battle Ready", "When you reach 3rd level, your combat training and your experiments with magic have paid off in two ways:\n" +
                    "- You gain proficiency with martial weapons.\n" +
                    "- When you attack with a magic weapon, you can use your Intelligence modifier, instead of Strength or Dexterity modifier, for the attack and damage rolls.", 3);

            private final static Feature SteelDefender = new Feature("Steel Defender", "By 3rd level, your tinkering has borne you a faithful companion, a steel defender. It's friendly to you and your companions, and it obeys your commands. See its game statistics in the Steel Defender stat block, which uses your proficiency bonus (PB) in several places. You determine the creature's appearance and whether it has two legs or four; your choice has no effect on its game statistics.\n" +
                    "In combat, the defender shares your initiative count, but it takes its turn immediately after yours. It can move and use its reaction on its own, but the only action it takes on its turn is the Dodge action, unless you take a bonus action on your turn to command it to take another action. That action can be one in its stat block or some other action. If you are incapacitated, the defender can take any action of its choice, not just Dodge.\n" +
                    "If the Mending spell is cast on it, it regains 2d6 hit points. If it has died within the last hour, you can use your smith's tools as an action to revive it, provided you are within 5 feet of it and you expend a spell slot of 1st level or higher. The steel defender returns to life after 1 minute with all its hit points restored.\n" +
                    "At the end of a long rest, you can create a new steel defender if you have smith's tools with you. If you already have a defender from this feature, the first one immediately perishes. The defender also perishes if you die.",3);
            private final static Feature BattleSmithExtraAttack = new Feature("Extra Attack", "Starting at 5th level, you can attack twice, rather than once, whenever you take the Attack action on your turn.", 5);

            private final static Feature ArcaneJolt = new Feature("Arcane Jolt", "At 9th level, you've learn new ways to channel arcane energy to harm or heal. When either you hit a target with a magic weapon attack or your steel defender hits a target, you can channel magical energy through the strike to create one of the following effects:\n" +
                    "- The target takes an extra 2d6 force damage.\n" +
                    "- Choose one creature or object you can see within 30 feet of the target. Healing energy flows into the chosen recipient, restoring 2d6 hit points to it.\n" +
                    "You can use this energy a number of times equal to your Intelligence modifier (minimum of once), but you can do so no more than once on a turn. You regain all expended uses when you finish a long rest.", 9);
//            private final static Feature = new Feature();


    private final static Feature Flight50 = new Feature("Flight", "You have a flying speed of 50 feet. You cannot use this feature while wearing medium or heavy armor.");
    private final static Feature Talons = new Feature("Talons", "You are proficient with unarmed strikes. You deal 1d4 slashing damage on hit.");
    private final static Feature Darkvision = new Feature("Darkvision", "Within 60 feet, you perceive dim light as bright and total darkness as dim light. In darkness, you can only see shades of gray.");
    private final static Feature CelestialResistance = new Feature("Celestial Resistance", "You have resistance to necrotic and radiant damage.");
    private final static Feature HealingHands = new Feature("Healing Hands", "As an action, you can touch a creature and cause it to regain a number of Health equal to your level. You can use this trait once per long rest.");
    private final static Feature LightBearer = new Feature("Light Bearer", "You know the cantrip Light. You cast it with Charisma.");
    private final static Feature RadiantSoul = new Feature("Radiant Soul", "Starting at Level 3, you can use your action to unleash the divine energy within you. Your eyes glimmer and two luminous, incorporeal wings sprout from your back.\nThis state lasts for one minute, but can be ended early as a bonus action. While in this state, you gain a flying speed of 30 feet and once per turn, you can deal extra radiant damage equal to your level to one enemy when you hit them with an attack or spell.\nThis trait can be used once per long rest.", 3);
    private final static Feature RadiantConsumption = new Feature("Radiant Consumption", "Starting at Level 3, you can use your action to unleash the divine energy within you. A searing light radiates from you, pouring out of your eyes and mouth, almost charring you.\nThis state lasts for one minute, but can be ended early as a bonus action. While in this state, you emit a bright light in a 10-foot radius of you, and a dim light for an additional 10 feet. At the end of your turn, you and any creature within 10 feet of you take's radiant damage equal to your level/2, rounded up. Additionally, once per turn you can deal extra radiant damage equal to your level to one enemy when you hit them with an attack or spell.\nThis trait can be used once per long rest." , 3);
    private final static Feature NecroticShroud = new Feature("Necrotic Shroud", "Starting at Level 3, you can use your action to unleash the divine energy within you. Your eyes turn into pools of darkness, and two skeletal, ghostly, but flightless wings sprout from your back. The instant you transform, all creatures within 10 feet of you which you can see must succeed a Charisma saving throw against you, with a DC of 8 + your Charisma modifier + your proficiency bonus, or become frightened until the end of your next turn.\nYour transformation lasts for one minute, but can be ended early as a bonus action. While in this state, you can deal extra necrotic damage equal to your level to one enemy when you hit them with an attack or spell.\nThis trait can be used once per long rest.", 3);
    private final static Feature LongLimbed = new Feature("Long Limbed", "When you make a melee attack on your turn, your reach is 5 feet greater than normal.");
    private final static Feature PowerfulBuild = new Feature("Powerful Build", "You count as one size larger when determining your carrying capacity as well as the weight you can push, drag, or lift.");
    private final static Feature Sneaky = new Feature("Sneaky", "You are inherently proficient in Stealth.");
    private final static Feature SurpriseAttack = new Feature("Surprise Attack", "If you surprise a creature and hit it with an attack on your first turn in combat, the attack deals an extra 2d6 damage to it. You can use this once per combat encounter.");
    private final static Feature LowLightVision = new Feature("Low-Light Vision", "As a nocturnal race, you have superior vision in dim conditions. You can see in dim light within 60 feet as if it were bright light.\nNote: Unlike Dark Vision, this does not turn darkness into dim light.");
    private final static Feature CatsClaws = new Feature("Cat's Claws", "Because of your claws, you have a climbing speed of 20 feet. Additionally, your claws serve as natural weapons for unarmed strikes. You use d4 for your unarmed strike rolls and deal slashing damage.");
    private final static Feature CatlikeReflexes = new Feature("Catlike Reflexes", "You may add half your proficiency bonus, rounded down, to initiative rolls.");
    private final static Feature FelineEmpathy = new Feature("Feline Empathy", "You can communicate simple ideas with feline creatures, such as cats, lions, and tigers.");
    private final static Feature CatlikeTread = new Feature("Catlike Tread", "You are inherently proficient in Stealth.");
    private final static Feature FleetOfFoot = new Feature("Fleet of Foot", "You have a movement speed of 35 feet.");
    private final static Feature NineLives = new Feature("Nine Lives", "You resist fall damage.");
    private final static Feature BigCatsClaws = new Feature("Big Cats' Claws", "Your unarmed strikes now use d6.");
    private final static Feature CatsMysticism = new Feature("Cat's Mysticism", "You know one cantrip of your choice from the Wizard spell list and can cast it at will. You use Intelligence to cast it.");
    private final static Feature StudentOfMagic = new Feature("Student of Magic", "You are inherently proficient in Arcana.");
    private final static Feature ExtraLanguage = new Feature("Extra Language", "You can speak, read, and write one additional language of your choice.");
    private final static Feature Charge = new Feature("Charge", "If you move at least 30 feet straight towards a target and then hit it with a melee weapon attack on the same turn, you can immediately follow that attack with a bonus action, attacking the target with your hooves.");
    private final static Feature EquineBuild = new Feature("Equine Build", "You count as one size larger when determining your carrying capacity as well as the weight you can push, drag, or lift. Additionally, any climbing that requires hands and feet is especially difficult due to your hooves. Consequently, each foot of movement costs 4 times as much.");
    private final static Feature Survivor = new Feature("Survivor", "You can select a proficiency from the following list: Animal Handling, Medicine, Nature, or Survival.");
    private final static Feature ChangeAppearance = new Feature("Change Appearance", "As an action, you can transform into any humanoid of your size or back into your true form. However, your equipment does not change with you. You have advantage on Deception checks passing your appearance as genuine. You will revert to normal upon death.");
    private final static Feature ChangelingInstincts = new Feature("Changeling Instincts", "You can select a proficiency from the following list: Deception, Intimidation, Insight, or Persuasion.");
    private final static Feature UnsettlingVisage = new Feature("Unsettling Visage", "You can use your reaction to impose a disadvantage on an attack roll a creature in your view makes against you. You must use this feature before learning the result of the roll. Every creature that can see you within 30 feet learns of your Changeling status upon using this trait. You must finish a short or long rest before using this trait again.");
//    private final static Feature = new Feature();
//    private final static Feature = new Feature();
//    private final static Feature = new Feature();
//    private final static Feature = new Feature();
//    private final static Feature = new Feature();
//    private final static Feature = new Feature();
//    private final static Feature = new Feature();
//    private final static Feature = new Feature();
//    private final static Feature = new Feature();
//    private final static Feature = new Feature();
//    private final static Feature = new Feature();
//    private final static Feature = new Feature();
//    private final static Feature = new Feature();


    public final static ArrayList<Feature> ArtificerFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown, FirearmProficiency));
        public final static ArrayList<Feature> AlchemistFeatures = new ArrayList<Feature>(Arrays.asList(AlchemistToolProficiency, AlchemistSpells, ExperimentalElixir, AlchemicalSavant, RestorativeReagents, ChemicalMastery));
    public final static ArrayList<Feature> BarbarianFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public final static ArrayList<Feature> BardFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public final static ArrayList<Feature> ClericFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public final static ArrayList<Feature> DruidFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public final static ArrayList<Feature> FighterFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public final static ArrayList<Feature> MonkFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public final static ArrayList<Feature> PaladinFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public final static ArrayList<Feature> RangerFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public final static ArrayList<Feature> RogueFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public final static ArrayList<Feature> SorcererFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public final static ArrayList<Feature> WarlockFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));
    public final static ArrayList<Feature> WizardFeatures = new ArrayList<Feature>(Arrays.asList(MagicalTinkering, ToolsRequired, InfuseItem, InfusionsKnown));


}