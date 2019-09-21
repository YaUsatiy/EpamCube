package by.epam.training.specification.sort_specification;

import by.epam.training.entity.Cube;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class SortById implements Comparator<Cube> {
    private static final Logger log = LogManager.getLogger(SortById.class);
    public static final int LARGER = 1;
    public static final int LESS = -1;
    public static final int EQUALS = 0;

    @Override
    public int compare(Cube o1, Cube o2) {
        long firstId = o1.getCubeId();
        long secondId = o2.getCubeId();
        if (firstId < secondId) {
            log.info("Sort by id is done: first id < second id");
            return LESS;
        } else if (firstId > secondId) {
            log.info("Sort by id is done: first id > second id");
            return LARGER;
        } else {
            log.info("Sort by id is done: first id = second id");
            return EQUALS;
        }
    }
}
