package gateway;

public interface ReadWriter {
    /**
     * @param filepath location of ser file
     * @param o object to be serialized
     */
    void saveToFile(String filepath, Object o);

    /**
     * @param filepath location of ser file
     */
    Object readFromFile(String filepath);
}
