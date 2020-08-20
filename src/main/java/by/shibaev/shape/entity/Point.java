package by.shibaev.shape.entity;

public class Point {
    private int xPosition;
    private int yPosition;
    private int zPosition;

    public Point(int xPosition, int yPosition, int zPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.zPosition = zPosition;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getzPosition() {
        return zPosition;
    }

    public void setzPosition(int zPosition) {
        this.zPosition = zPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (xPosition != point.xPosition) return false;
        if (yPosition != point.yPosition) return false;
        return zPosition == point.zPosition;
    }

    @Override
    public int hashCode() {
        int result = xPosition;
        result = 31 * result + yPosition;
        result = 31 * result + zPosition;
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Point{");
        sb.append(xPosition).append(", ");
        sb.append(yPosition).append(", ");
        sb.append(zPosition);
        sb.append('}');
        return sb.toString();
    }
}
