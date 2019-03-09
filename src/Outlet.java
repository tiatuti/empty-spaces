public class Outlet extends GridObject {
    
    static char icon = 'o';
    
    public Outlet(Coordinates coordinates) {
        super(coordinates, icon);
    }

    public Outlet(int x, int y) {
        super(new Coordinates(x, y), icon);
    }
}