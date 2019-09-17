package by.epam.training.presentation;

import by.epam.training.entity.Cube;
import by.epam.training.entity.EntityException;
import by.epam.training.service.CubeService;
import by.epam.training.service.ServiceException;
import by.epam.training.service.cube_from_file.CubeFromFile;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        CubeService cubeService = CubeService.get();
        try {
            Cube cube = CubeFromFile.createCube("/data/data.txt");
            Cube bigCube = CubeFromFile.createCube("/data/data1.txt");
            log.info(cubeService.calculateEdge(cube));
            log.info(cubeService.calculateEdge(bigCube));
            //boolean suitable = CoordinateValidator.validate("0,0,0; 0,0,1; 0,1,0; 0,1,1; 1,0,0; 1,0,1; 1,1,0; 1,1,1");
            //System.out.println(suitable);
        } catch (ServiceException | EntityException e) {
            e.printStackTrace();
        }
    }
}
