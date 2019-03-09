import java.util.List;

public class MaximizeOutletUsage extends Goal {
    static String title = "Maximize Outlet Usage";

    public MaximizeOutletUsage() {
        super(MaximizeOutletUsage.title);
    }
    
    public Room execute(Room room) {
        // We want to place end tables by outlets
        char icon = EndTable.icon;

        List<Furniture> tables = room.unplacedFurniture.get(icon);

        // Systematically place an end table by all outlets

        for (Outlet o : room.outlets) {
            if ((tables == null) || tables.isEmpty()) {
                break;
            } else {
                // Just continue getting the first table and placing it
                Furniture t = tables.get(0);
                int o_x = o.getX();
                int o_y = o.getY();

                // Account for "corner" outlets, e.g. situations where an outlet is next to a window
                boolean placeRight = (o_y - 1 < 0);
                boolean placeBottom = (o_x - 1 < 0);
                // boolean placeLeft = (o_y + 1 > room.yDimension - 1);

                if (placeRight) {
                    room.placeFurniture(t, o_x, o_y + 1);
                } else if (placeBottom) {
                    room.placeFurniture(t, o_x + 1, o_y);     
                } else {
                    room.placeFurniture(t, o_x, o_y - 1);
                }

            }
        }
        return room;
    }
}