package by.epam.training.entity;

import by.epam.training.generator.IdGenerator;

public class Point {
    private long pointId;
    private final int x;
    private final int y;
    private final int z;

    public Point(int x, int y, int z) {
        this.pointId = IdGenerator.generateId();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public long getPointId() {
        return pointId;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Point)) {
            return false;
        }
        final Point otherPoint = (Point) other;
        return /*pointId == otherPoint.pointId &&*/
                x == otherPoint.x &&
                y == otherPoint.y &&
                z == otherPoint.z;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        result = prime * result + z;
        /*result = (int) (prime * result + pointId);*/
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Point{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", z=").append(z);
        sb.append(", pointId=").append(pointId);
        sb.append('}');
        return sb.toString();
    }
}
