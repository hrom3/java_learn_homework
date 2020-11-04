package homework09.worker;

import homework09.data.Student;
import homework09.utils.FileManager;

import java.io.File;
import java.util.Collections;
import java.util.List;


public class WorkTask5Ver2 {

    public void run() {

        int numberNOfLastStudentsFromFile = 100;

        String path = FileManager.getPath() + FileManager.getNameFileOfTopStudents();
        List<Student> topStudentsLastN = FileManager.readFile(new File(path));
        Collections.reverse(topStudentsLastN);

        topStudentsLastN.stream()
                .limit(numberNOfLastStudentsFromFile)
                .forEach(System.out::println);

    }
}
