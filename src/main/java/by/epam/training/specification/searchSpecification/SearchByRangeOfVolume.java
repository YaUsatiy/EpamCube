package by.epam.training.specification.searchSpecification;

import by.epam.training.entity.Cube;
import by.epam.training.service.CubeService;
import by.epam.training.service.ServiceException;
import by.epam.training.specification.CubeSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SearchByRangeOfVolume implements CubeSpecification<Cube> {
    private static final Logger log = LogManager.getLogger(SearchByRangeOfVolume.class);
    private int minVolume, maxVolume;
    private CubeService cubeService = CubeService.get();

    public SearchByRangeOfVolume(int minVolume, int maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specified(Cube object) {
        int cubeVolume = 0;
        try {
            cubeVolume = cubeService.calculateVolume(object);
        } catch (ServiceException e) {
            log.error("Error occurred during volume calculation");
            e.printStackTrace();
        }
        if (cubeVolume >= minVolume && cubeVolume <= maxVolume) {
            log.info("Search by range of volume is done!");
            return true;
        } else {
            log.info("Search by range of volume is not done!");
            return false;
        }
    }
}
