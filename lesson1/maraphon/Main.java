package lesson1.maraphon;

import lesson1.maraphon.competitors.Cat;
import lesson1.maraphon.competitors.Competitor;
import lesson1.maraphon.competitors.Dog;
import lesson1.maraphon.competitors.Human;
import lesson1.maraphon.obstacles.Cross;
import lesson1.maraphon.obstacles.Obstacle;
import lesson1.maraphon.obstacles.Wall;
import lesson1.maraphon.obstacles.Water;

public class Main {
    public static void main(String[] args) {
        Competitor[] competitors ={
                new Human("Bob"),
                new Cat("Barsik"),
                new Dog("Jack"),
                new Dog("Тузик") };
        Obstacle[] obstacles = {
                new Cross(80),
                new Wall(2),
                new Wall(1),
                new Water(10)  };

        for (Competitor c:competitors) {
            for (Obstacle o:obstacles ) {
                o.doIt(c);
                if(!c.isDistance()) break;
            }
        }

        for (Competitor c:competitors ) {
            c.info();
        }
    }
}
