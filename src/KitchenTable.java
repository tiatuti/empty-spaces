public class KitchenTable extends Table {
    static char icon = 'K';
    static boolean isSittable = true;

    public KitchenTable(Coordinates coordinates) {
        super(coordinates, icon, isSittable);
    }

    public KitchenTable(int x, int y) {
        super(new Coordinates(x, y), icon, isSittable);

    }

    // public Table(Coordinates coordinates, char icon, boolean isSittable) {
    //     super(coordinates, icon);
    //     this.isSittable = isSittable;
    // }

    // public Table(int x, int y, char icon, boolean isSittable) {
    //     super(new Coordinates(x, y), icon);
    //     this.isSittable = isSittable; 
    // }
}