package by.epam.training.specification.sort_specification;

import by.epam.training.entity.Cube;
import by.epam.training.service.CubeService;
import by.epam.training.service.ServiceException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class SortByVolume implements Comparator<Cube> {
    private static final Logger log = LogManager.getLogger(SortByVolume.class);
    private CubeService cubeService = CubeService.get();
    private static final int LARGER = 1;
    private static final int LESS = -1;
    private static final int EQUALS = 0;

    @Override
    public int compare(Cube o1, Cube o2) {
        int firstVolume = 0;
        int secondVolume = 0;
        try {
            firstVolume = cubeService.calculateVolume(o1);
            secondVolume = cubeService.calculateVolume(o2);
        } catch (ServiceException e) {
            log.error("It is impossible to calculate cube's volume");
        }
        if (firstVolume < secondVolume) {
            log.info("Sort by id is done: first volume < second volume");
            return LESS;
        } else if (firstVolume > secondVolume) {
            log.info("Sort by id is done: first volume > second volume");
            return LARGER;
        } else {
            log.info("Sort by id is done: first volume = second volume");
            return EQUALS;
        }
    }
}
