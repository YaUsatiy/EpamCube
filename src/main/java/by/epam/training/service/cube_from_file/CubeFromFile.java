package by.epam.training.service.cube_from_file;

import by.epam.training.entity.Cube;
import by.epam.training.entity.Point;
import by.epam.training.service.ServiceException;
import by.epam.training.service.coordinate_parser.CoordinateParser;
import by.epam.training.service.coordinate_validator.CoordinateValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CubeFromFile {
    private static final String POINT_DELIMITER = ";\\s*";
    private static final String COORDINATE_DELIMITER = ",\\s*";
    private static final Logger log = LogManager.getLogger(CubeFromFile.class);

    public static Cube createCube(String pathToFile) throws ServiceException {
        CoordinateParser coordinateParser = new CoordinateParser();
        String coordinatesFromFile = coordinateParser.parse(pathToFile);
        if (!CoordinateValidator.validate(coordinatesFromFile)) {
            log.error("Coordinates are not valid!");
            throw new ServiceException("Coordinates are not valid!");
        }
        String[] points = coordinatesFromFile.split(POINT_DELIMITER);
        Point point1 = createPoint(points[0]);
        Point point2 = createPoint(points[1]);
        Point point3 = createPoint(points[2]);
        Point point4 = createPoint(points[3]);
        Point point5 = createPoint(points[4]);
        Point point6 = createPoint(points[5]);
        Point point7 = createPoint(points[6]);
        Point point8 = createPoint(points[7]);
        List<Point> pointsList = new ArrayList<>();
        pointsList.add(point1);
        pointsList.add(point2);
        pointsList.add(point3);
        pointsList.add(point4);
        pointsList.add(point5);
        pointsList.add(point6);
        pointsList.add(point7);
        pointsList.add(point8);
        return new Cube(pointsList);
    }

    private static Point createPoint(String points) {
        String[] coordinates = points.split(COORDINATE_DELIMITER);
        int coordinateX = Integer.parseInt(coordinates[0]);
        int coordinateY = Integer.parseInt(coordinates[1]);
        int coordinateZ = Integer.parseInt(coordinates[2]);
        return new Point(coordinateX, coordinateY, coordinateZ);
    }
}
