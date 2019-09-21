package by.epam.training.service.cube_from_file;

import by.epam.training.entity.Cube;
import by.epam.training.entity.Point;
import by.epam.training.service.ServiceException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CubeFromFileTest {

    @Test
    public void createCube1() throws ServiceException {
        Cube actualCube = CubeFromFile.createCube("/testData/testData.txt");
        Cube expectedCube = new Cube(Arrays.asList(
                new Point(0,0,0), new Point(0,0,1),
                new Point(0,1,0), new Point(0,1,1),
                new Point(1,0,0), new Point(1,0,1),
                new Point(1,1,0), new Point(1,1,1)
        ));
        Assert.assertEquals(expectedCube, actualCube);
    }

    @Test
    public void createCube2() throws ServiceException {
        Cube actualCube = CubeFromFile.createCube("/testData/testData2.txt");
        Cube expectedCube = new Cube(Arrays.asList(
                new Point(0,0,4), new Point(5,0,4),
                new Point(5,5,4), new Point(0,5,4),
                new Point(0,0,-1), new Point(5,0,-1),
                new Point(5,5,-1), new Point(0,5,-1)
        ));
        Assert.assertEquals(expectedCube, actualCube);
    }
}