package by.epam.training.observer;

import by.epam.training.service.ServiceException;

public interface CubeObserver {
    void cubeUpdate(CubeEvent cubeEvent) throws ServiceException;
}
