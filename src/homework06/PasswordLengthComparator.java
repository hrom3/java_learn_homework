package homework06;

import homework06.dto.Person;

import java.util.Comparator;

public class PasswordLengthComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
            return o1.compareTo(o2);
    }
}

