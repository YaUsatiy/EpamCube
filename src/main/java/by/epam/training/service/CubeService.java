package by.epam.training.service;

import by.epam.training.entity.Cube;
import by.epam.training.entity.EntityException;
import by.epam.training.entity.Point;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class CubeService {
    private static final Logger log = LogManager.getLogger(CubeService.class);
    private static CubeService instance = new CubeService();
    private static final int CUBE_POINTS_COUNT = 8;
    private static final int SAME_AXIS_COORDINATE_COUNT = 4;
    private static final int CUBE_PLANE_COUNT = 6;
    private static final int CUBE_RIB_COUNT = 12;

    private CubeService() {
    }

    public static CubeService get() {
        return instance;
    }

    public boolean isCube(Cube cube) throws EntityException {
        List<Point> cubePoints = cube.getPoints();
        if (cubePoints.size() != CUBE_POINTS_COUNT) {
            log.error("INCORRECT NUMBER OF POINTS OF CUBE");
            throw new EntityException("INCORRECT NUMBER OF POINTS OF CUBE");
        }
        for (int i = 0; i < cubePoints.size(); i++) {
            int sameX = 1;
            int sameY = 1;
            int sameZ = 1;
            for (int j = 0; j < cubePoints.size(); j++) {
                if (i != j && cubePoints.get(i).getX() == cubePoints.get(j).getX()) {
                    sameX++;
                }
                if (i != j && cubePoints.get(i).getY() == cubePoints.get(j).getY()) {
                    sameY++;
                }
                if (i != j && cubePoints.get(i).getZ() == cubePoints.get(j).getZ()) {
                    sameZ++;
                }
            }
            if (!(sameX == sameY && sameY == sameZ && sameZ == SAME_AXIS_COORDINATE_COUNT)) {
                log.error("INCORRECT POINTS OF CUBE");
                return false;
            }
        }
        return true;
    }

    public int calculateEdge(Cube cube) throws ServiceException {
        List<Point> cubePoints = cube.getPoints();
        for (int j = 1; j < cubePoints.size(); j++) {
            if (cubePoints.get(0).getX() == cubePoints.get(j).getX() && cubePoints.get(0).getY() == cubePoints.get(j).getY()) {
                int a = cubePoints.get(0).getZ();
                int b = cubePoints.get(j).getZ();
                return Math.abs(a - b);
            }
        }
        throw new ServiceException("Can't calculate cube's edge");
    }

    public int calculateSurfaceArea(Cube cube) throws ServiceException {
        return (int) (CUBE_PLANE_COUNT * Math.pow(calculateEdge(cube), 2));
    }

    public int calculateVolume(Cube cube) throws ServiceException {
        return (int) Math.pow(calculateEdge(cube), 3);
    }

    public int calculatePerimeter(Cube cube) throws ServiceException {
        return CUBE_RIB_COUNT * calculateEdge(cube);
    }
}