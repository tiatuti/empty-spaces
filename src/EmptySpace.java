public class EmptySpace extends Furniture {
    static char icon = '`';
    boolean isSittable = false;

    public EmptySpace(Coordinates coordinates, boolean isSittable){
        super(coordinates, EmptySpace.icon);
        this.isSittable = isSittable;
    }
    public EmptySpace(int x, int y, boolean isSittable) {
        super(new Coordinates(x, y), EmptySpace.icon);
        this.isSittable = isSittable;
    }

    public EmptySpace(Coordinates coordinates, char icon, boolean isSittable) {
        super(coordinates, icon);
        this.isSittable = isSittable;
    }

    public EmptySpace(int x, int y, char icon, boolean isSittable) {
        super(new Coordinates(x, y), icon);
        this.isSittable = isSittable;
    }
}