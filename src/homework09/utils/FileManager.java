package homework09.utils;

import homework09.data.Student;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static homework09.utils.FileReader.readBinFile;
import static homework09.utils.FileWriter.*;

public class FileManager {
    private static final String NAME_FILE_OF_STUDENTS = "students.bin";
    private static final String NAME_FILE_OF_STUDENTS_JSON = "students.json";
    private static final String NAME_FILE_OF_STUDENTS_TXT = "students.txt";
    private static final String NAME_FILE_OF_TOP_STUDENTS = "top.bin";
    private static final String NAME_FILE_OF_TOP_STUDENTS_TXT = "top.txt";
    //    private static final String DEFAULT_PATH = "";
    private static final String DEFAULT_PATH = "homework" + File.separator +
            "src" + File.separator + "res" + File.separator;
    private static String path;


    public static String getDefaultPath() {
        return DEFAULT_PATH;
    }

    public static String getNameFileOfTopStudents() {
        return NAME_FILE_OF_TOP_STUDENTS;
    }

    public static String getNameFileOfTopStudentsTxt() {
        return NAME_FILE_OF_TOP_STUDENTS_TXT;
    }

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        FileManager.path = path;
    }

    private static File getFileAndGenerateIfDonotFind() {
        boolean isWrittenFile = true;

        String path = getFilePathFromConsole();
        File file = new File(path);

        if (!file.exists() || file.isDirectory()) {
            path = DEFAULT_PATH + NAME_FILE_OF_STUDENTS;
            file = new File(path);
            if (!file.exists() || file.isDirectory()) {
                isWrittenFile = false;
                List<Student> studentsList = new ArrayList<>();

                GeneratorOfStudents.studentsGenerator(studentsList);

                isWrittenFile = writeBinFile(path, studentsList);

                writeTextFile(DEFAULT_PATH +
                        NAME_FILE_OF_STUDENTS_JSON, studentsList);

                writeTextFileForHuman(DEFAULT_PATH +
                        NAME_FILE_OF_STUDENTS_TXT, studentsList);
            }
        }
        if (!isWrittenFile) {
            System.err.println("Файл не был создан!");
            return null;
        }

        setPath(getPathWIthOutFileName(path));
        return file;
    }


    public static File getFileToRead() {
        String path = getFilePathFromConsole();
        File file = new File(path);

        if (!file.exists() || file.isDirectory()) {
            path = DEFAULT_PATH + NAME_FILE_OF_TOP_STUDENTS;
            file = new File(path);
        }

        setPath(getPathWIthOutFileName(path));

        return file;
    }


    private static String getFilePathFromConsole() {
        System.out.println("Введите путь и имя файла, и нажмите Enter");

        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();

        return path;
    }


    private static String getPathWIthOutFileName(String pathWithFileName) {
        String path = "";
        if (pathWithFileName != null) {
            int last = pathWithFileName.lastIndexOf(File.separator);
            if (last > 1) {
                path = pathWithFileName.substring(0, last + 1);
            }
        }
        return path;
     }


    public static <T extends Serializable> List<T> readFile(File file) {

        if (file == null) {
            System.err.println("Данные отсутсвуют!");
            System.exit(666);
        }

        boolean isReadFile = false;
        List<T> list = new ArrayList<>();

        isReadFile = readBinFile(file, list);

        if (!isReadFile) {
            System.err.println("Файл не был прочитан!");
            System.exit(555);
        }
        return list;
    }


    public static <T extends Serializable> List<T> getDataFromFile() {
        return readFile(getFileAndGenerateIfDonotFind());
    }


}
