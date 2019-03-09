import java.util.List;

public class MaximizeWindowUsage extends Goal {
    static String title = "Maximize Window Usage";

    public MaximizeWindowUsage() {
        super(MaximizeWindowUsage.title);
    }

    public Room execute(Room room) {
        char icon = KitchenTable.icon;
        List<Furniture> kitchenTables = room.unplacedFurniture.get(icon);
        
        // Don't do anything if there are no kitchen tables
        if ((kitchenTables == null) || kitchenTables.isEmpty()) {
            return room;
        }

        Furniture kt = kitchenTables.get(0);

        // Will put the table next to a window where the chairs face each other. If it cannot, then it will just choose the first window
        boolean success = false;
        for (Window w : room.windows) {
            int w_x = w.getX();
            int w_y = w.getY();

            // Checks to see if this window is "ideal", namely has a space open right below it and has opportunity for two chairs to face each other
            Coordinates left = new Coordinates(w_x + 1, w_y - 1);
            Coordinates directBelow = new Coordinates(w_x + 1, w_y);
            Coordinates right = new Coordinates(w_x + 1, w_y + 1);

            boolean isIdeal = (room.isOpen(left) && room.isOpen(directBelow) && room.isOpen(right));
            
            if (isIdeal) {
                room.placeFurniture(kt, w_x + 1, w_y);
                success = true;
                break;
            }

        }

        if (!success) {

            // Makes sure there are windows
            if (!room.windows.isEmpty()) {
                Window w = room.windows.get(0);
                Coordinates c = w.coordinates.getOneBelow();
                room.placeFurniture(kt, c);
            }

        }
        return room;
    }
}