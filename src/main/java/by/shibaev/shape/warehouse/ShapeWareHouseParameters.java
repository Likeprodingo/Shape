package by.shibaev.shape.warehouse;

public class ShapeWareHouseParameters {
    private double volume;
    private double square;

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public ShapeWareHouseParameters(double volume, double square) {
        this.volume = volume;
        this.square = square;
    }
}
