package maraphon.obstacles;

import lesson1.maraphon.competitors.Competitor;

public class Course  extends lesson1.maraphon.obstacles.Obstacle {

    lesson1.maraphon.obstacles.Obstacle[] obstacles;

    public Course(lesson1.maraphon.obstacles.Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    @Override
    public void doIt(Competitor competitor) {
        System.out.println("Полоса препятствий start");
        for (lesson1.maraphon.obstacles.Obstacle o:obstacles)
        {
            o.doIt(competitor);
        }
        System.out.println("Полоса препятствий finish");
    }
}
