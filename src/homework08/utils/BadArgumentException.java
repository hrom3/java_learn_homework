package homework08.utils;

/**
 *  Данный эксепшен выбрасывается, если не верный формат даты в аргументах
 *  командной строки.
 */
public class BadArgumentException extends IllegalArgumentException {

    public BadArgumentException() {
        super("The program is launched with bad date argument."/* The current date is used."*/);
    }
    public BadArgumentException(String s) {
        super(s);
    }
}
