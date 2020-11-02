public class Distance {
    static class Coord {
        double x, y;

        Coord(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final Coord[] coords = new Coord[]{
        // Place your coordinates here...
    };

    public static void main(String[] args) {
        Coord c = GetLocation(); // place the distances here
        System.out.println("The phone coordinate is: [" + c.x + ", " + c.y + "]");
    }

    private static Coord GetLocation(double... distances) {
        // Here goes some math that manipulates distances and the coords array somehow
        // Return the coordinate where the phone is located
        return new Coord(0.0, 0.0);
    }
}
