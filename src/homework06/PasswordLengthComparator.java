package homework06;

import java.util.Comparator;

public class PasswordLengthComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int result = o1.password.length() - o2.password.length();
            return result;
    }
}

