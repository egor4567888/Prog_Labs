package things;

import common.Coloures;
import common.Rarities;

public class Flower {
    final private Coloures colour;
    final private Rarities rarity;
    final private int numOfPetals;
    public Flower(){
        int rar = (int)(Math.random()*100);
        int cl = (int)(Math.random()*4.99);
        this.numOfPetals = (int)((Math.random()+0.2)*50);
        switch (cl){
            case 0 -> this.colour = Coloures.BLUE;
            case 1 -> this.colour = Coloures.GREEN;
            case 2 -> this.colour = Coloures.YELLOW;
            case 3 -> this.colour = Coloures.PURPLE;
            case 4 -> this.colour = Coloures.RED;
            default -> this.colour = Coloures.BLUE;
        }
        if (rar<50) this.rarity = Rarities.COMMON;
        else if (rar<75) this.rarity = Rarities.RARE;
        else if (rar<93) this.rarity = Rarities.EPIC;
        else this.rarity = Rarities.LEGENDARY;
    }
    public int getNumOfPetals(){
        return numOfPetals;
    }
    @Override
    public String toString() {
        return this.rarity + " " + this.colour + " цветок";
    }
}