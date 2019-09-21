package by.epam.training.specification.search_specification;

import by.epam.training.entity.Cube;
import by.epam.training.entity.Point;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SearchSpecificationTest {
    private static Cube CUBE;

    @BeforeClass
    public static void setUp() {
        CUBE = new Cube(Arrays.asList(                     //a = 2, V = 8, S = 24, P = 24
                new Point(2, 0, 0), new Point(0, 0, 0),
                new Point(0, 2, 0), new Point(2, 2, 0),
                new Point(2, 0, 2), new Point(0, 0, 2),
                new Point(0, 2, 2), new Point(2, 2, 2)
        ));
    }

    @Test
    public void SearchByIdPositiveTest() {
        SearchById searchById = new SearchById(9);
        boolean result = searchById.specified(CUBE);
        System.out.println(CUBE.toString());
        assertTrue(result);
    }

    @Test
    public void searchByIdNegativeTest() {
        SearchById searchById = new SearchById(1);
        boolean result = searchById.specified(CUBE);
        assertFalse(result);
    }

    @Test
    public void searchByRangeOfAreaPositiveTest() {
        SearchByRangeOfArea searchByRangeOfArea = new SearchByRangeOfArea(20, 30);
        boolean result = searchByRangeOfArea.specified(CUBE);
        assertTrue(result);
    }

    @Test
    public void searchByRangeOfAreaNegativeTest() {
        SearchByRangeOfArea searchByRangeOfArea = new SearchByRangeOfArea(1, 15);
        boolean result = searchByRangeOfArea.specified(CUBE);
        assertFalse(result);
    }

    @Test
    public void searchByRangeOfVolumePositiveTest() {
        SearchByRangeOfVolume searchByRangeOfVolume = new SearchByRangeOfVolume(7, 9);
        boolean result = searchByRangeOfVolume.specified(CUBE);
        assertTrue(result);
    }

    @Test
    public void searchByRangeOfVolumeNegativeTest() {
        SearchByRangeOfVolume searchByRangeOfVolume = new SearchByRangeOfVolume(1, 4);
        boolean result = searchByRangeOfVolume.specified(CUBE);
        assertFalse(result);
    }

    @Test
    public void searchByGreaterVolumePositiveTest() {
        SearchGreaterPerimeter searchGreaterPerimeter = new SearchGreaterPerimeter(23);
        boolean result = searchGreaterPerimeter.specified(CUBE);
        assertTrue(result);
    }

    @Test
    public void searchByGreaterVolumeNegativeTest() {
        SearchGreaterPerimeter searchGreaterPerimeter = new SearchGreaterPerimeter(25);
        boolean result = searchGreaterPerimeter.specified(CUBE);
        assertFalse(result);
    }

}