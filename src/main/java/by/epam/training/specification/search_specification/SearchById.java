package by.epam.training.specification.search_specification;

import by.epam.training.entity.Cube;
import by.epam.training.specification.CubeSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SearchById implements CubeSpecification<Cube> {
    private static final Logger log = LogManager.getLogger(SearchById.class);
    private long id;

    public SearchById(long id) {
        this.id = id;
    }

    @Override
    public boolean specified(Cube object) {
        if (id == object.getCubeId()) {
            log.info("Search by id is done!");
            return true;
        } else {
            log.warn("Search by id is not done!");
            return false;
        }
    }
}
