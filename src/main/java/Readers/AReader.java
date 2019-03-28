package Readers;

public abstract class AReader {

    public abstract String readFile(String path);

    static public AReader readerFactory(String fileName){
        if (fileName.contains(".doc")){
            return new DocxReader();
        }
        else if (fileName.contains(".ppt")){
            return new PptxReader();
        }
        else if (fileName.contains(".pdf")){
            return new PdfReader();
        }
        else return null;
    }
}
