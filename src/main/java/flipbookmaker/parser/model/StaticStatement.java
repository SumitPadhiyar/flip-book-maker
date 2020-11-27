package flipbookmaker.parser.model;

import java.util.List;

public class StaticStatement extends Statement {
    private List<String> imagePaths;
    private Layout layout;

    public StaticStatement(int pages, Layout layout, List<String> imagePaths) {
        super(pages);
        this.layout = layout;
        this.imagePaths = imagePaths;    
    }

    @Override
    public StatementType getType() {
        return StatementType.STATIC;
    }

    public List<String> getImagePaths() {
        return imagePaths;
    }

    public Layout getLayout() {
        return layout;
    }
    
}
