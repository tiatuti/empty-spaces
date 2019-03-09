public class loungeChairs extends Furniture {
    static char icon = 'L';
    boolean isSittable = false;

    public loungeChairs(Coordinates coordinates, boolean isSittable){
        super(coordinates, TV.icon);
        this.isSittable = isSittable;
    }
    public loungeChairs(int x, int y, boolean isSittable) {
        super(new Coordinates(x, y), loungeChairs.icon);
        this.isSittable = isSittable;
    }

    public loungeChairs(Coordinates coordinates, char icon, boolean isSittable) {
        super(coordinates, icon);
        this.isSittable = isSittable;
    }

    public loungeChairs(int x, int y, char icon, boolean isSittable) {
        super(new Coordinates(x, y), icon);
        this.isSittable = isSittable;
    }
}

