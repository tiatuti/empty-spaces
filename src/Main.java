import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int x_size = 10;
        int y_size = 20;
        Coordinates correct = new Coordinates(5, 5);
        Coordinates tableTest = new Coordinates(6,6);

        // Declaring all the stuff
        Furniture f = new Furniture(-1, -1);

        TV tv = new TV(0,0,false);

        CoffeeTable ct = new CoffeeTable(0,0);

        loungeChairs c1 = new loungeChairs(0,0,true);
        loungeChairs c2 = new loungeChairs(0,0,true);
        loungeChairs c3 = new loungeChairs(0,0,true);




        Outlet o1 = new Outlet(5, y_size - 1);
        Outlet o2 = new Outlet(5, 0);
        Outlet o3 = new Outlet(0, 5);
        Outlet o4 = new Outlet(0,y_size-3);
        Outlet o5 = new Outlet(0,y_size-2);

        Window w1 = new Window(0, 1);
        Window w2 = new Window(0, 8);

        KitchenTable kt = new KitchenTable(0,0);

        // Declaring the lists
        ArrayList<Outlet> outlets = new ArrayList<>();
        ArrayList<Window> windows = new ArrayList<>();
        ArrayList<Furniture> furnatureList = new ArrayList<>();



        // Adding all the stuff

        outlets.add(o1);
        outlets.add(o2);
        outlets.add(o3);
        //outlets.add(o4);
        //outlets.add(o5);

        windows.add(w1);
        windows.add(w2);

        furnatureList.add(f);
        furnatureList.add(kt);

        furnatureList.add(tv);

        furnatureList.add(ct);

        furnatureList.add(c1);
        furnatureList.add(c2);
        furnatureList.add(c3);

        // Adding a whole bunch of end tables
        for (int i = 0; i < 20; i++) {
            furnatureList.add(new EndTable(-1, -1));
        }

        for (int i = 0; i<x_size*y_size; i++)
        {
            furnatureList.add(new EmptySpace(-1,-1,false));
        }

        // Creating test room of size 10, 20
        Room room = new Room(x_size, y_size, outlets, windows, furnatureList);
        
        // room.placeFurniture(f, correct);
        // room.placeFurniture(table, tableTest);

        ArrayList<Goal> subgoals = new ArrayList<>();
        subgoals.add(new MaximizeOutletUsage());
        subgoals.add(new MaximizeWindowUsage());
        subgoals.add(new MaximizeTVSpace());
        subgoals.add(new MaximizeEmptySpace());

        for (Goal g : subgoals) {
            room = g.execute(room);
            System.out.println('\n');
            System.out.println("" + g.title + "---------------");
            room.printLayout();
        }
        System.out.println("\n");
        System.out.println("*****************FINAL********************\n");
        room.printLayout();
    }
}
