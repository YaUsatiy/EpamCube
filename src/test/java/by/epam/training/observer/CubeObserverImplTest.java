package by.epam.training.observer;

import by.epam.training.entity.Cube;
import by.epam.training.entity.Point;
import by.epam.training.service.ServiceException;
import by.epam.training.warehouse.CubeWarehouse;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CubeObserverImplTest {

    @Test
    public void testCubeUpdate() throws ServiceException {
        Cube cube = new Cube(Arrays.asList(
                new Point(2, 0, 0), new Point(0, 0, 0),
                new Point(0, 2, 0), new Point(2, 2, 0),
                new Point(2, 0, 2), new Point(0, 0, 2),
                new Point(0, 2, 2), new Point(2, 2, 2)
        ));
        CubeObserver observer = new CubeObserverImpl();
        CubeEvent event = new CubeEvent(cube);
        observer.cubeUpdate(event);
        List<Integer> result = CubeWarehouse.getInstance().get(cube.getCubeId());
        int actualSize = result.size();
        int expectedSize = 4;
        assertEquals(expectedSize, actualSize);
    }
}