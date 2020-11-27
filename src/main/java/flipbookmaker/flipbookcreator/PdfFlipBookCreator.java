package flipbookmaker.flipbookcreator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImage;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import flipbookmaker.flipbookcreator.exceptions.StatementNotImplementedException;
import flipbookmaker.parser.model.Statement;
import flipbookmaker.parser.model.StaticStatement;

public class PdfFlipBookCreator implements FlipBookCreator {



    @Override
    public void createFlipBook(String outputFilePath, List<Statement> flipProgram) {
        PDDocument document = new PDDocument();

        int i = 1;
        try {
            for (Statement st : flipProgram) {
                System.out.println("Statement #" + i++);
                switch (st.getType()) {
                    case STATIC:
                        processStaticFlips(document, (StaticStatement)st);
                        break;
                    case DYNAMIC:
                    case HYBRID:
                        throw new StatementNotImplementedException();
                }
            }

            if(!outputFilePath.contains(".pdf")) outputFilePath += ".pdf";
            document.save(outputFilePath);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
      
    }

    void processStaticFlips(PDDocument document, StaticStatement st) throws IOException {
        PDPage page;
        PDPageContentStream contentStream;

        List<String> images = st.getImagePaths();
        ArrayList<PDImageXObject> pdImages = new ArrayList<>(images.size());

        for(String path:images){
            pdImages.add(PDImageXObject.createFromFile(path, document));
        }

        PDRectangle mediaBox;
        float width, height;
        float startX, startY;
        PDImage pdImage;

        for(int i=1;i<=st.getNoOfPages();i++){
            page = new PDPage();
            document.addPage(page);
            System.out.println("Added page #" + i);

            contentStream = new PDPageContentStream(document, page);
            pdImage = pdImages.get(0);
            mediaBox = page.getMediaBox();

            width = Math.min(mediaBox.getWidth(), pdImage.getWidth());
            height = Math.min(mediaBox.getHeight(), pdImage.getHeight());

            startX = (mediaBox.getWidth() - width)/2;
            startY = (mediaBox.getHeight() - height)/2;

            // Center an image
            contentStream.drawImage(pdImages.get(0), startX, startY , width, height);

            contentStream.close();
            
        }

    }
    
}
