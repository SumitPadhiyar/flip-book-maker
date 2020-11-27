package flipbookmaker.parser.model;

public enum Layout {
    VERTICAL, HORIZONTAL, SUPERIMPOSE;

    public static boolean isValid(String layout){
        layout = layout.toUpperCase();

        return VERTICAL.name().equalsIgnoreCase(layout)
            || HORIZONTAL.name().equalsIgnoreCase(layout)
            || SUPERIMPOSE.name().equalsIgnoreCase(layout);

    }

    public static Layout fromString(String layout) {
        return Layout.valueOf(layout.toUpperCase());
    }
    
}
