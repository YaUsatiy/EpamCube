package by.epam.training.entity;

import by.epam.training.generator.IdGenerator;
import by.epam.training.observer.CubeEvent;
import by.epam.training.observer.CubeObservable;
import by.epam.training.observer.CubeObserver;
import by.epam.training.service.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class Cube implements CubeObservable {
    private long cubeId;
    private List<Point> points;
    private static final int CUBE_POINTS_COUNT = 8;
    private List<CubeObserver> observerList = new ArrayList<>();

    public Cube(List<Point> points) {
        this.cubeId = IdGenerator.generateId();
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public long getCubeId() {
        return cubeId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cube{");
        sb.append(", cubeId=").append(cubeId);
        sb.append("points=");
        for (Point point : points) {
            sb.append(point.toString());
        }
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Cube)) {
            return false;
        }
        final Cube otherCube = (Cube) other;
        /*if (getCubeId() != otherCube.getCubeId()) return false;*/
        int counter = 0;
        for (Point point : points) {
            for (Point otherPoint : otherCube.getPoints()) {
                if (point.equals(otherPoint)) {
                    counter++;
                }
            }
        }
        return (counter == CUBE_POINTS_COUNT);
    }

    @Override
    public int hashCode() {
        int result = 1;
        int prime = 31;
        for (Point point : points) {
            result += point.hashCode();
        }
        /*result = (int) (prime * result + cubeId);*/
        return result;
    }

    @Override
    public void attach(CubeObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(CubeObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() throws ServiceException {
        for (CubeObserver cubeObserver : observerList) {
            cubeObserver.cubeUpdate(new CubeEvent(this));
        }
    }
}
