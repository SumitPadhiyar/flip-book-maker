package flipbookmaker.parser.model;

public enum Layout {
    VERTICAL, HORIZONTAL, SUPERIMPOSE;

    public static boolean isValid(String layout){
        
        return VERTICAL.name().equals(layout)
            || HORIZONTAL.name().equals(layout)
            || SUPERIMPOSE.name().equals(layout);

    }
    
}
