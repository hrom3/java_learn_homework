package homework09;

//import homework09.data.IStudentsComparator;
import homework09.data.IStudentsComparator;
import homework09.data.Student;
import utils.RandomMy;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Work {

    public void run() {
       final Random rnd = new Random();
       int size = 1_000;
       int numberN = 20;

        List<Student> streamFromGenerator =
                Stream.generate(() ->  new Student(
//                        RandomMy.randomNextStringRus(rnd.nextInt(20) + 5),
//                        RandomMy.randomNextStringRus(rnd.nextInt(20) + 3),
                        RandomMy.randomNextName(),
                        RandomMy.randomNextName(),
                        RandomMy.randomNextStringRus(rnd.nextInt(20) + 5),
                        rnd.nextInt(10) + 1))
                .limit(size)
                .collect(Collectors.toList());

        streamFromGenerator.stream()
                .sorted(Comparator.comparing(Student::getAssessment).reversed().thenComparing(Student::compareByStringParam))
                .limit(numberN)
                .forEach(System.out::println);


//        streamFromGenerator.stream()
//                .sorted(((o1, o2) -> o2.compareByAssessment(o1)))
//                .limit(numberN)
//                .sorted(((o1, o2) -> o2.compareByStringParam(o1)))
//
//                .forEach(System.out::println);

    }
}
