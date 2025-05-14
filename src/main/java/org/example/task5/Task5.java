package org.example.task5;

public class Task5 {
    public static void Main() {
        Hero hero = new Hero.HeroBuilder()
                .name("John")
                .power(100)
                .reputation(10)
                .action("Help people")
                .action("Fight monsters")
                .action("Defend village")
                .build();


        hero.changeReputation(3);
        hero.printInfo();
        hero.doAction();

        Enemy enemy = new Enemy.EnemyBuilder()
                .name("Sean Kickerton 49th")
                .power(99)
                .reputation(-30)
                .action("Steal money")
                .action("Help monsters")
                .action("Rob bank")
                .action("Sell labs for money")
                .build();


        enemy.changeReputation(-2);
        enemy.printInfo();
        enemy.doAction();


    }
}
