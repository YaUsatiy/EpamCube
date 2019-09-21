package by.epam.training.repository;

import by.epam.training.entity.Cube;
import by.epam.training.specification.CubeSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class CubeRepositoryImpl implements CubeRepository<Cube>{
    private static final Logger log = LogManager.getLogger(CubeRepositoryImpl.class);
    private static CubeRepositoryImpl instance;
    private List<Cube> cubeRepositoryList = new ArrayList<>();

    private CubeRepositoryImpl(){
    }

    public static CubeRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new CubeRepositoryImpl();
        }
        return instance;
    }

    public List<Cube> getCubeRepositoryList() {
        return cubeRepositoryList;
    }

    @Override
    public void addCube(Cube cube) {
        cubeRepositoryList.add(cube);
        log.info("Adding in repository is done" + cube);
    }

    @Override
    public void removeCube(Cube cube) {
        cubeRepositoryList.remove(cube);
        log.info("Removing in repository is done" + cube);
    }

    @Override
    public void updateCube(Cube cube) {
        for (Cube cubeFromRepository : cubeRepositoryList) {
            if (cubeFromRepository.getCubeId() == cube.getCubeId()) {
                int index = cubeRepositoryList.indexOf(cubeFromRepository);
                cubeRepositoryList.set(index, cube);
            }
        }
    }

    @Override
    public List<Cube> sortCube(Comparator cubeSortComparator) {
        return cubeRepositoryList.stream().
                sorted((t1, t2) -> cubeSortComparator.compare(t1, t2)).
                collect(Collectors.toList());
    }

    @Override
    public List<Cube> query(CubeSpecification cubeSpecification) {
        return cubeRepositoryList.stream().
                filter(o -> cubeSpecification.specified(o)).
                collect(Collectors.toList());
    }
}
