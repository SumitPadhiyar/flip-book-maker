package flipbookmaker.parser.exceptions;

public class InvalidFlipFileExtensionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return "Flip file must have .flip extension";
    }

}