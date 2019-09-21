package by.epam.training.specification.sort_specification;

import by.epam.training.entity.Cube;
import by.epam.training.entity.Point;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;


public class SortSpecificationTest {
    private static final int LARGER = 1;
    private static final int LESS = -1;
    private static final int EQUALS = 0;

    @DataProvider
    public Object[][] sortByVolumeTest() {
        return new Object[][]{
                {new Cube(Arrays.asList(
                        new Point(2, 0, 0), new Point(0, 0, 0),
                        new Point(0, 2, 0), new Point(2, 2, 0),
                        new Point(2, 0, 2), new Point(0, 0, 2),
                        new Point(0, 2, 2), new Point(2, 2, 2)
                )), new Cube(Arrays.asList(
                        new Point(2, 0, 0), new Point(0, 0, 0),
                        new Point(0, 2, 0), new Point(2, 2, 0),
                        new Point(2, 0, 2), new Point(0, 0, 2),
                        new Point(0, 2, 2), new Point(2, 2, 2)
                )), EQUALS},
                {new Cube(Arrays.asList(
                        new Point(2, 0, 0), new Point(0, 0, 0),
                        new Point(0, 2, 0), new Point(2, 2, 0),
                        new Point(2, 0, 2), new Point(0, 0, 2),
                        new Point(0, 2, 2), new Point(2, 2, 2)
                )), new Cube(Arrays.asList(
                        new Point(3, 0, 3), new Point(0, 0, 3),
                        new Point(0, 3, 3), new Point(3, 3, 3),
                        new Point(3, 0, 6), new Point(0, 0, 6),
                        new Point(0, 3, 6), new Point(3, 3, 6)
                )), LESS},
                {new Cube(Arrays.asList(
                        new Point(3, 0, 3), new Point(0, 0, 3),
                        new Point(0, 3, 3), new Point(3, 3, 3),
                        new Point(3, 0, 6), new Point(0, 0, 6),
                        new Point(0, 3, 6), new Point(3, 3, 6)
                )), new Cube(Arrays.asList(
                        new Point(2, 0, 0), new Point(0, 0, 0),
                        new Point(0, 2, 0), new Point(2, 2, 0),
                        new Point(2, 0, 2), new Point(0, 0, 2),
                        new Point(0, 2, 2), new Point(2, 2, 2)
                )), LARGER}};
    }

    @DataProvider
    public Object[][] sortByIdTest() {
        return new Object[][]{
                {new Cube(Arrays.asList(
                        new Point(2, 0, 0), new Point(0, 0, 0),
                        new Point(0, 2, 0), new Point(2, 2, 0),
                        new Point(2, 0, 2), new Point(0, 0, 2),
                        new Point(0, 2, 2), new Point(2, 2, 2)
                )), new Cube(Arrays.asList(
                        new Point(2, 0, 0), new Point(0, 0, 0),
                        new Point(0, 2, 0), new Point(2, 2, 0),
                        new Point(2, 0, 2), new Point(0, 0, 2),
                        new Point(0, 2, 2), new Point(2, 2, 2)
                ))},
                {new Cube(Arrays.asList(
                        new Point(2, 0, 0), new Point(0, 0, 0),
                        new Point(0, 2, 0), new Point(2, 2, 0),
                        new Point(2, 0, 2), new Point(0, 0, 2),
                        new Point(0, 2, 2), new Point(2, 2, 2)
                )), new Cube(Arrays.asList(
                        new Point(3, 0, 3), new Point(0, 0, 3),
                        new Point(0, 3, 3), new Point(3, 3, 3),
                        new Point(3, 0, 6), new Point(0, 0, 6),
                        new Point(0, 3, 6), new Point(3, 3, 6)
                ))},
                {new Cube(Arrays.asList(
                        new Point(3, 0, 3), new Point(0, 0, 3),
                        new Point(0, 3, 3), new Point(3, 3, 3),
                        new Point(3, 0, 6), new Point(0, 0, 6),
                        new Point(0, 3, 6), new Point(3, 3, 6)
                )), new Cube(Arrays.asList(
                        new Point(2, 0, 0), new Point(0, 0, 0),
                        new Point(0, 2, 0), new Point(2, 2, 0),
                        new Point(2, 0, 2), new Point(0, 0, 2),
                        new Point(0, 2, 2), new Point(2, 2, 2)
                ))}
        };
    }

    @Test(dataProvider = "sortByIdTest")
    public void sortByIdTest(Cube first, Cube second) {
        SortById sortById = new SortById();
        int result = sortById.compare(first, second);
        Assert.assertEquals(result, LESS);
    }

    @Test(dataProvider = "sortByVolumeTest")
    public void sortByVolumeTest(Cube first, Cube second, int comparison) {
        SortByVolume sortByVolume = new SortByVolume();
        int result = sortByVolume.compare(first, second);
        Assert.assertEquals(result, comparison);
    }

}