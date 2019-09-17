package by.epam.training.specification.searchSpecification;

import by.epam.training.entity.Cube;
import by.epam.training.service.CubeService;
import by.epam.training.service.ServiceException;
import by.epam.training.specification.CubeSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SearchByRangeOfArea implements CubeSpecification<Cube> {
    private static final Logger log = LogManager.getLogger(SearchById.class);
    private int minArea, maxArea;
    private CubeService cubeService = CubeService.get();

    public SearchByRangeOfArea(int minArea, int maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specified(Cube object) {
        int cubeArea = 0;
        try {
            cubeArea = cubeService.calculateSurfaceArea(object);
        } catch (ServiceException e) {
            log.error("Error occurred during surface area calculation");
            e.printStackTrace();
        }
        if (cubeArea >= minArea && cubeArea <= maxArea) {
            log.info("Search by range of surface area is done!");
            return true;
        } else {
            log.info("Search by range of surface area is not done!");
            return false;
        }
    }
}
