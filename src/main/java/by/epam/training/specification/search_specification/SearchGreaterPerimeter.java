package by.epam.training.specification.search_specification;

import by.epam.training.entity.Cube;
import by.epam.training.service.CubeService;
import by.epam.training.service.ServiceException;
import by.epam.training.specification.CubeSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SearchGreaterPerimeter implements CubeSpecification<Cube> {
    private static final Logger log = LogManager.getLogger(SearchGreaterPerimeter.class);
    private int perimeter;
    private CubeService cubeService = CubeService.get();

    public SearchGreaterPerimeter(int perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public boolean specified(Cube object) {
        int currentPerimeter = 0;
        try {
            currentPerimeter = cubeService.calculatePerimeter(object);
        } catch (ServiceException e) {
            log.error("Error occurred during perimeter calculation");
            e.printStackTrace();
        }
        if (currentPerimeter > perimeter) {
            log.info("Search by greater perimeter is done!");
            return true;
        } else {
            log.info("Search by greater perimeter is not done!");
            return false;
        }
    }
}
