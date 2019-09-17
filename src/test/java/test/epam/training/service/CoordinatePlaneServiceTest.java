package test.epam.training.service;

import by.epam.training.entity.CoordinatePlane;
import by.epam.training.entity.Cube;
import by.epam.training.entity.EntityException;
import by.epam.training.entity.Point;
import by.epam.training.service.CoordinatePlaneService;
import by.epam.training.service.ServiceException;
import by.epam.training.service.cube_from_file.CubeFromFile;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CoordinatePlaneServiceTest {

    private CoordinatePlaneService coordinatePlaneService;
    private Cube cube;
    private Cube bigCube;
    private CoordinatePlane coordinatePlane;

    @Before
    public void setUp() throws EntityException, ServiceException {
        coordinatePlaneService = CoordinatePlaneService.get();
        cube = CubeFromFile.createCube("/testData/testData.txt");
        bigCube = CubeFromFile.createCube("/testData/testData1.txt");
        List<Point> coordinatePlanePoints = new ArrayList<>();
        Point point1 = new Point(0, 0, 0);
        Point point2 = new Point(1, 0, 0);
        Point point3 = new Point(0, 1, 0);
        coordinatePlanePoints.add(point1);
        coordinatePlanePoints.add(point2);
        coordinatePlanePoints.add(point3);
        coordinatePlane = new CoordinatePlane(coordinatePlanePoints);
    }

    @Test
    public void testIsBaseCubeOnPlane() {
        boolean actualValue = coordinatePlaneService.isBaseCubeOnPlane(cube, coordinatePlane);
        assertTrue(actualValue);
    }

    @Test(expected = EntityException.class)
    public void testVolumeRatio1() throws EntityException {
        try {
            coordinatePlaneService.getVolumeRatio(cube);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testVolumeRatio2() throws EntityException, ServiceException {
        double actualVolumeRatio = coordinatePlaneService.getVolumeRatio(bigCube);
        double expectedVolumeRatio = 4.0;
        assertEquals(0, Double.compare(actualVolumeRatio, expectedVolumeRatio));
    }
}