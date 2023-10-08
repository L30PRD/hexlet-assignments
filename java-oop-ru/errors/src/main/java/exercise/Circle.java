package exercise;

// BEGIN
class Circle {
    Point point;
    int radius;

    public Circle(Point point, Integer radius) {
        this.point = point;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (getRadius() < 0) {
            throw  new NegativeRadiusException("Не удалось посчитать площадь");
        }
        return getRadius() * getRadius() * Math.PI;
    }
}
// END
