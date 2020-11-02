package homework09;

//import homework09.data.IStudentsComparator;

import homework08.WriteFile;
import homework09.data.IStudentsComparator;
import homework09.data.Student;
import homework09.utils.FileManager;
import homework09.utils.FileWriter;
import utils.RandomMy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Work {

    public void runTask3() {

        int numberN = 20;

        List<Student> streamFromFile = FileManager.getDataFromFile();
        String path = FileManager.getPath() + FileManager.getNameFileOfTopStudents();

        List<Student> topNStudents =
                streamFromFile.stream()
                .sorted(Comparator.comparing(Student::getAssessment).reversed().thenComparing(Student::compareByStringParam))
                .limit(numberN)
                .collect(Collectors.toList());

        topNStudents.forEach(System.out::println);

        FileWriter.writeBinFile(path, topNStudents);



//        streamFromGenerator.stream()
//                .sorted(((o1, o2) -> o2.compareByAssessment(o1)))
//                .limit(numberN)
//                .sorted(((o1, o2) -> o2.compareByStringParam(o1)))
//
//                .forEach(System.out::println);

    }
}
