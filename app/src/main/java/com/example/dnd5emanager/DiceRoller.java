package com.example.dnd5emanager;

public class DiceRoller {
    public final static int DICE_D4 = 4;
    public final static int DICE_D6 = 6;
    public final static int DICE_D8 = 8;
    public final static int DICE_D10 = 10;
    public final static int DICE_D12 = 12;
    public final static int DICE_D20 = 20;

    public int rollDice(int count, int sides){
        int[] dice = new int[count];
        for (int i = 0; i < 4; i++) {
            dice[i] = (int) (Math.random() * sides) + 1;
        }
        int total = 0;
        for (int i = 0; i < dice.length; i++) {
            total += dice[i];
        }
        return total;
    }

    public int rollPercentileDice(){
        return (int) (Math.random() * 100) + 1;
    }
}
