package flipbookmaker.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import flipbookmaker.parser.exceptions.InvalidFlipFileException;
import flipbookmaker.parser.exceptions.InvalidFlipFileExtensionException;
import flipbookmaker.parser.model.Coordinates;
import flipbookmaker.parser.model.DynamicStatement;
import flipbookmaker.parser.model.HybridStatement;
import flipbookmaker.parser.model.Layout;
import flipbookmaker.parser.model.MotionImageInfo;
import flipbookmaker.parser.model.Statement;
import flipbookmaker.parser.model.StaticStatement;

public class Parser {

    private static final String FLIP_FILE_EXTENSION = "flip";

    public static List<Statement> parse(String flipFilePath) throws IOException {
        
        if(!checkFileExtension(flipFilePath)) throw new InvalidFlipFileExtensionException();

        ArrayList<Statement> statements;
        
        try (BufferedReader br = new BufferedReader(new FileReader(flipFilePath))) {
            statements = new ArrayList<>();

            String line;
            while((line = br.readLine()) != null){
                statements.add(processLine(line));
            }
        }

        return statements;
    } 

    private static boolean checkFileExtension(String filePath){
        int index = filePath.lastIndexOf('.');
        if(index < 1) return false;
        return filePath.substring(index+1).equals(FLIP_FILE_EXTENSION);
    }  

    private static Statement processLine(String line){

        try{
            String[] tokens = line.split(" ");
            int currentTokenIndex = 0;
            int pages = Integer.parseInt(tokens[currentTokenIndex++]);

            String layoutStr = tokens[currentTokenIndex];
            boolean isStatic = Layout.isValid(layoutStr);
            Layout staticLayout = null;
            ArrayList<String> imagePaths = null;

            if(isStatic){
                staticLayout = Layout.fromString(layoutStr);
                currentTokenIndex++;
                
                int images = Integer.parseInt(tokens[currentTokenIndex++]);

                if(images < 1) throw new InvalidFlipFileException();

                imagePaths = new ArrayList<>(images);

                for(int i=0;i<images; i++,currentTokenIndex++){
                    imagePaths.add(tokens[currentTokenIndex]);
                }
            }

            boolean isDynamic = currentTokenIndex < tokens.length;
            ArrayList<MotionImageInfo> motionImageInfos = null;

            if(isDynamic){
                int images = Integer.parseInt(tokens[currentTokenIndex++]);

                if(images < 1) throw new InvalidFlipFileException();

                motionImageInfos = new ArrayList<>(images);

                String imagePath;
                Coordinates start, end;
                for(int i=0;i<images; i++){
                    imagePath = tokens[currentTokenIndex++];
                    start = new Coordinates(Integer.parseInt(tokens[currentTokenIndex]), Integer.parseInt(tokens[currentTokenIndex+1]));
                    currentTokenIndex += 2;

                    end = new Coordinates(Integer.parseInt(tokens[currentTokenIndex]), Integer.parseInt(tokens[currentTokenIndex+1]));
                    currentTokenIndex += 2;

                    motionImageInfos.add(new MotionImageInfo(start, end, imagePath));

                }
            }
            
            Statement statement = null;
            if(isStatic){
                statement = new StaticStatement(pages, staticLayout,imagePaths);
            }else if (isDynamic){
                statement = new DynamicStatement(pages, motionImageInfos);
            }else{
                statement = new HybridStatement(pages, imagePaths, motionImageInfos);
            }
            
            return statement;

        }catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
            throw new InvalidFlipFileException();
        }

    }

}
