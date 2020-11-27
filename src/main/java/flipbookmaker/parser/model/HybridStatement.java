package flipbookmaker.parser.model;

import java.util.List;

public class HybridStatement extends Statement {
    private List<String> staticImageInfos;
    private List<MotionImageInfo> motionImageInfos;

    public HybridStatement(int pages, List<String> staticImageInfos, List<MotionImageInfo> motionImageInfos) {
        super(pages);
        this.staticImageInfos = staticImageInfos;
        this.motionImageInfos = motionImageInfos;
    }

    @Override
    public StatementType getType() {
        return StatementType.HYBRID;
    }

    public List<MotionImageInfo> getMotionImageInfo() {
        return motionImageInfos;
    }

    public List<String> getStaticImageInfos() {
        return staticImageInfos;
    }    
}
