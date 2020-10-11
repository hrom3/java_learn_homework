package homework06;

import homework06.dto.Person;

import java.util.Comparator;

public class PasswordLengthAndNickComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {

        int result = o1.compareTo(o2);
        if (result != 0) {
            return result;
        }
        return o1.getNick().compareTo(o2.getNick());
    }
}
