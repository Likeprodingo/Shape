package by.shibaev.shape.entity;


import by.shibaev.shape.entity.shape.Sphere;

public enum ShapeType {
    Sphere("s") {
        public Shape createSphere(int id, double radius, int x, int y, int z) {
            return new Sphere(new Point(x, y, z), radius, id);
        }
    };
    private String name;

    ShapeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
