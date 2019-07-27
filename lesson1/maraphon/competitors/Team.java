package maraphon.competitors;

import lesson1.maraphon.obstacles.Obstacle;

public class Team implements lesson1.maraphon.competitors.Competitor{
    String title;
    lesson1.maraphon.competitors.Competitor[] competitors;

    public Team(String title, lesson1.maraphon.competitors.Competitor[] competitors)
    {
        this.title = title;
        this.competitors = competitors;
    }

    public void infoWhoDone()
    {
        for (lesson1.maraphon.competitors.Competitor c:competitors)
        {
            if(c.isDistance())
            {
                System.out.printf("Команда " + title + " ");
                c.info();
            }
        }
    }

    @Override
    public void run(int dist) {
        for (lesson1.maraphon.competitors.Competitor c:competitors)
        {
            System.out.printf("Команда " + title + " ");
            c.run(dist);
        }
    }

    @Override
    public void jump(int height) {
        for (lesson1.maraphon.competitors.Competitor c:competitors)
        {
            System.out.printf("Команда " + title + " ");
            c.jump(height);
        }
    }

    @Override
    public void swim(int dist) {
        for (lesson1.maraphon.competitors.Competitor c:competitors)
        {
            System.out.printf("Команда " + title + " ");
            c.swim(dist);
        }
    }

    @Override
    public boolean isDistance() {
        for (lesson1.maraphon.competitors.Competitor c:competitors)
        {
            if(!c.isDistance())
                return false;
        }
        return true;
    }

    @Override
    public void info() {
        System.out.println("Команда " + title +" На дистанции: " + isDistance());
    }
}
