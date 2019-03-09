import java.util.List;

public class MaximizeEmptySpace extends Goal {
    static String title = "Maximize empty space and place rest of furniture";

    public MaximizeEmptySpace() {
        super(MaximizeEmptySpace.title);
    }

    public Room execute(Room room) {
        //System.out.println("START EMPTY SPACE EXECUTE");

        char empty = EmptySpace.icon;

        List<Furniture> emptyList = room.unplacedFurniture.get(empty);

        int count = -1;
        Coordinates max = new Coordinates(-1, -1);


        for (int y = 1; y < room.yDimension; y++) {

            for (int x = 1; x < room.xDimension; x++) {

                boolean result = room.isOpen(x, y);

                if (result) {
                    int curCount = 0;//size of square not -1
                    boolean intersect = false; // intersected some object
                    while (!intersect && x + curCount < room.xDimension && y + curCount < room.yDimension) // while within the space of the room and not hitting anything
                    {
                        int iteration = curCount + 1;

                        if (room.isOpen(x + iteration, y) && room.isOpen(x, y + iteration)) // check edges of square of size iteration + 1
                        {
                            for (int i = 1; i <= iteration; i++) // check interior of square of size iteration + 1
                            {
                                if (!room.isOpen(x + iteration, y + i) || !room.isOpen(x + i, y + iteration)) {
                                    intersect = true; // hit something
                                }
                            }
                        } else {
                            intersect = true; // hit something
                        }
                        if (intersect) {
                            if (iteration - 1 > count) // hit something at iteration
                            {
                                max = new Coordinates(x, y);
                                count = iteration - 1;
                            }
                        } else if (x + curCount == room.xDimension - 1 || y + curCount == room.yDimension - 1) // next step is invalid and square is good so far
                        {
                            if (iteration > count) {
                                max = new Coordinates(x, y);
                                count = iteration;
                            }


                        }
                        curCount++;
                    }

                }

            }
        }
            //start the fill in
//            System.out.println(max.x + "," + max.y);
//            System.out.println(count);
            for (int i = 0; i <= count; i++) {
                for (int j = 0; j <= count; j++) {
                    Furniture emptySpace = emptyList.get(0);

                    room.placeFurniture(emptySpace, max.x + i, max.y + j);

                }
            }

            System.out.println(room.unplacedFurniture);

            System.out.println(room.unplacedFurniture.keySet());

            for(int i = 0; i < room.xDimension; i++)
            {
                for(int j = 0; j<room.yDimension; j++)
                {
                    if(room.isOpen(i,j))
                    {

                    }
                }
            }

            //System.out.println(count);
            return room;


        }

    }
