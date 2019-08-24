package gois.study.tdjd.shipapp;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlanetSpec {

    private Planet planet;
    private final Point max = new Point(50, 50);
    private List<Point> obstacles;

    @Before
    public void beforeTest() {
        obstacles = new ArrayList<Point>();
        obstacles.add(new Point(12, 13));
        obstacles.add(new Point(16, 32));
        planet = new Planet(max, obstacles);
    }

    @Test
    public void whenInstantiatedThenMaxIsSet() {
        assertEquals(planet.getMax(), max);
    }

    @Test
    public void whenInstantiatedThenObstaclesAreSet() {
        assertEquals(planet.getObstacles(), obstacles);
    }

}
