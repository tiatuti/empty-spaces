public class CoffeeTable extends Table {
    static char icon = 'c';
    static boolean isSittable = false;

    public CoffeeTable(Coordinates coordinates) {
        super(coordinates, icon, EndTable.isSittable);
    }

    public CoffeeTable(int x, int y) {
        super(new Coordinates(x, y), CoffeeTable.icon, EndTable.isSittable);

        // is this ok?

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