package homework09.utils;

import homework09.data.Student;

import java.io.*;
import java.util.List;

public class FileWriter {

    //Task 2.2.3.1
    public static <T extends Serializable> boolean writeBinFile(String path, List<T> data) {

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(path)))
        {
            oos.writeObject(data);

        } catch (FileNotFoundException e) {
            System.err.println("Что-то не так с файлом, " + e.getMessage());
            return false;
        } catch (IOException e) {
            System.err.println("Что-то совсем не так, " + e.getMessage());
            return false;
        }
        return true;
    }

    //Task 2.2.3.2
    public static boolean writeTextFile(String path, List<Student> data) {

        try (BufferedWriter bufWriter  = new BufferedWriter(
                new java.io.FileWriter(path)))
        {
            bufWriter.write("{\"Students\":[");
            int i = data.size() - 1;

            for (Student student : data) {
                bufWriter.write(student.toStringJson());
                if (data.size() != 0) {
                    bufWriter.write(",");
                }
                i--;
            }

            bufWriter.write("]}");

        } catch (FileNotFoundException e) {
            System.err.println("Что-то не так с файлом, " + e.getMessage());
            return false;
        } catch (IOException e) {
            System.err.println("Что-то совсем не так, " + e.getMessage());
            return false;
        }
        return true;
    }

    //Task 2.2.3.2 My
    public static boolean writeTextFileForHuman(String path, List<Student> data) {

        try (BufferedWriter bufWriter  = new BufferedWriter(
                new java.io.FileWriter(path)))
        {
            bufWriter.write("Students:\n");
            int i = 1;
            for (Student student : data) {
                bufWriter.write(Integer.toString(i) + '\t');
                bufWriter.write(student.toStringToFileForHuman());
                if (i != data.size()){
                    bufWriter.write('\n');
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Что-то не так с файлом, " + e.getMessage());
            return false;
        } catch (IOException e) {
            System.err.println("Что-то совсем не так, " + e.getMessage());
            return false;
        }
        return true;
    }

}
