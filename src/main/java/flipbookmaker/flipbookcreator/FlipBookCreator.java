package flipbookmaker.flipbookcreator;

import java.util.List;

import flipbookmaker.parser.model.Statement;

public interface FlipBookCreator {

    public void createFlipBook(String outputFilePath, List<Statement> flipProgram);
    
}
