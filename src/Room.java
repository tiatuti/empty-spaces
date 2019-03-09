import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Room {

    char[][] layout;
    int xDimension;
    int yDimension;
    List<Outlet> outlets = null;
    List<Window> windows = null;
    HashMap<Character, ArrayList<Furniture>> unplacedFurniture = new HashMap<>();
    HashMap<Character, ArrayList<Furniture>> placedFurniture = new HashMap<>();
    
    public static void main(String[] args) {


        // Good coords
        Coordinates correct = new Coordinates(5, 5);
        Coordinates tableTest = new Coordinates(6,6);

        // Bad coords
        Coordinates coordinates = new Coordinates(-1, 5);
        Coordinates coord2 = new Coordinates(0, 0);
        Coordinates coord3 = new Coordinates(0, 19);
        Coordinates coord4 = new Coordinates(9, 0);



        Outlet o1 = new Outlet(0, 1);
        Outlet o2 = new Outlet(5, 0);

        
        Window w1 = new Window(0, 1);
        Window w2 = new Window(5, 0);

        Furniture f = new Furniture(coordinates);
        // Furniture table = new Table(tableTest);

        ArrayList<Outlet> outlets = new ArrayList<>();
        ArrayList<Window> windows = new ArrayList<>();
        ArrayList<Furniture> furnatureList = new ArrayList<>();
        outlets.add(o1);
        outlets.add(o2);

        windows.add(w1);
        windows.add(w2);

        furnatureList.add(f);
        // furnatureList.add(table);

        // Creating test room of size 10, 20
        Room room = new Room(10, 20, outlets, windows, furnatureList);
        
        // Tests

        Furniture badFurniture = new Furniture(coordinates);
        // room.placeFurniture(table, tableTest);
        // room.placeFurniture(badFurniture, correct);
        // System.out.println(room.placeFurniture(f, coordinates));
        // System.out.println(room.placeFurniture(f, coord2));
        // System.out.println(room.placeFurniture(f, coord3));
        // System.out.println(room.placeFurniture(f, coord4));
        room.printLayout();

        System.out.println("\n");
        // room.unplaceFurniture(f);
        // room.printLayout();
    }

    public Room(int x, int y, List<Outlet> outlets, List<Window> windows, List<Furniture> furniture) {
        // NOTE: WINDOWS GET ADDED BEFORE OUTLETS

        this.outlets = outlets;
        this.windows = windows;
        addFurnitureToRoom(furniture);

        generateLayout(x, y);
        addWindows();
        addOutlets();
    }

    public void addFurnitureToRoom(List<Furniture> furniture) {
        for (Furniture furn : furniture) {
            addFurniture(furn);
        }
    }

    /**
     * Adds furniture to the list of unplaced furniture
     */
    public void addFurniture(Furniture f) {
        char type = f.getIcon();
        ArrayList<Furniture> list;
        if (unplacedFurniture.containsKey(type)) {
            list = unplacedFurniture.get(type);
        } else {
            list = new ArrayList<>();
        }
        list.add(f);
        unplacedFurniture.put(type, list);

    }

    public Room(int x, int y, List<Outlet> outlets, List<Window> windows) {
        // NOTE: WINDOWS GET ADDED BEFORE OUTLETS

        this.outlets = outlets;
        this.windows = windows;
        
        generateLayout(x, y);
        addWindows();
        addOutlets();
    }

    /**
     * This method adds Windows to the room layout
     */
    public void addWindows() {
        for (Window w : windows) {
            int x = w.getX();
            int y = w.getY();

            // Don't want outlets in the corners, which is why ranges are set as such
            boolean onTopWall = ((0 == x) && (0 < y) && (y < yDimension - 1));

            if (onTopWall) {
                addToGrid(w);
            }
        }
    }

    /**
     * This method adds outlets to the room layout so it displays properly
     */
    public void addOutlets() {
        ArrayList<Outlet> toRemove = new ArrayList<>();

        for (Outlet o : outlets) {
            int x = o.getX();
            int y = o.getY();

            // Don't want outlets in the corners, which is why ranges are set as such
            boolean onTopWall = ((0 == x) && (0 < y) && (y < yDimension - 1));

            boolean onLeftWall = ((0 == y) && (0 < x) && (x < xDimension));
            boolean onRightWall = ((yDimension - 1 == y) && (0 < x) && (x < xDimension));

            if (onTopWall || onLeftWall || onRightWall) {
                if (!addToGrid(o)) {
                    // If not added successfully to grid, this means have to remove outlet
                    toRemove.add(o);
                }
            }
        }

        for (Outlet o : toRemove) {
            outlets.remove(o);
        }
    }

    /**
     * Adds a generic element to the grid
     * @param o The object to be added
     */
    public boolean addToGrid(GridObject o) {
        int x = o.getX();
        int y = o.getY();

        char curr = this.layout[x][y];
        
        // Only overwrite if it's a wall object, empty space object, or something else
        if ((curr == '-') || (curr == ' ') || (curr == '|')) {
            this.layout[x][y] = o.icon;
            return true;
        } else {
            return false;
        }

    }

    
    public boolean addToGrid(GridObject o, Coordinates pos) {
        int x = pos.x;
        int y = pos.y;
        return addToGrid(o, x, y);
    }

    public boolean addToGrid(GridObject o, int x, int y) {
        char curr = this.layout[x][y];
        
        // Only overwrite if it's a wall object, empty space object
        if ((curr == '-') || (curr == ' ') || (curr == '|')) {

            this.layout[x][y] = o.icon;

            // Updates the position
            o.setX(x);
            o.setY(y);
            return true;
        } else {
            return false;
        }

    }

    /**
     * This method generates an empty layout given an x and y dimensions
     * @param x an integer representing the number of rows
     * @param y an integer representing the number of columns
     */
    public void generateLayout(int x, int y) {
        this.layout = new char[x][y];
        this.xDimension = x;
        this.yDimension = y;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {

                boolean iNotZero = (i != 0);
                // O means empty space
                char ch = ' ';
                if (i == 0) {
                    ch = '-';
                } else if (((j == 0) && iNotZero) || ((j == yDimension - 1) && iNotZero)) {
                    // populate side walls
                    ch = '|';
                }
                this.layout[i][j] = ch;
            }
        }
    }

    /**
     * Prints out the layout of the grid
     */
    public void printLayout() {
        for (int i = 0; i < this.xDimension; ++i) {
            // System.out.println(Arrays.toString(this.layout[i]));

            String formattedString = Arrays.toString(this.layout[i])
                .replace(",", "")  //remove the commas
                .replace("[", "")  //remove the right bracket
                .replace("]", "")  //remove the left bracket
                .trim();
            System.out.println(formattedString);
        }
    }
    
    public boolean placeFurniture(Furniture f, Coordinates position) {
        int x = position.x;
        int y = position.y;
        
        // Bounds checking
        boolean withinRLWalls = ((1 <= x) && (x <= xDimension - 2));
        boolean withinTBWalls = ((1 <= y) && (y <= yDimension - 2));
        
        if (withinRLWalls && withinTBWalls) {
            // If we can successfully add it
            if (addToGrid(f, position)) {
                // Remove from unplaced and place in placed

                transerToPlaced(f);
                return true;
            }
        }
        
        return false;
        

    }
    /**
     * Overloaded method to take in furniture, x and y
     * @param f The furniture piece to remove
     * @param x The 'x' or 'row' position
     * @param y The 'y' or 'column' position
     */
    public boolean placeFurniture(Furniture f, int x, int y) {
        Coordinates c = new Coordinates(x, y);
        return this.placeFurniture(f, c);
    }

    /**
     * Removes furniture from the layout
     * @param f The furniture piece to remove
     */
    public void unplaceFurniture(Furniture f) {
        int f_x = f.getX();
        int f_y = f.getY();

        this.layout[f_x][f_y] = ' ';
        f.setX(-1);
        f.setY(-1);
    }

    /**
     * Removes an item from the unplaced list
     */
    private boolean removeFromUnplaced(Furniture f) {
        char icon = f.getIcon();
        if (unplacedFurniture.containsKey(icon)) {
            // Get the list of same types
            ArrayList<Furniture> sameTypes = unplacedFurniture.get(icon);

            // Iterate through sameTypes to find the exact ones we're looking for
            for (int i = 0; i < unplacedFurniture.size(); i++) {
                Furniture curr = sameTypes.get(i);

                // Found the exact one
                if (curr == f) {
                    sameTypes.remove(i);
                    unplacedFurniture.put(icon, sameTypes);
                    // System.out.println("Successfully removed from unplaced");
                    // System.out.println("Same Types size: " + sameTypes.size());
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * This method can be used to check if a space in the room is free or not
     */
    public boolean isOpen(int x, int y) {
        // Checks if its in the proper boundaries
        boolean left = (x >= 1);
        boolean right = (x <= xDimension - 2);
        boolean top = (y >= 1);
        boolean bottom = (y <= yDimension - 2);

        if (left && right && top && bottom) {
            char curr = this.layout[x][y];

            // If empty, then will have a ' ' in the space
            return (curr == ' ');
        } else {
            return false;
        }
    }

    public boolean isOpen(Coordinates c) {
        return isOpen(c.x, c.y);
    }

    /**
     * This method transfers items from the unplaced Hashmap to the placed Hashmap
     */
    private void transerToPlaced(Furniture f) {
        char icon = f.getIcon();
        // Get the list of the same types of furniture
        boolean removed = removeFromUnplaced(f);

        // Checks to make sure the furniture is in unplaced furniture list.
        if (!removed) {
            throw new FurnitureNotFoundException();
        }

        ArrayList<Furniture> sameTypes = unplacedFurniture.get(icon);

        for (Furniture curr : sameTypes) {
            if (f == curr) {
                // If we've found the object ID
                ArrayList<Furniture> list = new ArrayList<>();
                
                if (placedFurniture.containsKey(icon)) {
                    list = placedFurniture.get(icon);
                }
                list.add(f);
                placedFurniture.put(icon, list);
                // System.out.println("Successfully added to placed furniture hashmap");
            }
        }

    }
}
