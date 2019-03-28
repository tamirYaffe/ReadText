import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;
import java.util.TreeMap;

public class CorpusCreater {
    Map<String,String> data;
    String output;


    public CorpusCreater(String outputPath){

        output=outputPath;
        data = new TreeMap<String, String>();
    }


    public void add(String fileName, String txt) {
        if(fileName == null || txt == null || fileName =="" || txt == "") {
            System.out.println("bracha input error - did not add the file to the corpus");
            return;
        }
        data.put(fileName,txt);

    }


    public void createCorpose() {
        if(data.isEmpty()){
            System.out.println("corpus is empty - file not created");
            return;
        }
        try {
            File folder = new File(output);
            folder.mkdir();
            File corpus = new File(output+"/corpus");


            FileWriter fw = new FileWriter(corpus);
            BufferedWriter bf = new BufferedWriter(fw);


            for (String fileName : data.keySet()) {
                bf.write("<Doc>\n" +
                        "<DOCNO> "+fileName+" </DOCNO>\n"
                        +"<Text>\n"
                        + data.get(fileName)+" \n"
                        +"<Text>\n<Doc>\n");
            }

            bf.close();
        }catch (Exception e){
            System.out.println("bracha IO Exeption");
            System.out.println(e);
            return;
        }


        System.out.println("corpus created");

    }
}
