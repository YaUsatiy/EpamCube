package by.epam.training.service;

import by.epam.training.entity.CoordinatePlane;
import by.epam.training.entity.Cube;
import by.epam.training.entity.EntityException;
import by.epam.training.entity.Point;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class CoordinatePlaneService {
    private static final Logger log = LogManager.getLogger(CoordinatePlaneService.class);
    private static CoordinatePlaneService instance = new CoordinatePlaneService();
    public static CoordinatePlaneService get() {
        return instance;
    }

    private CoordinatePlaneService() {
    }

    public boolean isBaseCubeOnPlane(Cube cube, CoordinatePlane plane) {
        List<Point> cubePoints = cube.getPoints();
        List<Point> planePoints = plane.getPoints();
        int res = 0;
        for (Point cubePoint : cubePoints) {
            for (Point planePoint : planePoints) {
                if ((planePoint.getX() == cubePoint.getX() && planePoint.getY() == cubePoint.getY())
                        || (planePoint.getY() == cubePoint.getY() && planePoint.getZ() == cubePoint.getZ())
                        || (planePoint.getZ() == cubePoint.getZ() && planePoint.getX() == cubePoint.getX())) {
                    res++;
                }
            }
        }
        return (res != 0);
    }

    private int getPositivePartVolume(Cube cube) throws EntityException, ServiceException {             //по оси Oz (вертикали)
        CubeService cubeService = CubeService.get();
        int positiveZ = Integer.MIN_VALUE;
        for (Point cubePoint : cube.getPoints()) {
            if (cubePoint.getZ() > 0) {
                positiveZ = cubePoint.getZ();
                break;
            }
        }
        int positiveVolume;
        if (positiveZ != Integer.MIN_VALUE) {
            positiveVolume = (int) (Math.pow(cubeService.calculateEdge(cube),2) * positiveZ);
        }
        else {
            log.error("CUBE IS BELOW OZ AXIS");
            throw new EntityException("CUBE IS BELOW OZ AXIS");
        }
        return positiveVolume;
    }

    private int getNegativePartVolume(Cube cube) throws EntityException, ServiceException {             //по оси Oz (вертикали)
        CubeService cubeService = CubeService.get();
        int negativeZ = Integer.MAX_VALUE;
        for (Point cubePoint : cube.getPoints()) {
            if (cubePoint.getZ() < 0) {
                negativeZ = cubePoint.getZ();
                break;
            }
        }
        int negativeVolume;
        if (negativeZ != Integer.MAX_VALUE) {
            negativeVolume = (int) (Math.pow(cubeService.calculateEdge(cube),2) * negativeZ * (-1));
        }
        else {
            log.error("CUBE IS ABOVE OZ AXIS");
            throw new EntityException("CUBE IS ABOVE OZ AXIS");
        }
        return negativeVolume;
    }

    public double getVolumeRatio(Cube cube) throws EntityException, ServiceException {
        return getPositivePartVolume(cube)*1.0 / getNegativePartVolume(cube)*1.0;
    }
}

