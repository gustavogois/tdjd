package gois.study.tdjd.shipapp;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LocationSpec {

    private final int x = 12;
    private final int y = 32;
    private final Direction direction = Direction.NORTH;
    private Point max;
    private Location location;
    private List<Point> obstacles;

    @Before
    public void beforeTest() {
        max = new Point(50, 50);
        location = new Location(new Point(x, y), direction);
        obstacles = new ArrayList<Point>();
    }

    @Test
    public void whenInstantiatedThenXIsStored() {
        assertEquals(location.getX(), x);
    }

    @Test
    public void whenInstantiatedThenYIsStored() {
        assertEquals(location.getY(), y);
    }

    @Test
    public void whenInstantiatedThenDirectionIsStored() {
        assertEquals(location.getDirection(), direction);
    }

    @Test
    public void givenDirectionNWhenForwardThenYDecreases() {
        location.forward(max, obstacles);
        assertEquals(location.getY(), y - 1);
    }

    @Test
    public void givenDirectionSWhenForwardThenYIncreases() {
        location.setDirection(Direction.SOUTH);
        location.forward(max, obstacles);
        assertEquals(location.getY(), y + 1);
    }

    @Test
    public void givenDirectionEWhenForwardThenXIncreases() {
        location.setDirection(Direction.EAST);
        location.forward(max, obstacles);
        assertEquals(location.getX(), x + 1);
    }

    @Test
    public void givenDirectionWWhenForwardThenXDecreases() {
        location.setDirection(Direction.WEST);
        location.forward(max, obstacles);
        assertEquals(location.getX(), x - 1);
    }

    @Test
    public void givenDirectionNWhenBackwardThenYIncreases() {
        location.setDirection(Direction.NORTH);
        location.backward(max, obstacles);
        assertEquals(location.getY(), y + 1);
    }

    @Test
    public void givenDirectionSWhenBackwardThenYDecreases() {
        location.setDirection(Direction.SOUTH);
        location.backward(max, obstacles);
        assertEquals(location.getY(), y - 1);
    }

    @Test
    public void givenDirectionEWhenBackwardThenXDecreases() {
        location.setDirection(Direction.EAST);
        location.backward(max, obstacles);
        assertEquals(location.getX(), x - 1);
    }

    @Test
    public void givenDirectionWWhenBackwardThenXIncreases() {
        location.setDirection(Direction.WEST);
        location.backward(max, obstacles);
        assertEquals(location.getX(), x + 1);
    }

    @Test
    public void whenTurnLeftThenDirectionIsSet() {
        location.turnLeft();
        assertEquals(location.getDirection(), Direction.WEST);
    }

    @Test
    public void whenTurnRightThenDirectionIsSet() {
        location.turnRight();
        assertEquals(location.getDirection(), Direction.EAST);
    }

    @Test
    public void givenSameObjectsWhenEqualsThenTrue() {
        assertTrue(location.equals(location));
    }

    @Test
    public void givenDifferentObjectWhenEqualsThenFalse() {
        assertFalse(location.equals("bla"));
    }

    @Test
    public void givenDifferentXWhenEqualsThenFalse() {
        Location locationCopy = new Location(new Point(999, location.getY()), location.getDirection());
        assertFalse(location.equals(locationCopy));
    }

    @Test
    public void givenDifferentYWhenEqualsThenFalse() {
        Location locationCopy = new Location(new Point(location.getX(), 999), location.getDirection());
        assertFalse(location.equals(locationCopy));
    }

    @Test
    public void givenDifferentDirectionWhenEqualsThenFalse() {
        Location locationCopy = new Location(location.getPoint(), Direction.SOUTH);
        assertFalse(location.equals(locationCopy));
    }

    @Test
    public void givenSameXYDirectionWhenEqualsThenTrue() {
        Location locationCopy = new Location(location.getPoint(), location.getDirection());
        assertTrue(location.equals(locationCopy));
    }

    @Test
    public void whenCopyThenDifferentObject() {
        Location copy = location.copy();
        assertNotSame(location, copy);
    }

    @Test
    public void whenCopyThenEquals() {
        Location copy = location.copy();
        assertEquals(copy, location);
    }

    @Test
    public void givenDirectionEAndXEqualsMaxXWhenForwardThen1() {
        location.setDirection(Direction.EAST);
        location.getPoint().setX(max.getX());
        location.forward(max, obstacles);
        assertEquals(location.getX(), 1);
    }

    @Test
    public void givenDirectionWAndXEquals1WhenForwardThenMaxX() {
        location.setDirection(Direction.WEST);
        location.getPoint().setX(1);
        location.forward(max, obstacles);
        assertEquals(location.getX(), max.getX());
    }

    @Test
    public void givenDirectionNAndYEquals1WhenForwardThenMaxY() {
        location.setDirection(Direction.NORTH);
        location.getPoint().setY(1);
        location.forward(max, obstacles);
        assertEquals(location.getY(), max.getY());
    }

    @Test
    public void givenDirectionSAndYEqualsMaxYWhenForwardThen1() {
        location.setDirection(Direction.SOUTH);
        location.getPoint().setY(max.getY());
        location.forward(max, obstacles);
        assertEquals(location.getY(), 1);
    }

    @Test
    public void givenObstacleWhenForwardThenReturnFalse() {
        location.setDirection(Direction.EAST);
        obstacles.add(new Point(x + 1, y));
        assertFalse(location.forward(max, obstacles));
    }

    @Test
    public void givenObstacleWhenBackwardThenReturnFalse() {
        location.setDirection(Direction.EAST);
        obstacles.add(new Point(x - 1, y));
        assertFalse(location.backward(max, obstacles));
    }

}
