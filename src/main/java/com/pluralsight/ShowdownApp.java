package com.pluralsight;

public class ShowdownApp {

    public static void main(String[] args) {

        // create a hero and villain
        SuperHero loopedHero = new SuperHero("Heroman", 500, 100);
        SuperVillain loopedVillain = new SuperVillain("Villainman", 500, 100);


        //print some stats
        System.out.println("Before fighting " + loopedHero.getName() + " has " + loopedHero.getHealth() + " health");
        System.out.println("Before fighting " + loopedVillain.getName() + " has " + loopedVillain.getHealth() + " health");

        boolean heroWins = true;
        while (true) {

            loopedHero.fight(loopedVillain);
            System.out.println(loopedVillain.getName() + " has " + loopedVillain.getHealth() + " health remaining");

            if (!loopedVillain.isAlive())
                break;

            loopedVillain.fight(loopedHero);
            System.out.println(loopedHero.getName() + " has " + loopedHero.getHealth() + " health remaining");

            if (!loopedHero.isAlive()) {
                heroWins = false;
                break;
            }
        }

        if (heroWins)
            System.out.println(loopedHero.getName() + " has won the battle!");
        else
            System.out.println(loopedVillain.getName() + " has won the battle!");

    }

}
