package com.pluralsight;

public class ShowdownApp {

    public static void main(String[] args) {

        // create a hero and villain
        SuperHero loopedHero = new SuperHero("Heroman", 500, 100);
        SuperVillain loopedVillain = new SuperVillain("Villainman", 500, 100);


        //print some stats
        System.out.println("=== Welcome to the Super Showdown! ===");
        System.out.println(loopedHero.getStatus());
        System.out.println(loopedVillain.getStatus());

        boolean heroWins = true;

        loopedHero.addPowerUp("glove", 10);
        loopedVillain.addPowerUp("trap", 7);

        while (loopedHero.isAlive() && loopedVillain.isAlive()) {

            System.out.println("\n-- Hero's Turn --");
            loopedHero.fight(loopedVillain);
            System.out.println(loopedVillain.getStatus());

            if (!loopedVillain.isAlive())
                break;

            System.out.println("\n-- Villain's Turn--");
            loopedVillain.fight(loopedHero);
            System.out.println(loopedHero.getStatus());

            if (!loopedHero.isAlive()) {
                heroWins = false;
                break;
            }
        }

        System.out.println("\n== Showdown Over! ==");
        if (heroWins)
            System.out.println(loopedHero.getName() + " has won the battle!");
        else
            System.out.println(loopedVillain.getName() + " has won the battle!");

    }

}
