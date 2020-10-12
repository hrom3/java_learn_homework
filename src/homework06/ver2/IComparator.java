package homework06.ver2;

public interface IComparator<T> {
    int compareByOneField(T o);
    int compareByAllFields(T o);
}
