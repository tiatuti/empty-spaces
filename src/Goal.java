public abstract class Goal {
    // Goals modify a room, and return the modified room
    String title;
    String description;
    public Goal(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Goal(String title) {
        this.title = title;
    }
    
    abstract Room execute(Room room);
}