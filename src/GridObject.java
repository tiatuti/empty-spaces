public class GridObject {
    Coordinates coordinates = new Coordinates(-1, -1);
    char icon;

    public GridObject(Coordinates coordinates, char icon) {
        this.coordinates = coordinates;
        this.icon = icon;
    }

    public GridObject(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getX() {
        return this.coordinates.x;
    }

    public int getY() {
        return this.coordinates.y;
    }

    public void setX(int x) {
        this.coordinates.x = x;
    }

    public void setY(int y) {
        this.coordinates.y = y;
    }

    public char getIcon() {
        return icon;
    }
}