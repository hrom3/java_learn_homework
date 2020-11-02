package homework09.utils;

import java.io.*;
import java.util.Date;
import java.util.List;

public class FileReader {

    public static <T extends Serializable> boolean readBinFile(File file,
                                                                List<T> data) {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            data.addAll((List<? extends T>) ois.readObject());

        } catch (FileNotFoundException e) {
            System.err.println("Что-то не так с файлом, " + e.getMessage());
            return false;
        } catch (IOException e) {
            System.err.println("Что-то совсем не так, " + e.getMessage());
            return false;
        } catch (ClassNotFoundException e) {
            System.err.println("Класс не найден, " + e.getMessage());
            return false;
        }
        return true;
    }
}
