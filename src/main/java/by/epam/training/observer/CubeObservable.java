package by.epam.training.observer;

import by.epam.training.service.ServiceException;

public interface CubeObservable {
    void attach(CubeObserver observer);

    void detach(CubeObserver observer);

    void notifyObservers() throws ServiceException;
}
