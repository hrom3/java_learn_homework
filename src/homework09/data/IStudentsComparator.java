package homework09.data;

public interface IStudentsComparator<T> {

    int compareByAssessment(T o1);
    int compareByStringParam(T o1);

}
