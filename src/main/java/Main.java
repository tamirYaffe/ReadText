import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.sl.usermodel.PlaceableShape;
import org.apache.poi.xslf.usermodel.*;

public class Main {

    public static void main(String args[]) throws IOException {
        /*
        //Loading an existing document
        File file = new File("/Users/tamiryaffe/Desktop/part B q3 is q1.pdf");
        PDDocument document = PDDocument.load(file);

        //Instantiate PDFTextStripper class
        PDFTextStripper pdfStripper = new PDFTextStripper();

        //Retrieving text from PDF document
        String text = pdfStripper.getText(document);
        System.out.println(text);

        //Closing the document
        document.close();
        */
        readPPT();
    }

    public static void readPPT() throws IOException {
        File file = new File("/Users/tamiryaffe/Desktop/Practice3_.pptx");
        XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(file));
        // get slides
        for (XSLFSlide slide : ppt.getSlides()) {
            for (XSLFShape sh : slide.getShapes()) {
                // name of the shape
                String name = sh.getShapeName();
                // shapes's anchor which defines the position of this shape in the slide
                if (sh instanceof PlaceableShape) {
                    java.awt.geom.Rectangle2D anchor = ((PlaceableShape)sh).getAnchor();
                }

                if (sh instanceof XSLFConnectorShape) {
                    XSLFConnectorShape line = (XSLFConnectorShape) sh;
                    // work with Line
                } else if (sh instanceof XSLFTextShape) {
                    XSLFTextShape shape = (XSLFTextShape) sh;
                    // work with a shape that can hold text
                    System.out.println(shape.getText());
                } else if (sh instanceof XSLFPictureShape) {
                    XSLFPictureShape shape = (XSLFPictureShape) sh;
                    // work with Picture
                }
            }
        }
    }
}