public class Coordinates {
    int x;
    int y;

    public Coordinates() {
        this(0, 0);
    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the coordinates for something that's just one below
     */
    public Coordinates getOneBelow() {
        return new Coordinates(x + 1, y);
    }

    public Coordinates getOneAbove() {
        return new Coordinates(x - 1, y);    
    }

}
