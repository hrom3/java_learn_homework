package homework06;

import org.jetbrains.annotations.NotNull;

public class Animal implements Comparable {
    private int age;
    private String nick;

    public Animal(int age, String nick) {
        this.age = age;
        this.nick = nick;
    }

    public int getAge() {
        return age;
    }

    public boolean setAge(int age) {
        if (age >= 1 && age <= 15) {
            this.age = age;
            return true;
        }
        return  false;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (age != animal.age) return false;
        return nick != null ? nick.equals(animal.nick) : animal.nick == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (nick != null ? nick.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Кличка: " + nick +
                ", возраст " + age;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        Animal entry = (Animal) o;
        return this.nick.compareTo(entry.nick);
    }
}
