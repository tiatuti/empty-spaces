import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int x_size = 10;
        int y_size = 20;
        Coordinates correct = new Coordinates(5, 5);
        Coordinates tableTest = new Coordinates(6,6);

        // Declaring all the stuff
        Furniture f = new Furniture(-1, -1);



        Outlet o1 = new Outlet(5, y_size - 1);
        Outlet o2 = new Outlet(5, 0);
        Outlet o3 = new Outlet(0, 5);

        Window w1 = new Window(0, 1);
        Window w2 = new Window(0, 8);

        KitchenTable kt = new KitchenTable(0,0);

        // Declaring the lists
        ArrayList<Outlet> outlets = new ArrayList<>();
        ArrayList<Window> windows = new ArrayList<>();
        ArrayList<Furniture> fs = new ArrayList<>();



        // Adding all the stuff

        outlets.add(o1);
        outlets.add(o2);
        outlets.add(o3);
        windows.add(w1);
        // windows.add(w2);

        fs.add(f);
        fs.add(kt);

        // Adding a whole bunch of end tables
        for (int i = 0; i < 10; i++) {
            fs.add(new EndTable(-1, -1));
        }

        // Creating test room of size 10, 20
        Room room = new Room(10, 20, outlets, windows, fs);
        
        // room.placeFurniture(f, correct);
        // room.placeFurniture(table, tableTest);

        ArrayList<Goal> subgoals = new ArrayList<>();
        subgoals.add(new MaximizeOutletUsage());
        subgoals.add(new MaximizeWindowUsage());

        for (Goal g : subgoals) {
            room = g.execute(room);
            System.out.println('\n');
            System.out.println("" + g.title + "---------------");
            room.printLayout();
        }
        System.out.println("\n");
        System.out.println("*****************FINAL********************\n");
        room.printLayout();

        for (int y = 1; y < y_size-1; y++) {

            for (int x = 1; x < x_size-1; x++) {

                boolean result = room.isOpen(x, y);

                if (result) {
                    System.out.println("x,y: " + "(" + x + "," + y + ")");
                }
                else {
                    System.out.println("============");
                }


            }

        }


    }
}
