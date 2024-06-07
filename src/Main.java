import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //System object
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //Game Variables

        String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};
        int maxEnemyHealth = 100;
        int enemyAttackDamage = 20;

        //Player variable
        int health = 200;
        int attackDamage = 25;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropRate = 30; //Percentage


        boolean running = true;

        System.out.println( "WELCOME TO THE DUNGEON!");

        GAME:
        while(running){
            System.out.println("____________________________________________");

            int enemyHealth = random.nextInt(maxEnemyHealth);
            String enemy = enemies[random.nextInt(enemies.length)];
            System.out.println("\t#" + enemy + " has appeared! #\n");

            while (enemyHealth >0){
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + " HP: "+ enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run \n");

                String input = scanner.nextLine();

                if ( input.equals("1")){
                    int damageDealt = random.nextInt(attackDamage);
                    int damageTaken = random.nextInt(enemyAttackDamage);
                    enemyHealth -=damageDealt;
                    health -= damageTaken;
                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t  You recieve " + damageTaken + " in retaliation.");
                    if ( health < 1){
                        System.out.println("\t You have taken too much damage");
                        System.out.println("\t GAME OVER");

                        break GAME;
                    }


                } else if (input.equals("2")) {
                    if ( numHealthPotions >0){
                        health = health + healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println( "You use a health potion, healing yourself for " + healthPotionHealAmount + "."
                                           + "\n\t> You now have" + health + " HP. ");
                    }else {
                        System.out.println("\t> You have no potions left");
                    }

                } else if (input.equals("3")) {
                    System.out.println(" You have chosen to run from the " +enemy);
                    continue GAME;


                }else {
                    System.out.println("\t Invalid Command");

                }


            }


            System.out.println("_______________________________________");
            System.out.println(" # " + enemy + " was defeated! #");
            System.out.println(" # You have " + health + " HP left. #");

            if(random.nextInt(100) < healthPotionDropRate){
                numHealthPotions++;
                System.out.println("The enemy dropped a health potion.");
                System.out.println("You have " + numHealthPotions + " health potion(s)");
            }
            System.out.println("_______________________________________");
            System.out.println("What would you like to do now.");
            System.out.println("\t1. Find Another enemy.");
            System.out.println("\t2. Leave \n");

            String input = scanner.nextLine();
            while(!input.equals("1") &&  !input.equals("2")){
                System.out.println("Invalid option");
                input = scanner.nextLine();
            }
            if ( input.equals("1")){

            }else if (input.equals("2")){
                System.out.println("Thank you for playing");
                break ;
            }



        }





    }
}