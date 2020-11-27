package flipbookmaker.parser.model;

public class MotionImageInfo {
    private Coordinates start, end;
    private String imagePath;

    public MotionImageInfo(Coordinates start, Coordinates end, String imagePath) {
        this.start = start;
        this.end = end;
        this.imagePath = imagePath;
    }

    public Coordinates getEnd() {
        return end;
    }

    public Coordinates getStart() {
        return start;
    }

    public String getImagePath() {
        return imagePath;
    }    
}
