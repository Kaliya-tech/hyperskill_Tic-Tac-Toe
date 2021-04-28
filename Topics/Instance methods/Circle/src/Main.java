class Circle {

    double radius;

    public static double getLength () {
        return (radius * 2) * Math.PI;
    }

    public static double getArea () {
        return (radius * radius) * Math.PI;
    }

    public static void main(String[] args) {


        Circle c = new Circle();
        c.radius = 10.0;
        System.out.println(c.getLength());
        System.out.println(c.getArea());
    }

}
