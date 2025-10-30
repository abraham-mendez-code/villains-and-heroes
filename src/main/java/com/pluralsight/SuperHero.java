package com.pluralsight;

import java.util.ArrayList;
import java.util.Random;

public class SuperHero extends SuperPerson{

    public SuperHero(String name, int health, int heroLevel){
        //since the parent knows what to do with this data, pass it to the parent constructor
        super(name, health);

        //deal with the custom hero stuff
        this.experiencePoints = heroLevel;
    }

    @Override
    public void fight(SuperPerson opponent){

        //generate a random number of damage to do
        Random rand = new Random();
        //return a whole number between 0 and 101 inculusive of the 0 but not the 101 (0-100)
        int baseDamage = rand.nextInt(101);
        int bonus = 0; // initialize the bonus
        String randomItem = "";

        // make the total damage interesting by taking into account our experiencePoints
        if (!inventory.isEmpty()) {
            // create a new list of just the keys from the HashMap (glove, hammer, etc....)
            ArrayList<String> items = new ArrayList<String>(inventory.keySet());

            // get a random item name from the above list we just made and store it in randomeItem
            randomItem = items.get(new Random().nextInt(items.size()));

            // get the point value for that item from the inventory HashMap
            // bonus would be the int that represents the damage the item will do.
            bonus = inventory.get(randomItem);
        }

        int totalDamage = baseDamage + this.experiencePoints + bonus;

        //determine if we missed or hit based on the baseDamage
        //if we got a 0 for the base damage we missed
        //otherwise we landed our attack on our opponent and took the damage away from their health
        if(baseDamage == 0){
            System.out.println(this.getName() + "  Swings heroically and misses because that happens sometimes");
        }else{
            System.out.println(this.getName() + " lands a heroic punch on  " + opponent.getName() + " and caused " + (totalDamage - bonus) + " damage");
            if (bonus != 0)
                System.out.println(this.getName() + " used their " + randomItem + " and caused " + bonus + " additional damage");

            //actually cause the damage to the opponent
            opponent.takeDamage(totalDamage);
        }

        logHit(opponent);

    }

}
