package flipbookmaker.parser.model;

import java.util.List;

public class DynamicStatement extends Statement {
    private List<MotionImageInfo> motionImageInfos;

    public DynamicStatement(int pages, List<MotionImageInfo> motionImageInfos) {
        super(pages);
        this.motionImageInfos = motionImageInfos;
    }

    public List<MotionImageInfo> getMotionImageInfos() {
        return motionImageInfos;
    }

    @Override
    public StatementType getType() {
        return StatementType.DYNAMIC;
    }
    
}
