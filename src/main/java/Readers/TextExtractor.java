package Readers;

import CorpusConvert.*;

import java.io.File;

public class TextExtractor {
    String sysSeparator = System.getProperty("file.separator");
    File mainDir; //the directory where all the docx, pptx, pdf files are in
    String outputDir; //the directory where all the text files will be written into

    public TextExtractor(File mainDir, String ourputPath) {
        this.mainDir = mainDir;
        outputDir = ourputPath;
    }

    /**
     * read the given directory
     * @return a list of string array so: ans[0] = course_name, ans[1] = file_name, ans[2] = file_text
     */
    public void readDirectories(){
        try {
            File[] subDirs = mainDir.listFiles();
//            double  n = 1;
//            double size = subDirs.length+1;
//            int progress = 0;
//            int last = -1;
            for (File subDir: subDirs){
                if (subDir.isDirectory()){
//                    progress = (int)Math.floor((n / size) * 100);
                    readDirectory(subDir);

//                    if(last!=progress){
//                        System.out.println(progress+"%");
//                        last = progress;
//                    }
                }
//                n++;
            }
        }
        catch (Exception e){
            System.out.println("TextExtractor.readDirectories()");
        }
    }

    private void readDirectory(File subDir) {
        String courseDir = outputDir + sysSeparator + subDir.getName();
        ICorpusCreater iCorpusCreater = new CorpusCreater(courseDir);
        File[] files = subDir.listFiles();
        if (files != null){
            for (File file: files){
                FileInfo fileInfo = getFileInfo(file, subDir.getName());
                iCorpusCreater.add(file.getPath(), fileInfo);
            }
            iCorpusCreater.createCorpose();
        }

    }

    private FileInfo getFileInfo(File file, String courseName) {
        AReader fileReader = AReader.readerFactory(file.getName());
        String fileText = fileReader.readFile(file.getPath());
        FileInfo ans = new FileInfo(file.getName(), courseName, fileText);
        return ans;
    }
}
