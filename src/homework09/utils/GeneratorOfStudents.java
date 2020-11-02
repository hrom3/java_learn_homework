package homework09.utils;

import homework09.data.Student;
import utils.RandomMy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GeneratorOfStudents {

    private static final Random RND = new Random();
    private static final int SIZE = 1_0;

    public static void studentsGenerator(List<Student> studentList) {

        studentList.addAll(
            Stream.generate(() ->  new Student(
                   RandomMy.randomNextStringRus(RND.nextInt(20) + 5), // случайный набор букв
                    RandomMy.randomNextStringRus(RND.nextInt(20) + 3), // случайный набор букв
//                    RandomMy.randomNextName(), // из файла. Внимание! Тупит!
 //                   RandomMy.randomNextName(),// из файла. Внимание! Тупит!
                    RandomMy.randomNextStringRus(RND.nextInt(1) + 5),
                    RND.nextInt(10) + 1))
                    .limit(SIZE)
                    .collect(Collectors.toList())
        );
    }
}
