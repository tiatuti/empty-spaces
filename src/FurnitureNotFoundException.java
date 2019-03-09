class FurnitureNotFoundException extends RuntimeException {

    public FurnitureNotFoundException() {
        super("The furniture you are trying to place has not been added to room's Map of unplaced furniture");
    }
}