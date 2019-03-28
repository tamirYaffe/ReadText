public interface ICorpusCreater {
    /**
     * add a file to the corpus
     * @param fileName - file ID
     * @param txt - the content of the file
     */
    void add(String fileName,String txt);

    /**
     * creates a corpus file.
     */
    void createCorpose();
}
