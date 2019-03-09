
public class Furniture extends GridObject {
    int width;
    int length;
    Direction direction;
    static char icon = 'F';

    // public Furniture(int width, int length, coordinate coordinates, Direction direction) {
    //     this.width = width;
    //     this.length = length;
    //     this.coordinates = coordinates;
    //     this.direction = direction;
    // }

    public Furniture(Coordinates coordinates) {
        super(coordinates, Furniture.icon);
    }

    public Furniture(int x, int y) {
        super(new Coordinates(x, y), Furniture.icon); 
    }

    public Furniture(Coordinates coordinates, char icon) {
        super(coordinates, icon);
    }

    public Furniture(int x, int y, char icon) {
        super(new Coordinates(x, y), icon); 
    }
    
    //TODO implement the change direction and location methods
}
