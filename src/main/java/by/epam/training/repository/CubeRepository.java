package by.epam.training.repository;

import by.epam.training.entity.Cube;
import by.epam.training.specification.CubeSpecification;

import java.util.Comparator;
import java.util.List;

public interface CubeRepository<T> {

    void addCube(T object);

    void removeCube(T object);

    void updateCube(T object);

    List<T> sortCube(Comparator cubeSortComparator);

    List<Cube> query(CubeSpecification cubeSpecification);
}
