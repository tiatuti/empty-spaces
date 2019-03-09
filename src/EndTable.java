public class EndTable extends Table {
    static char icon = 'e';
    static boolean isSittable = false;

    public EndTable(Coordinates coordinates) {
        super(coordinates, icon, EndTable.isSittable);
    }

    public EndTable(int x, int y) {
        super(new Coordinates(x, y), EndTable.icon, EndTable.isSittable);

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