package homework06.dto;

import org.jetbrains.annotations.NotNull;

public class Person implements Comparable {
    String nick;
    String password;

    public Person(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        if (password.length() > 10 || password.length() < 5) {
            return false;
        }
        this.password = password;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;

        if (nick != null ? !nick.equals(person.nick) : person.nick != null) {
            return false;
        }
        return password != null ? password.equals(person.password)
                : person.password == null;
    }

    @Override
    public int hashCode() {
        int result = nick != null ? nick.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Имя: " + nick +
                ", \t password: " + password + ".";
    }

    @Override
    public int compareTo(@NotNull Object o) {
        Person entry = (Person) o;
        return this.password.length() - entry.password.length();
    }
}
