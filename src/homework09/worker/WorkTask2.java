package homework09.worker;

import homework09.data.Student;
import homework09.utils.FileManager;
import homework09.utils.FileWriter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class WorkTask2 {

    public void run() {

        int numberNOfTopStudents = 100;

        List<Student> streamFromFile = FileManager.getDataFromFile();
        String pathBin = FileManager.getPath() + FileManager.getNameFileOfTopStudents();
        String pathTxt = FileManager.getPath() + FileManager.getNameFileOfTopStudentsTxt();


        List<Student> topNStudents =
                streamFromFile.stream()
                .sorted(Comparator.comparing(Student::getAssessment).reversed().thenComparing(Student::compareByStringParam))
                .limit(numberNOfTopStudents)
                .collect(Collectors.toList());

        topNStudents.forEach(System.out::println);

        FileWriter.writeBinFile(pathBin, topNStudents);
        FileWriter.writeTextFileForHuman(pathTxt, topNStudents);
    }
}
