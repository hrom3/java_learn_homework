package homework06.dto;

import homework06.IComparator;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class Animal implements Comparable, IComparator {
    private int age;
    private String nick;

    public Animal(int age, String nick) {
        this.age = age;
        this.nick = nick;
    }

    public int getAge() {
        return this.age;
    }

    public boolean setAge(int age) {
        if (age >= 1 && age <= 15) {
            this.age = age;
            return true;
        }
        return  false;
    }

    public String getNick() {
        return this.nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Animal animal = (Animal) o;

        if (age != animal.age) {
            return false;
        }
        return this.nick != null ? this.nick.equals(animal.nick) : animal.nick == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (this.nick != null ? this.nick.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Кличка: " + nick +
                ", возраст " + age;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        return compareByAllFields(o);
    }

    public int compareByAllFields(@NotNull Object o) {
        int result = this.compareByOneField(o);
        if (result != 0) {
            return result;
        }
        Animal entry = (Animal) o;
        return this.getNick().compareTo(entry.getNick());
    }

    public int compareByOneField(@NotNull Object o) {
        Animal entry = (Animal) o;
        return this.age - entry.age;
    }

}
