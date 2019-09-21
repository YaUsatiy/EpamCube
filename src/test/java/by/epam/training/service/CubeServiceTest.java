package by.epam.training.service;

import by.epam.training.entity.Cube;
import by.epam.training.entity.EntityException;
import by.epam.training.service.cube_from_file.CubeFromFile;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CubeServiceTest {
    private static CubeService cubeService;
    private static Cube cube;

    @BeforeClass
    public static void setUp() throws ServiceException {
        cubeService = CubeService.get();
        cube = CubeFromFile.createCube("/testData/testData.txt");
    }

    @Test
    public void testCalculateSurfaceArea() throws ServiceException {
        int actualArea = cubeService.calculateSurfaceArea(cube);
        int expectedArea = 6;
        assertEquals(expectedArea, actualArea);
    }

    @Test
    public void testCalculateVolume() throws ServiceException {
        int actualVolume = cubeService.calculateVolume(cube);
        int expectedVolume = 1;
        assertEquals(expectedVolume, actualVolume);
    }

    @Test
    public void testIsCube() throws EntityException {
        boolean actualValue = cubeService.isCube(cube);
        assertTrue(actualValue);
    }

    @Test
    public void testCalculateEdge() throws ServiceException {
        int actualEdge = cubeService.calculateEdge(cube);
        int expectedEdge = 1;
        assertEquals(expectedEdge, actualEdge);
    }

    @Test
    public void testCalculatePerimeter() throws ServiceException {
        int actualPerimeter = cubeService.calculatePerimeter(cube);
        int expectedPerimeter = 12;
        assertEquals(expectedPerimeter, actualPerimeter);
    }
}
