package homework06.ver1;

import homework06.dto.Animal;

import java.util.Collection;
import java.util.Comparator;
import java.util.Random;

public class SortCollection<ITEM> {
    private final Random rnd = new Random();
    private Collection<ITEM> collect;

    public SortCollection(Collection<ITEM> collection) {
        this.collect = collection;
    }


    private void sortAnimal(Comparator comparator, Collection<Animal> collection) {
        if (collection == null) {
            return;
        }
        Animal[] animalArray = collection.toArray(new Animal[collection.size()]);
        Animal tmp;
        for (int i = 0; i < animalArray.length - 1; i++) {
            for (int j = 0; j < animalArray.length - 1; j++) {
                if (comparator.compare(animalArray[j], animalArray[j + 1]) > 0) {
                    tmp = animalArray[j];
                    animalArray[j] = animalArray[j + 1];
                    animalArray[j + 1] = tmp;
                }
            }
        }
    }
}
