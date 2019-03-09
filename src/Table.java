public class Table extends Furniture {
    static char icon = 'T';
    boolean isSittable = true;

    public Table(Coordinates coordinates, boolean isSittable) {
        super(coordinates, Table.icon);
        this.isSittable = isSittable;
    }

    public Table(int x, int y, boolean isSittable) {
        super(new Coordinates(x, y), Table.icon);
        this.isSittable = isSittable;
    }

    public Table(Coordinates coordinates, char icon, boolean isSittable) {
        super(coordinates, icon);
        this.isSittable = isSittable;
    }

    public Table(int x, int y, char icon, boolean isSittable) {
        super(new Coordinates(x, y), icon);
        this.isSittable = isSittable; 
    }
}