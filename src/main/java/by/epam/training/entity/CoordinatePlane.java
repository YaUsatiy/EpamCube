package by.epam.training.entity;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class CoordinatePlane {
    private static final Logger log = LogManager.getLogger(CoordinatePlane.class);
    private List<Point> points;

    public CoordinatePlane(List<Point> points)  throws EntityException {
        if (points.size()!=3){
            log.error("INCORRECT POINTS OF PLANE");
            throw new EntityException("INCORRECT POINTS OF PLANE");
        }
        this.points=points;
    }

    public List<Point> getPoints() {
        return points;
    }
}