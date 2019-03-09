public class Window extends GridObject {
    static char icon = 'w';
    
    public Window(Coordinates coordinates) {
        super(coordinates, icon);
    }

    public Window(int x, int y) {
        super(new Coordinates(x, y), icon);
    }
}