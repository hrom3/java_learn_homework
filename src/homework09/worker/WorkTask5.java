package homework09.worker;

import homework09.data.Student;
import homework09.utils.FileManager;

import java.util.*;
import static homework09.utils.FileManager.getFileToRead;


public class WorkTask5 {

    public void run() {

        int numberNOfLastStudentsFromFile = 100;

//        String path = FileManager.getDefaultPath() + FileManager.getNameFileOfTopStudents();
        List<Student> topStudentsLastN = FileManager.readFile(getFileToRead());

        int numberOfItemsToSkip = 0;
        if (topStudentsLastN.size() > numberNOfLastStudentsFromFile) {
            numberOfItemsToSkip = topStudentsLastN.size()-numberNOfLastStudentsFromFile;
        }

        topStudentsLastN.stream()
                .skip(numberOfItemsToSkip)
                .limit(numberNOfLastStudentsFromFile)
                .forEach(System.out::println);

    }
}
