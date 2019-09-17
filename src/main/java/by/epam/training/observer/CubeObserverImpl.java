package by.epam.training.observer;

import by.epam.training.entity.Cube;
import by.epam.training.service.CubeService;
import by.epam.training.service.ServiceException;
import by.epam.training.warehouse.CubeWarehouse;

import java.util.ArrayList;
import java.util.List;

public class CubeObserverImpl implements CubeObserver {
    @Override
    public void cubeUpdate(CubeEvent cubeEvent) throws ServiceException {
        Cube cube = cubeEvent.getSource();
        CubeService cubeService = CubeService.get();
        List<Integer> cubeParametersList = new ArrayList<>();
        cubeParametersList.add(cubeService.calculateSurfaceArea(cube));
        cubeParametersList.add(cubeService.calculateVolume(cube));
        cubeParametersList.add(cubeService.calculateEdge(cube));
        cubeParametersList.add(cubeService.calculatePerimeter(cube));
        CubeWarehouse.getInstance().put(cube.getCubeId(), cubeParametersList);
    }
}
