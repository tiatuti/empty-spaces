import java.util.List;


public class MaximizeTVSpace extends Goal{
    static String title = "Set TV";

    public MaximizeTVSpace() {
        super(MaximizeTVSpace.title);
    }

    public Room execute(Room room) {
        // Place TV
        char TVIcon = TV.icon;
        char Empty = EmptySpace.icon;
        char coffeeIcon = CoffeeTable.icon;
        char lounge = loungeChairs.icon;


        List<Furniture> TV = room.unplacedFurniture.get(TVIcon);
//        System.out.println(TV);
//        System.out.println(room.unplacedFurniture);
        List<Furniture> coffeeTables = room.unplacedFurniture.get(coffeeIcon);
//        System.out.println(coffeeTables);
        List<Furniture> loungeChairs = room.unplacedFurniture.get(lounge);
//        System.out.println(loungeChairs);

        // LOGIC
        boolean done = false;
        int backWall = room.yDimension-2-1;
        int leftWall = room.xDimension-1-1;
        int rightWall = room.xDimension-1-1;
        int fromTV = 1; // distance between TV and Coffee Tables - 0 is adjacent
        int fromTable = 2; // distance between Coffee Tables and Chairs - 1 is adjacent


if(!TV.isEmpty() || !coffeeTables.isEmpty() || !loungeChairs.isEmpty() || loungeChairs.size() >=3) {
    //Check TV against back wall - facing south
    Furniture tv = TV.get(0);
    Furniture coffeeTable = coffeeTables.get(0);
    Furniture chair1 = loungeChairs.get(0);
    Furniture chair2 = loungeChairs.get(1);
    Furniture chair3 = loungeChairs.get(2);

    while (!done & backWall > 0) {
        int xVal = 1;
        if (room.isOpen(xVal, backWall)) {
            boolean clearWay = true; // clear between TV and Table
            boolean clearWay2 = true; //clear between table and chairs
            for (int i = 1; i <= fromTV; i++) {
                if (!room.isOpen(xVal + i, backWall)) {
                    clearWay = false;
                }
            }
            if (clearWay) {
                for (int i = 1; i <= fromTable; i++) {
                    if (!(room.isOpen(xVal + fromTV + i, backWall) && room.isOpen(xVal + fromTV, backWall - i) && room.isOpen(xVal + fromTV, backWall + i))) // behind table,left of table,right of table
                    {
                        clearWay2 = false;
                    }
                }
            }
            if (clearWay2) {
                room.placeFurniture(tv, xVal, backWall);
                room.placeFurniture(coffeeTable, xVal + 1 + fromTV, backWall);
                room.placeFurniture(chair1, xVal + fromTV + 1 + fromTable, backWall);
                room.placeFurniture(chair2, xVal + fromTV + 1, backWall + fromTable);
                room.placeFurniture(chair3, xVal + fromTV + 1, backWall - fromTable);
                done = true;
            }
        }


        backWall--;


//

    }
}




        return room;
    }
}
