package by.epam.training.repository;

import by.epam.training.entity.Cube;
import by.epam.training.specification.CubeSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CubeRepositoryImpl implements CubeRepository<Cube>{
    private static final Logger log = LogManager.getLogger(CubeRepositoryImpl.class);
    private static CubeRepositoryImpl instance;
    private Map<Long, Cube> cubeRepositoryMap = new HashMap<>();

    private CubeRepositoryImpl(){
    }

    public static CubeRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new CubeRepositoryImpl();
        }
        return instance;
    }

    public Map<Long, Cube> getCubeRepositoryMap() {
        return cubeRepositoryMap;
    }

    @Override
    public void addCube(Cube object) {
        cubeRepositoryMap.put(object.getCubeId(), object);
        log.info("Adding in repository is done" + object);
    }

    @Override
    public void removeCube(Cube object) {
        cubeRepositoryMap.remove(object.getCubeId(), object);
        log.info("Removing in repository is done" + object);
    }

    @Override
    public void updateCube(Cube object) {
        for (Map.Entry<Long, Cube> record : cubeRepositoryMap.entrySet()) {
            if (record.getKey().equals(object.getCubeId())) {
                cubeRepositoryMap.put(object.getCubeId(), object);
                log.info("Updating in repository is done" + object);
            }
        }
    }

    @Override
    public List<Cube> sortCube(Comparator cubeSortComparator) {
        return cubeRepositoryMap.values().stream().
                sorted((t1, t2) -> cubeSortComparator.compare(t1, t2)).
                collect(Collectors.toList());
    }

    @Override
    public List<Cube> query(CubeSpecification cubeSpecification) {
        return cubeRepositoryMap.values().stream().
                filter(o -> cubeSpecification.specified(o)).
                collect(Collectors.toList());
    }
}
