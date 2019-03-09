public class TV extends Furniture {
    static char icon = 'V';
    boolean isSittable = false;

    public TV(Coordinates coordinates, boolean isSittable){
        super(coordinates, TV.icon);
        this.isSittable = isSittable;
    }
    public TV(int x, int y, boolean isSittable) {
        super(new Coordinates(x, y), TV.icon);
        this.isSittable = isSittable;
    }

    public TV(Coordinates coordinates, char icon, boolean isSittable) {
        super(coordinates, icon);
        this.isSittable = isSittable;
    }

    public TV(int x, int y, char icon, boolean isSittable) {
        super(new Coordinates(x, y), icon);
        this.isSittable = isSittable;
    }
}
