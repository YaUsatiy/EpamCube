package by.epam.training.presentation;

import by.epam.training.entity.Cube;
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
            Cube bigCube = CubeFromFile.createCube("/data/data2.txt");
            log.info(cubeService.calculateEdge(cube));
            log.info(cubeService.calculateEdge(bigCube));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
