package homework09.data;

import java.io.Serializable;

public class Student implements Serializable, IStudentsComparator<Student> {
//public class Student implements Serializable {

    private String firstName;
    private String lastName;
    private String middleName;
    private String firstLastMiddleName;
    private int assessment;

    public Student(String firstName, String lastName, String middleName, int assessment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.firstLastMiddleName = lastName + " " + firstName + " "  + middleName;
//        this.firstLastMiddleName = lastName.substring(0,1).toUpperCase() +
//                firstName.substring(0,1).toUpperCase() +
//                middleName.substring(0,1).toUpperCase();
        this.assessment = assessment;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFirstLastMiddleName() {
        return firstLastMiddleName;
    }

    public int getAssessment() {
        return assessment;
    }

    @Override
    public String toString() {
        return "Студент " +
                "ФИО " + firstLastMiddleName +
                " - оценка = " + assessment;
    }

    @Override
    public int compareByAssessment(Student student) {
        return this.assessment + student.getAssessment();
    }

    @Override
    public int compareByStringParam(Student student) {
        if (student == null) {
            return Integer.MIN_VALUE;
        }
        int result = this.lastName.compareTo(student.getLastName());

        if (result == 0) {
            result = this.firstName.compareTo(student.getFirstName());
        }
        if (result == 0) {
            result = this.middleName.compareTo(student.getMiddleName());
        }
        return result;
    }
}
