package lt.setkus.codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FreewayGameTest {

    @Test
    public void overtaker() {
        // I overtake some cars
        final int count = FreewayGame.freewayGame(50.0, 130.0, new double[][]{{-1.0, 120.0}, {-1.5, 120.0}});
        assertEquals(2, count);
    }

    @Test
    public void overtaken() {
        // Some cars overtake me
        final int count = FreewayGame.freewayGame(50.0, 110.0, new double[][]{{1.0, 120.0}, {1.5, 125.0}});
        assertEquals(-2, count);
    }

    @Test
    public void overtakeAndOvertaken() {
        // I overtake some cars and some cars overtake me. Overall count = 0
        final int count = FreewayGame.freewayGame(50.0, 120.0, new double[][]{{-1.0, 115.0}, {-1.5, 110.0},{1.0, 130.0}, {1.5, 130.0}});
        assertEquals(0, count);
    }

    @Test
    public void cantOvertakeFasterCars() {
        // All cars ahead of me are going faster
        final int count = FreewayGame.freewayGame(30.0, 100.0, new double[][]{{-1.0, 110.0}, {-0.7, 102.0}, {-1.5, 108.0}});
        assertEquals(0, count);
    }

    @Test
    public void cantBeOvertakenBySlowerCars() {
        // All cars behind me are going slower
        final int count = FreewayGame.freewayGame(30.0, 130.0, new double[][]{{1.0, 120.0}, {0.7, 125.0}, {1.5, 110.0}});
        assertEquals(0, count);
    }

    @Test
    public void randomFew() {
        final int count = FreewayGame.freewayGame(50.0, 130, new double[][]{
                {-1.9026147506714364, 121.87501793897707},
                {3.4233274804454155, 124.6059854966885},
                {2.070946870704061, 110.87104296270967},
                {-4.28920957127848, 114.47880300629306},
                {-4.624741939927466, 121.84264286008347}
        });
        assertEquals(0, count);
    }

    @Test
    public void besideMeAllTheWay() {
        final int count = FreewayGame.freewayGame(50, 110, new double[][]{{0.0, 110.0}});
        assertEquals(0, count);
    }

    @Test
    public void allSameSpeedAsMe() {
        final int count = FreewayGame.freewayGame(50.0, 110.0, new double[][]{
                {-1.0, 110.0},
                {0.5, 110.0},
                {1.0, 110.0},
                {1.5, 110.0}
        });
        assertEquals(0, count);
    }
}