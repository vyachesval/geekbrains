package lesson1.maraphon;

import lesson1.maraphon.competitors.Cat;
import lesson1.maraphon.competitors.Competitor;
import lesson1.maraphon.competitors.Dog;
import lesson1.maraphon.competitors.Human;
import lesson1.maraphon.obstacles.Cross;
import lesson1.maraphon.obstacles.Obstacle;
import lesson1.maraphon.obstacles.Wall;
import lesson1.maraphon.obstacles.Water;
import maraphon.competitors.Team;
import maraphon.obstacles.Course;

public class Main {
    public static void main(String[] args) {

        Team team = new Team("GEEKS",   new Competitor[] {
                        new Human("Petya"),
                        new Cat("Vasiliy"),
                        new Cat("Murka"),
                        new Dog("Barbos")
        });

        Competitor[] competitors ={
                new Human("Bob"),
                new Cat("Barsik"),
                new Dog("Jack"),
                new Dog("Тузик"),
                team
        };
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

        team.infoWhoDone();


        System.out.println();

        Course course = new Course( new Obstacle[] {
                new Water(20),
                new Wall(2),
                new Cross(30),
        });

        course.doIt(team);

    }
}
