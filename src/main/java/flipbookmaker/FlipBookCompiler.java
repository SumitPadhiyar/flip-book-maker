package flipbookmaker;

import java.io.IOException;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import flipbookmaker.flipbookcreator.FlipBookCreator;
import flipbookmaker.flipbookcreator.PdfFlipBookCreator;
import flipbookmaker.parser.Parser;
import flipbookmaker.parser.model.Statement;

public class FlipBookCompiler {
    public static void main(String[] args) {
        Options options = new Options();
        Option output = new Option("o", "output", true, "output file path");
        options.addOption(output);

        Option input = new Option("i", "input", true, "input file path");
        input.setRequired(true);
        options.addOption(input);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);

            String inputFilePath = cmd.getOptionValue("input");
            String outputFilePath = cmd.getOptionValue("output");
             
            List<Statement> program = Parser.parse(inputFilePath);

            if(outputFilePath == null){
                outputFilePath = inputFilePath.substring(0, inputFilePath.lastIndexOf('.'));    
            }

            FlipBookCreator flipBookCreator = new PdfFlipBookCreator();
            flipBookCreator.createFlipBook(outputFilePath, program);

        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);
        } catch(IOException e){
            e.printStackTrace();
        }
    }    
}
