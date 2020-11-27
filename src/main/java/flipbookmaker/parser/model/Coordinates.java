package flipbookmaker.parser.model;

public class Coordinates {
    private int startX, startY;

    public Coordinates(int X, int Y) {
        startX = X;
        startY = Y;
    }

    public int getStartY() {
        return startY;
    }

    public int getStartX() {
        return startX;
    }

}
